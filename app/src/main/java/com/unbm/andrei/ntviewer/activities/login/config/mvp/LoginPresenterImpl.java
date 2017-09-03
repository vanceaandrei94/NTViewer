package com.unbm.andrei.ntviewer.activities.login.config.mvp;

import com.unbm.andrei.ntviewer.R;
import com.unbm.andrei.ntviewer.util.LogoutTimer;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Andrei on 5/6/2017.
 */

public class LoginPresenterImpl implements LoginPresenter<ILoginView> {

    public static final String INVALID_CREDENTIALS = "Invalid Credentials";
    private ILoginView view;
    private LoginModel model;

    public LoginPresenterImpl(LoginModel model) {
        this.model = model;
    }

    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

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

    @Override
    public void attachView(ILoginView view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }

    private void userLoginFailed(Throwable throwable) {
        String message = throwable.getMessage();
        if (message.contains(INVALID_CREDENTIALS)) {
            view.showInvalidCredentialsError();
        } else {
            view.showGenericError();
        }
    }

    public void preLoginUser() {
        model.preLoginUser();
    }

}
