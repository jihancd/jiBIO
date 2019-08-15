package com.jihan.jibio.onboarding;

/**
 * Tanggal  : 5 Aug 2019
 * Nim      : 10116356
 * Nama     : Jihan Candri Dinasty
 * Kelas    : AKB-8
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.jihan.jibio.R;


public class OnboardDua extends Fragment {
    ImageView ivKontak;
    TextView tvKontak;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_onboard_dua, container, false);
        ivKontak = view.findViewById(R.id.iv_kontak_onboard);
        tvKontak = view.findViewById(R.id.tv_kontak_onboard);

        Animation bottomToTop = AnimationUtils.loadAnimation(getActivity(),R.anim.bottom_to_top);
        Animation bottomToTop2 = AnimationUtils.loadAnimation(getActivity(),R.anim.bottom_to_top2);

        ivKontak.startAnimation(bottomToTop);
        tvKontak.startAnimation(bottomToTop2);

        return view;
    }
}
