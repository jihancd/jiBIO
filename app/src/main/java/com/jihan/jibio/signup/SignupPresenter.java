package com.jihan.jibio.signup;

/**
 * Tanggal  : 5 Aug 2019
 * Nim      : 10116356
 * Nama     : Jihan Candri Dinasty
 * Kelas    : AKB-8
 */

import android.content.Context;

import com.jihan.jibio.User;
import com.jihan.jibio.repo.Repository;


public class SignupPresenter implements SignupContract.Presenter {
    private SignupContract.View mView;
    private Repository db;

    SignupPresenter(SignupContract.View mView) {
        this.mView = mView;
        db = Repository.getInstance((Context) mView);
    }

    @Override
    public void signup(User user) {
        if (!db.createUser(user)){
            mView.onFailedSignUp();
        } else {
            mView.onSuccessSignUp();
        }
    }

    @Override
    public void start() {
        mView.setLoadingIndicator(false);
    }
}
