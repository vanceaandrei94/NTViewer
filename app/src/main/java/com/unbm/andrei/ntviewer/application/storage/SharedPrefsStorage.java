package com.unbm.andrei.ntviewer.application.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.unbm.andrei.ntviewer.models.User;

/**
 * Created by Andrei on 8/31/2017.
 */

public class SharedPrefsStorage implements SharedPrefsStorageInterface {

    private static final String APP_PREFS = "com.unbm.andrei.ntviewer.prefs";

    private static final String USERNAME_KEY = "username";
    private static final String USER_ID_KEY = "user_id";

    private static SharedPrefsStorage instance;

    private SharedPreferences preferences;

    private SharedPrefsStorage() {

    }

    public void init(Context context) {
        preferences = context.getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE);

    }

    public static SharedPrefsStorage getInstance() {
        if (instance == null) {
            instance = new SharedPrefsStorage();
        }
        return instance;
    }

    @Override
    public void saveLoggedInUser(User user) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(USERNAME_KEY, user.getUsername());
        editor.putInt(USER_ID_KEY, user.getId());
        editor.apply();
    }

    @Override
    public User getLoggedInUser() {
        String username = preferences.getString(USERNAME_KEY, "");
        int id = preferences.getInt(USER_ID_KEY, -1);
        if (TextUtils.isEmpty(username)) {
            return null;
        }
        return new User(username, id);
    }

    @Override
    public void removeLoggedUser() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(USERNAME_KEY);
        editor.remove(USER_ID_KEY);
        editor.apply();
    }
}
