package com.jihan.jibio.kontak;

/**
 * Tanggal  : 5 Aug 2019
 * Nim      : 10116356
 * Nama     : Jihan Candri Dinasty
 * Kelas    : AKB-8
 */

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.jihan.jibio.R;

public class KontakFragment extends  Fragment {
    ImageView ivKotakPhone;
    ImageView ivKotakEmail;
    ImageView ivKotakIg;
    ImageView ivKotakF;

    TextView tvKontakPhone;
    TextView tvKontakEmail;
    TextView tvKontakIg;
    TextView tvKontakF;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_kontak, container, false);
        ivKotakPhone = view.findViewById(R.id.iv_kontak_phone);
        tvKontakPhone = view.findViewById(R.id.tv_kontak_phone);
        ivKotakEmail = view.findViewById(R.id.iv_kontak_email);
        tvKontakEmail = view.findViewById(R.id.tv_kontak_email);
        ivKotakIg = view.findViewById(R.id.iv_kontak_ig);
        tvKontakIg = view.findViewById(R.id.tv_kontak_ig);
        ivKotakF = view.findViewById(R.id.iv_kontak_f);
        tvKontakF = view.findViewById(R.id.tv_kontak_f);


        Animation bottomToTop = AnimationUtils.loadAnimation(getActivity(),R.anim.bottom_to_top);
        Animation bottomToTop2 = AnimationUtils.loadAnimation(getActivity(),R.anim.bottom_to_top2);

        ivKotakPhone.startAnimation(bottomToTop);
        tvKontakPhone.startAnimation(bottomToTop2);
        ivKotakEmail.startAnimation(bottomToTop);
        tvKontakEmail.startAnimation(bottomToTop2);
        ivKotakIg.startAnimation(bottomToTop);
        tvKontakIg.startAnimation(bottomToTop2);
        ivKotakF.startAnimation(bottomToTop);
        tvKontakF.startAnimation(bottomToTop2);



        return view;
    }
}
