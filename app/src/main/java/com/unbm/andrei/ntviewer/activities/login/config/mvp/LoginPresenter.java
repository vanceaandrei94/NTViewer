package com.unbm.andrei.ntviewer.activities.login.config.mvp;

import com.unbm.andrei.ntviewer.activities.common.mvp.BasePresenter;
import com.unbm.andrei.ntviewer.models.User;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Andrei on 5/6/2017.
 */

public class LoginPresenter implements BasePresenter {

    private final LoginView view;
    private final LoginModel model;

    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    public LoginPresenter(LoginView view, LoginModel model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void onCreate() {
        compositeDisposable.add(preLoginUser());
    }

    @Override
    public void onDestroy() {
        compositeDisposable.dispose();
    }

    public void loginUser(String username, String password) {
        Disposable loginDisposable = model.loginUser(username, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(__ -> view.showLoading(true))
                .doOnEach(__ -> view.showLoading(false))
                .subscribe(user -> startNextActivity(user));
        compositeDisposable.add(loginDisposable);
    }

    public Disposable preLoginUser() {
        return model.preLoginUser()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(__ -> view.showLoading(true))
                .doOnEach(__ -> view.showLoading(false))
                .subscribe(user -> startNextActivity(user), __-> {});
    }

    private void startNextActivity(User user) {
        model.startMainActivity(user);
    }


}
