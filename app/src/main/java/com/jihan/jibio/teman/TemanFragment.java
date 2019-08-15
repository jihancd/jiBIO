package com.jihan.jibio.teman;

/**
 * Tanggal  : 5 Aug 2019
 * Nim      : 10116356
 * Nama     : Jihan Candri Dinasty
 * Kelas    : AKB-8
 */

import android.app.Dialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jihan.jibio.R;
import com.jihan.jibio.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TemanFragment extends Fragment implements TemanContract.View {

    private TemanContract.Presenter mPresenter;
    private List<User> userList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Button btnEdit;
    private FrameLayout frameLayout;
    private Dialog dialog;

    TextView nim;
    TextView nama;
    TextView kelas;
    TextView email;
    TextView phone;
    TextView instagram;
    TextView facebook;
    LinearLayout linearLayout;


    public TemanFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new TemanPresenter(frameLayout, this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_teman, container, false);
        recyclerView = view.findViewById(R.id.rv_teman_list);
        frameLayout = view.findViewById(R.id.TemanLayout);
        setHasOptionsMenu(true);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new TemanAdapter(userList, mItemListener);

        DividerItemDecoration mDividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                1);
        recyclerView.addItemDecoration(mDividerItemDecoration);

        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void setLoadingIndicator(boolean active) {

    }

    @Override
    public void showListTeman(List<User> users) {
        userList.clear();
        userList.addAll(users);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showTemanDetailUI(final List<User> users, final User user, final int index) {
        // intent ke user detail
        final Dialog dialog = new Dialog(Objects.requireNonNull(getActivity()));
        dialog.setContentView(R.layout.activity_teman_detail);
        dialog.setTitle("My Dialog");

        nim = dialog.findViewById(R.id.tv_friend_detail_nim);
        nama = dialog.findViewById(R.id.tv_friend_detail_nama);
        kelas = dialog.findViewById(R.id.tv_friend_detail_kelas);
        email = dialog.findViewById(R.id.tv_friend_detail_email);
        phone = dialog.findViewById(R.id.tv_friend_detail_telepon);
        instagram = dialog.findViewById(R.id.tv_friend_detail_instagram);
        facebook = dialog.findViewById(R.id.tv_friend_detail_facebook);

        btnEdit = dialog.findViewById(R.id.btn_edit);

        nim.setText(user.getNim());
        nama.setText(user.getUsername());
        kelas.setText(user.getKelas());
        email.setText(user.getEmail());
        phone.setText(user.getPhone());
        instagram.setText(user.getInstagram());
        facebook.setText(user.getFacebook());

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setNim(nim.getText().toString());
                user.setUsername(nama.getText().toString());
                user.setKelas(kelas.getText().toString());
                user.setEmail(email.getText().toString());
                user.setPhone(phone.getText().toString());
                user.setInstagram(instagram.getText().toString());
                user.setFacebook(facebook.getText().toString());
                users.set(index, user);
                mAdapter = new TemanAdapter(users, mItemListener);
                recyclerView.setAdapter(mAdapter);
                dialog.dismiss();
                Snackbar.make(frameLayout, "Data Berhasil Diubah", Snackbar.LENGTH_LONG).show();
            }
        });

        dialog.show();
        Window window = dialog.getWindow();
        assert window != null;
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

    }

    @Override
    public void setPresenter(TemanContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start(getActivity());
    }


    // Saat salah satu item pada list di klik
    TemanListener mItemListener = new TemanListener() {
        @Override
        public void onTemanClick(List<User> users, User clickedListUser, int index) {
            mPresenter.openDetailTemanDetail(users, clickedListUser, index);

        }

        @Override
        public void onBtnCallClick(User clickedListUser) {
            mPresenter.onCallTeman(clickedListUser);
        }

        @Override
        public void onBtnDeleteClick(User clickedListUser) {
            mPresenter.onDeleteTeman(clickedListUser);
        }
    };

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.teman_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.i_tambah_teman) {
            dialog = new Dialog(Objects.requireNonNull(getActivity()));
            dialog.setContentView(R.layout.activity_teman_detail);
            dialog.setTitle("Tambah Teman");

            nim = dialog.findViewById(R.id.tv_friend_detail_nim);
            nama = dialog.findViewById(R.id.tv_friend_detail_nama);
            kelas = dialog.findViewById(R.id.tv_friend_detail_kelas);
            email = dialog.findViewById(R.id.tv_friend_detail_email);
            phone = dialog.findViewById(R.id.tv_friend_detail_telepon);
            instagram = dialog.findViewById(R.id.tv_friend_detail_instagram);
            facebook = dialog.findViewById(R.id.tv_friend_detail_facebook);
            btnEdit = dialog.findViewById(R.id.btn_edit);
            btnEdit.setText("Tambah");

            final User user = new User();
            nim.setText(user.getNim());
            nama.setText(user.getUsername());
            kelas.setText(user.getKelas());
            email.setText(user.getEmail());
            phone.setText(user.getPhone());
            instagram.setText(user.getInstagram());
            facebook.setText(user.getFacebook());

            btnEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    user.setNim(nim.getText().toString());
                    user.setUsername(nama.getText().toString());
                    user.setKelas(kelas.getText().toString());
                    user.setEmail(email.getText().toString());
                    user.setPhone(phone.getText().toString());
                    user.setInstagram(instagram.getText().toString());
                    user.setFacebook(facebook.getText().toString());

                    if (nim.getText().toString().isEmpty() || nama.getText().toString().isEmpty() || kelas.getText().toString().isEmpty()
                            || phone.getText().toString().isEmpty() || email.getText().toString().isEmpty()
                    ) {
                        Toast.makeText(getActivity(), "Data masih ada yang kosong!", Toast.LENGTH_LONG).show();
                    } else {
                        mPresenter.tambahTeman(user);
                    }

                    dialog.dismiss();
                }
            });


            dialog.show();
            Window window = dialog.getWindow();
            assert window != null;
            window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showMessage(String message) {
        Snackbar.make(frameLayout, message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showMessageSuccess(User user, String message) {
        Snackbar.make(frameLayout, message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showMessageFailed(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void callTeman(Intent intent) {
        startActivity(intent);
    }

    interface TemanListener {
        void onTemanClick(List<User> users, User clickedListUser, int index);

        void onBtnCallClick(User clickedListUser);

        void onBtnDeleteClick(User clickedListUser);
    }
}
