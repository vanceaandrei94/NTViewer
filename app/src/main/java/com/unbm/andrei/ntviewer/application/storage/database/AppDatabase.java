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
        ProblemReportRealm problemReportRealm = problemReportIntoRealm(problemReport);
        realm.insertOrUpdate(problemReportRealm);
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
            problemReport.setLat(dbResult.getLat());
            problemReport.setLon(dbResult.getLon());
            problemReport.setActive(dbResult.isActive());
            reports.add(problemReport);
        }

        return reports;
    }

    public void resolveReport(int reportId) {
        realm.beginTransaction();
        ProblemReportRealm reportRealm = realm.where(ProblemReportRealm.class).equalTo("id", reportId).findFirst();
        if (reportRealm != null) {
            reportRealm.setActive(false);
            reportRealm.deleteFromRealm();
        }
        realm.commitTransaction();
    }

    private ProblemReportRealm problemReportIntoRealm(ProblemReport problemReport) {
        Number id = realm.where(ProblemReportRealm.class).max("id");
        int nextID = id != null ? id.intValue() + 1 : 1;
        ProblemReportRealm problemReportRealm = realm.createObject(ProblemReportRealm.class, nextID);
        problemReportRealm.setProblemType(problemReport.getProblemType());
        problemReportRealm.setProblemPriority(problemReport.getProblemPriority());
        problemReportRealm.setProblemDescription(problemReport.getProblemDetails());
        problemReportRealm.setLat(problemReport.getLat());
        problemReportRealm.setLon(problemReport.getLon());
        problemReportRealm.setActive(problemReport.isActive());
        problemReportRealm.setReportedAt(new GregorianCalendar().getTime());
        return problemReportRealm;
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
        problemReport.setActive(problemReportRealm.isActive());
        problemReport.setLat(problemReportRealm.getLat());
        problemReport.setLon(problemReportRealm.getLon());
        problemReport.setReportedAt(problemReportRealm.getReportedAt());
        problemReport.setId(problemReportRealm.getId());
        return problemReport;
    }
}
