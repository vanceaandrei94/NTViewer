package com.unbm.andrei.ntviewer.activities.login.config.mvp;

import com.unbm.andrei.ntviewer.activities.login.LoginActivity;
import com.unbm.andrei.ntviewer.activities.main.MainActivity;
import com.unbm.andrei.ntviewer.application.network.NTVService;
import com.unbm.andrei.ntviewer.application.network.models.LoggedInUser;
import com.unbm.andrei.ntviewer.application.storage.SharedPrefsStorage;
import com.unbm.andrei.ntviewer.models.User;

import io.reactivex.Observable;

/**
 * Created by Andrei on 5/6/2017.
 */

public class LoginModel {

    public static final String ADMIN_USERNAME = "!admin";
    private static final String ADMIN_PASSWORD = "admin";

    public static final int ADMIN_USER_ID = -5;
    private final LoginActivity activity;

    private NTVService service;

    public LoginModel(LoginActivity activity, NTVService service) {
        this.activity = activity;
        this.service = service;
    }

    public void preLoginUser() {
        User user = getCachedUser();
        if (user != null) {
            startMainActivity(user);
        }
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
        return new User(loggedInUser.getUsername());
    }

    private User getCachedUser() {
        return SharedPrefsStorage.getInstance().getLoggedInUser();
    }


    public void startMainActivity(User user) {
        cacheUser(user);
        MainActivity.start(activity, user);
        activity.finish();
    }

    private void cacheUser(User user) {
        SharedPrefsStorage.getInstance().saveLoggedInUser(user);
    }
}
