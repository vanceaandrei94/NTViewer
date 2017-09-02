package com.unbm.andrei.ntviewer.util;

import com.unbm.andrei.ntviewer.application.storage.SharedPrefsStorage;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Andrei on 8/31/2017.
 */

public class LogoutTimer {

    private static LogoutTimer instance;

    private LogoutTimer() {

    }

    public static LogoutTimer getInstance() {
        if (instance == null) {
            instance = new LogoutTimer();
        }
        return instance;
    }

    public void startTimer() {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                SharedPrefsStorage.getInstance().removeLoggedUser();
            }
        };
        Timer timer = new Timer();
        timer.schedule(timerTask, 60000);
    }


}
