package com.jihan.jibio.login;

/**
 * Tanggal  : 5 Aug 2019
 * Nim      : 10116356
 * Nama     : Jihan Candri Dinasty
 * Kelas    : AKB-8
 */

import com.jihan.jibio.BasePresenter;
import com.jihan.jibio.BaseView;
import com.jihan.jibio.User;

public class LoginContract {
    interface Presenter extends BasePresenter{
        void callData(String  username,String  password);
    }

    interface View extends BaseView<Presenter>{
        void showLoading (boolean active);

        void onSuccessLogin(User user);
        void onFailedLogin();

    }
}

