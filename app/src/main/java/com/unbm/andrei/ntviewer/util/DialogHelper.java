package com.unbm.andrei.ntviewer.util;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.TextView;

import com.unbm.andrei.ntviewer.R;
import com.unbm.andrei.ntviewer.application.network.models.networkroute.NodeInfo;
import com.unbm.andrei.ntviewer.models.ProblemReport;
import com.unbm.andrei.ntviewer.models.ProblemReportTranslator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Andrei on 6/19/2017.
 */

public class DialogHelper {

    public static AlertDialog showActivateGpsDialog(Context context) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context)
                .setTitle(context.getResources().getString(R.string.activate_gps_title))
                .setMessage(context.getResources().getString(R.string.activate_gps_message))
                .setPositiveButton(context.getResources().getString(R.string.activate_gps_button), (dialog, which) -> dialog.dismiss());
        return alertDialog.show();
    }

    public static void showNodeInfoDialog(Context context, NodeInfo nodeInfo) {
        NodeInfoDialog nodeInfoDialog = new NodeInfoDialog(context, nodeInfo);
        nodeInfoDialog.show();
    }

    public static void showProblemReportInfo(Context context, ProblemReport problemReport) {
        ProblemReportPopup problemReportPopup = new ProblemReportPopup(context);

        problemReportPopup.showReportPopup(ProblemReportTranslator.problemTypeToString(problemReport.getProblemType()),
                ProblemReportTranslator.priorityTypeToString(problemReport.getProblemPriority()),
                problemReport.getProblemDetails(),
                problemReport.getReportedAt());
        problemReportPopup.show();
    }

    static class NodeInfoDialog extends Dialog {

        private final NodeInfo nodeInfo;

        @BindView(R.id.node_id)
        TextView nodeId;

        @BindView(R.id.node_name)
        TextView name;

        @BindView(R.id.node_ip)
        TextView ip;

        @BindView(R.id.node_last_updated)
        TextView lastUpdated;

        public NodeInfoDialog(@NonNull Context context, NodeInfo nodeInfo) {
            super(context);
            this.nodeInfo = nodeInfo;
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.dialog_node_info);
            ButterKnife.bind(this);

            nodeId.setText(nodeInfo.getNodeId());
            name.setText(nodeInfo.getName());
            ip.setText(nodeInfo.getIp());
            lastUpdated.setText(nodeInfo.getLastUpdated());
        }
    }

    static class ProblemReportPopup extends AlertDialog {
        // TODO: 6/26/2017 Add view, and logic for this

        @BindView(R.id.problem_reported_at)
        TextView tvReportedAt;

        @BindView(R.id.problem_type)
        TextView tvProblemType;

        @BindView(R.id.problem_priority)
        TextView tvProblemPriority;

        @BindView(R.id.problem_details)
        TextView tvProblemDetails;

        public ProblemReportPopup(@NonNull Context context) {
            super(context);
        }

        public void showReportPopup(String problemType, String problemPriority, String problemDetails, Date reportedAt) {
            tvProblemType.setText(problemType);
            tvProblemPriority.setText(problemPriority);
            tvProblemDetails.setText(problemDetails);
            String date = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(reportedAt);
            tvReportedAt.setText(date);
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.dialog_problem_report);
            ButterKnife.bind(this);
        }
    }
}
