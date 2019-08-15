package com.jihan.jibio.signup;

/**
 * Tanggal  : 5 Aug 2019
 * Nim      : 10116356
 * Nama     : Jihan Candri Dinasty
 * Kelas    : AKB-8
 */

import com.jihan.jibio.BasePresenter;
import com.jihan.jibio.BaseView;
import com.jihan.jibio.User;


public class SignupContract {
    interface Presenter extends BasePresenter {
        void signup(User user);

    }

    interface View extends BaseView<Presenter> {
        void onSuccessSignUp();

        void onFailedSignUp();

        void setLoadingIndicator(boolean active);
    }
}
