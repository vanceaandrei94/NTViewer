package com.unbm.andrei.ntviewer.activities.login.config.mvp;

import android.app.Activity;

import com.unbm.andrei.ntviewer.activities.main.MainActivity;
import com.unbm.andrei.ntviewer.application.network.NTVService;
import com.unbm.andrei.ntviewer.application.network.models.LoggedInUser;
import com.unbm.andrei.ntviewer.application.storage.SharedPrefsStorage;
import com.unbm.andrei.ntviewer.models.User;

import io.reactivex.Observable;

/**
 * Created by Andrei on 5/6/2017.
 */

public class LoginModelImpl implements LoginModel {

    public static final String ADMIN_USERNAME = "!admin";
    private static final String ADMIN_PASSWORD = "admin";

    public static final int ADMIN_USER_ID = -5;

    private final Activity activity;
    private NTVService service;

    public LoginModelImpl(Activity activity, NTVService service) {
        this.activity = activity;
        this.service = service;
    }

    @Override
    public void preLoginUser() {
        User user = getCachedUser();
        if (user != null) {
            startMainActivity(user);
        }
    }

    @Override
    public void startMainActivity(User user) {
        cacheUser(user);
        MainActivity.start(activity, user);
        activity.finish();
    }

    @Override
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

    private void cacheUser(User user) {
        SharedPrefsStorage.getInstance().saveLoggedInUser(user);
    }
}
