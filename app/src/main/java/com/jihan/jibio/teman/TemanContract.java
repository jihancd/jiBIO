package com.jihan.jibio.teman;

/**
 * Tanggal  : 5 Aug 2019
 * Nim      : 10116356
 * Nama     : Jihan Candri Dinasty
 * Kelas    : AKB-8
 */

import android.content.Context;
import android.content.Intent;

import com.jihan.jibio.BasePresenter;
import com.jihan.jibio.BaseView;
import com.jihan.jibio.User;

import java.util.List;


public class TemanContract {
    interface View extends BaseView<Presenter> {
        void setLoadingIndicator(boolean active);

        void showListTeman(List<User> users);

        void showTemanDetailUI(List<User> users, User user, int index);

        void showMessage(String message);

        void showMessageSuccess(User user, String message);

        void showMessageFailed(String message);

        void callTeman(Intent intent);
    }

    interface Presenter extends BasePresenter {
        void loadTeman(boolean forceUpdate);

        void tambahTeman(User user);

        void start(Context context);

        void openDetailTemanDetail(List<User> users, User requestedUser, int index);

        void onDeleteTeman(User user);

        void onCallTeman(User user);

        void onEditTeman(User user, List<User> users, int index);
    }
}
