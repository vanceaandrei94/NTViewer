package com.unbm.andrei.ntviewer.activities.problem;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.jakewharton.rxbinding2.widget.RxTextView;
import com.unbm.andrei.ntviewer.R;
import com.unbm.andrei.ntviewer.activities.problem.config.dagger.DaggerReportProblemComponent;
import com.unbm.andrei.ntviewer.activities.problem.config.dagger.ReportProblemModule;
import com.unbm.andrei.ntviewer.activities.problem.config.mvp.ReportProblemPresenter;
import com.unbm.andrei.ntviewer.activities.problem.config.mvp.ReportProblemView;
import com.unbm.andrei.ntviewer.application.NTViewerApplication;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Andrei on 7/15/2017.
 */

public class ReportProblemActivity extends AppCompatActivity implements ReportProblemView {

    public static void start(Activity activity) {
        Intent intent = new Intent(activity, ReportProblemActivity.class);
        activity.startActivity(intent);
    }

    private ProgressDialog progressDialog;

    @Inject
    ReportProblemPresenter presenter;

    @BindView(R.id.problem_type_spinner)
    Spinner problemTypesSpinner;

    @BindView(R.id.problem_priority_spinner)
    Spinner problemPrioritySpinner;

    @BindView(R.id.continue_btn)
    Button continueBtn;

    @BindView(R.id.cancel_btn)
    Button cancelBtn;

    @BindView(R.id.problem_details_et)
    EditText problemDetailsEt;

    private ReportProblemViewModel viewModel = new ReportProblemViewModel();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerReportProblemComponent.builder()
                .appComponent(NTViewerApplication.get(this).getComponent())
                .reportProblemModule(new ReportProblemModule(this))
                .build().inject(this);

        setContentView(R.layout.activity_report_problem);
        ButterKnife.bind(this);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Sending Data...");
        presenter.onCreate();
        presenter.attachView(this);
        getSupportActionBar().setTitle("Report a problem");

        configure();
    }

    private void configure() {
        configureProblemTypesSpinner();
        configureProblemPrioritySpinner();
        RxTextView.textChanges(problemDetailsEt).subscribe(charSequence -> viewModel.problemDetails = charSequence.toString());
        cancelBtn.setOnClickListener(v -> finish());
        continueBtn.setOnClickListener(v -> presenter.reportProblem());

    }

    private void configureProblemPrioritySpinner() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.problem_priorities, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        problemPrioritySpinner.setAdapter(adapter);
        problemPrioritySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                viewModel.problemPriority = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                viewModel.problemPriority = 99;
            }
        });
    }

    private void configureProblemTypesSpinner() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.problem_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        problemTypesSpinner.setAdapter(adapter);
        problemTypesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                viewModel.problemType = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                viewModel.problemType = 99;
            }
        });
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void setBusy(boolean busy) {
        if (busy) {
            progressDialog.show();
        } else {
            progressDialog.dismiss();
        }
    }

    @Override
    public ReportProblemViewModel getViewModel() {
        return viewModel;
    }

    @Override
    public void finishActivity() {
        Toast.makeText(this, getString(R.string.problem_report_saved_successfully), Toast.LENGTH_SHORT).show();
        finish();
    }
}
