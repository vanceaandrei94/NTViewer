package com.unbm.andrei.ntviewer.application.storage.database;

import com.unbm.andrei.ntviewer.application.storage.database.model.ProblemReportRealm;
import com.unbm.andrei.ntviewer.models.ProblemReport;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by Andrei on 7/23/2017.
 */

public class AppDatabase {

    private static AppDatabase instance;

    private Realm realm;

    public static AppDatabase getInstance() {
        if (instance == null) {
            instance = new AppDatabase();
        }
        return instance;
    }

    private AppDatabase() {
        realm = Realm.getDefaultInstance();
    }

    public void saveProblemReport(ProblemReport problemReport) {
        realm.beginTransaction();
        Number id = realm.where(ProblemReportRealm.class).max("id");
        int nextID = id != null ? id.intValue() + 1 : 1;
        ProblemReportRealm problemReportRealm = realm.createObject(ProblemReportRealm.class, nextID);
        problemReportIntoRealm(problemReportRealm, problemReport);
        realm.commitTransaction();
    }

    public List<ProblemReport> getAllReports() {
        RealmResults<ProblemReportRealm> dbResults = realm.where(ProblemReportRealm.class).findAll();
        List<ProblemReport> reports = new ArrayList<>();
        for (ProblemReportRealm dbResult : dbResults) {
            ProblemReport problemReport = new ProblemReport();
            problemReport.setId(dbResult.getId());
            problemReport.setProblemType(dbResult.getProblemType());
            problemReport.setReportedAt(dbResult.getReportedAt());
            problemReport.setProblemPriority(dbResult.getProblemPriority());
            problemReport.setProblemDetails(dbResult.getProblemDescription());
            reports.add(problemReport);
        }

        return reports;
    }

    public void updateReport(int reportId, ProblemReport problemReport) {
        ProblemReportRealm reportRealm = realm.where(ProblemReportRealm.class).equalTo("id", reportId).findFirst();
        if (reportRealm != null) {
            realm.beginTransaction();
            problemReportIntoRealm(reportRealm, problemReport);
            realm.commitTransaction();
        }
    }

    private void problemReportIntoRealm(ProblemReportRealm problemReportRealm, ProblemReport problemReport) {
        problemReportRealm.setProblemType(problemReport.getProblemType());
        problemReportRealm.setProblemPriority(problemReport.getProblemPriority());
        problemReportRealm.setProblemDescription(problemReport.getProblemDetails());
        problemReportRealm.setReportedAt(new GregorianCalendar().getTime());
    }

    public ProblemReport getReportById(int id) {
        ProblemReportRealm problemReportRealm = realm.where(ProblemReportRealm.class).equalTo("id", id).findFirst();
        return problemReportRealmToProblemReport(problemReportRealm);
    }

    private ProblemReport problemReportRealmToProblemReport(ProblemReportRealm problemReportRealm) {
        ProblemReport problemReport = new ProblemReport();
        problemReport.setProblemDetails(problemReportRealm.getProblemDescription());
        problemReport.setProblemPriority(problemReport.getProblemPriority());
        problemReport.setReportedAt(problemReportRealm.getReportedAt());
        problemReport.setProblemType(problemReportRealm.getProblemType());
        return problemReport;
    }
}
