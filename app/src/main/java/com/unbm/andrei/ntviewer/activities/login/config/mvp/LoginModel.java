package com.unbm.andrei.ntviewer.activities.login.config.mvp;

import com.unbm.andrei.ntviewer.models.User;

import io.reactivex.Observable;

/**
 * Created by Andrei on 9/3/2017.
 */

public interface LoginModel {

    Observable<User> loginUser(String username, String password);

    void startMainActivity(User user);

    void preLoginUser();

}
