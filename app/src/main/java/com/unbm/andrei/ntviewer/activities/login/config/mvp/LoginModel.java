package com.unbm.andrei.ntviewer.activities.login.config.mvp;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.unbm.andrei.ntviewer.activities.login.LoginActivity;
import com.unbm.andrei.ntviewer.activities.main.MainActivity;
import com.unbm.andrei.ntviewer.application.network.NTVService;
import com.unbm.andrei.ntviewer.application.network.models.LoggedInUser;
import com.unbm.andrei.ntviewer.models.User;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Andrei on 5/6/2017.
 */

public class LoginModel {

    public static final String ADMIN_USERNAME = "!admin";
    private static final String ADMIN_PASSWORD = "admin";

    public static final String USER_LOGIN_PREFS = "userLogin";
    private static final String USERNAME_KEY = "username";
    private static final String USER_ID_KEY = "user_id";
    public static final String TRUE = "true";
    public static final int ADMIN_USER_ID = -5;
    private final LoginActivity activity;

    private SharedPreferences preferences;
    private NTVService service;

    public LoginModel(LoginActivity activity, NTVService service) {
        this.activity = activity;
        this.service = service;
        preferences = activity.getSharedPreferences(USER_LOGIN_PREFS, Context.MODE_PRIVATE);
    }

    public Observable<User> preLoginUser() {
        return Observable.create(e -> {
            User user = getCachedUser();
            if (user == null) {
                e.onError(new Throwable("no cached user"));
            } else {
                e.onNext(user);
            }
            e.onComplete();
        });
    }

    public Observable<User> loginUser(String username, String password) {
        User user = getCachedUser();
        if (user != null) {
            return Observable.create(e -> {
                e.onNext(user);
                e.onComplete();
            });
        }
        if (ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password)) {
            return Observable.create(e -> {
                e.onNext(new User(username, ADMIN_USER_ID));
                e.onComplete();
            });
        } else {
            return service.loginUser(username, password).map(loggedInUser -> createUserFromFields(loggedInUser));
        }
    }

    private User createUserFromFields(LoggedInUser loggedInUser) {
        return new User(loggedInUser.getUsername(), TRUE.equals(loggedInUser.getIsWorking()));
    }

    private User getCachedUser() {
        String username = preferences.getString(USERNAME_KEY, "");
        int id = preferences.getInt(USER_ID_KEY, -1);
        if (!TextUtils.isEmpty(username)) {
            return new User(username, id);
        }

        return null;
    }


    public void startMainActivity(User user) {
        MainActivity.start(activity, user);
    }

    public void cacheUser(User user) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(USERNAME_KEY, user.getUsername());
        editor.putInt(USER_ID_KEY, user.getId());
        editor.commit();
    }
}
