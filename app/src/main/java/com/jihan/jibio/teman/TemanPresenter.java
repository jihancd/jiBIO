package com.jihan.jibio.teman;

/**
 * Tanggal  : 5 Aug 2019
 * Nim      : 10116356
 * Nama     : Jihan Candri Dinasty
 * Kelas    : AKB-8
 */

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.FrameLayout;


import com.jihan.jibio.User;
import com.jihan.jibio.repo.Repository;
import com.jihan.jibio.util.Preferences;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class TemanPresenter implements TemanContract.Presenter {

    private final TemanContract.View mView;

    private boolean mFirstLoad = true;

    private List<User> repository = new ArrayList<>();

    private Repository db;

    private Context context;

    TemanPresenter(FrameLayout frameLayout, TemanContract.View mView) {
        this.mView = mView;
        this.mView.setPresenter(this);
    }

    @Override
    public void start(Context context) {
        this.context = context;
        db = Repository.getInstance(context);
        start();
    }

    @Override
    public void start() {
        loadTeman(false);
    }

    @Override
    public void loadTeman(boolean forceUpdate) {
        loadTeman(forceUpdate || mFirstLoad, true);
        mFirstLoad = false;
    }

    private void loadTeman(boolean forceUpdate, final boolean showLoadingUI) {
        if (showLoadingUI) {
            mView.setLoadingIndicator(true);
        }

        if (forceUpdate) {
            Preferences preferences = Preferences.getInstance(context);
            User currentUser = preferences.getUserLogin();

                repository = db.getUsers();

        }

        if (showLoadingUI) {
            mView.setLoadingIndicator(false);
        }

        processTeman(repository);

    }

    private void processTeman(List<User> users) {
        mView.showListTeman(users);
    }


    @Override
    public void tambahTeman(User user) {
        if (db.createUser(user)){
            loadTeman(true);
            mView.showMessageSuccess(user, "Berhasil menambah teman");
        } else {
            mView.showMessageFailed("Gagal menambah teman");
        }
    }

    @Override
    public void openDetailTemanDetail(List<User> users, User requestedUser, int index) {
        mView.showTemanDetailUI(users, requestedUser, index);
    }

    @Override
    public void onDeleteTeman(final User user) {
        if (db.deleteUser(user)){
            repository.remove(user);
            mView.showListTeman(repository);
            mView.showMessage("Berhasil menghapus teman");
        } else {
            mView.showMessageFailed("Gagal menghapus teman");
        }
    }

    @Override
    public void onEditTeman(User user, List<User> users, int index) {
        users.set(index, user);
        mView.showListTeman(users);
    }

    @Override
    public void onCallTeman(User user) {
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("Phone:" + user.getPhone()));
        mView.callTeman(callIntent);
    }
}
