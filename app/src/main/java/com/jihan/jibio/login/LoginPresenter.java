package com.jihan.jibio.login;

/**
 * Tanggal  : 5 Aug 2019
 * Nim      : 10116356
 * Nama     : Jihan Candri Dinasty
 * Kelas    : AKB-8
 */

import android.content.Context;


import com.jihan.jibio.User;
import com.jihan.jibio.repo.Repository;


public class LoginPresenter implements LoginContract.Presenter{

    private final LoginContract.View mLoginView;

    private Repository db;

    public LoginPresenter(LoginContract.View mLoginView) {
        this.mLoginView = mLoginView;
        db = Repository.getInstance((Context) mLoginView);
    }

    @Override
    public void start() {
        mLoginView.showLoading(false);
    }

    @Override
    public void callData(String username, String password) {
        mLoginView.showLoading(true);
        User user = db.getUser(username, password);
        if (user == null) {
            mLoginView.onFailedLogin();
        } else {
            processLogin(user);
        }
        mLoginView.showLoading(false);
    }



    private void processLogin(User user ) {
        mLoginView.onSuccessLogin(user);

    }
    }
