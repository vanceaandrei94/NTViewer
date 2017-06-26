package com.unbm.andrei.ntviewer.util;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.TextView;

import com.unbm.andrei.ntviewer.R;
import com.unbm.andrei.ntviewer.application.network.models.networkroute.NodeInfo;

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

        public NodeInfoDialog(@NonNull Context context, NodeInfo nodeInfo) {
            super(context);
            this.nodeInfo = nodeInfo;
        }
    }
}
