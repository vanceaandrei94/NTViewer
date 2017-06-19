package com.unbm.andrei.ntviewer.util;

import android.app.AlertDialog;
import android.content.Context;

import com.unbm.andrei.ntviewer.R;

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

}
