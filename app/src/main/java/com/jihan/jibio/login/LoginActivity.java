package com.jihan.jibio.login;

/**
 * Tanggal  : 5 Aug 2019
 * Nim      : 10116356
 * Nama     : Jihan Candri Dinasty
 * Kelas    : AKB-8
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.jihan.jibio.MainActivity;
import com.jihan.jibio.R;
import com.jihan.jibio.User;
import com.jihan.jibio.signup.SignupActivity;
import com.jihan.jibio.util.Preferences;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    private LoginContract.Presenter mPresenter;
    Button btnLogin;
    ProgressBar progressBar;

    EditText edtUsername, edtPassword;
    Button btnSignUp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();

        if (onLoginSucceed()) {
            startActivity(new Intent(this, MainActivity.class));
        }

        mPresenter = new LoginPresenter(this);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.callData(
                        Objects.requireNonNull(edtUsername.getText()).toString(),
                        Objects.requireNonNull(edtPassword.getText()).toString()
                );
            }
        });

    }

    boolean onLoginSucceed() {
        Preferences preferences = Preferences.getInstance(this);
        User user = preferences.getUserLogin();
        return !user.getUsername().equals("") && !user.getPassword().equals("");
    }

    @Override
    public void onSuccessLogin(User user) {
        Preferences preferences = Preferences.getInstance(this);
        preferences.saveLogin(user);
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public void onFailedLogin() {
        Toast.makeText(this, "Username atau Password salah", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void showLoading(boolean active) {
        if (active) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        mPresenter = presenter;
    }

    public void initView() {
        btnSignUp = findViewById(R.id.login_btn_signup);
        btnLogin = findViewById(R.id.login_btn_login);
        edtUsername = findViewById(R.id.login_txt_username);
        edtPassword = findViewById(R.id.login_txt_password);
        progressBar = findViewById(R.id.login_loading);
    }
}
