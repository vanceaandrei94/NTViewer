package com.unbm.andrei.ntviewer.activities.login.config.mvp;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.unbm.andrei.ntviewer.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Andrei on 5/6/2017.
 */

public class LoginView extends FrameLayout {

    private static final String SIGN_IN_TITLE = "Sign In";
    private LoginPresenter presenter;

    // TODO: 5/6/2017 first of all build the views then bind them :))

    @BindView(R.id.btn_sign_in)
    Button signIn;

    @BindView(R.id.input_username)
    EditText usernameEt;

    @BindView(R.id.input_password)
    EditText passwordEt;

    private final ProgressDialog progressDialog = new ProgressDialog(getContext());

    public LoginView(@NonNull Context context) {
        super(context);
        inflate(getContext(), R.layout.activity_login, this);
        ButterKnife.bind(this);
        progressDialog.setMessage("Signing in...");
    }

    @OnClick(R.id.btn_sign_in)
    void signIn() {
        String username = usernameEt.getText().toString();
        String password = passwordEt.getText().toString();
        if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
            presenter.loginUser(username, password);
        } else {
            showToast("Fields must not be empty");
        }
    }

    public void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void showLoading(boolean show) {
        if (show) {
            progressDialog.show();
        } else {
            progressDialog.dismiss();
        }
    }

    public void setPresenter(LoginPresenter presenter) {
        this.presenter = presenter;
    }
}
