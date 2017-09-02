package com.unbm.andrei.ntviewer.activities.login.config.mvp;

import com.unbm.andrei.ntviewer.activities.common.mvp.BasePresenter;
import com.unbm.andrei.ntviewer.util.LogoutTimer;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Andrei on 5/6/2017.
 */

public class LoginPresenter implements BasePresenter {

    private final ILoginView view;
    private final LoginModel model;

    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    public LoginPresenter(ILoginView view, LoginModel model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void onCreate() {
        preLoginUser();
    }

    @Override
    public void onDestroy() {
        compositeDisposable.dispose();
    }

    public void signInUser(String username, String password) {
        view.showLoading(true);
        compositeDisposable.add(model.loginUser(username, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnEach(__ -> view.showLoading(false))
                .subscribe(user -> {
                    model.startMainActivity(user);
                    LogoutTimer.getInstance().startTimer();
                }, ex -> userLoginFailed(ex))
        );
    }

    private void userLoginFailed(Throwable throwable) {
        String message = throwable.getMessage();
        view.showToast(message);
    }

    public void preLoginUser() {
        model.preLoginUser();
    }

}
