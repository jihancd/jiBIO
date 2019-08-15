package com.jihan.jibio.biodata;

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

public class BiodataFragment extends Fragment {
    ImageView ivBiodata;
    TextView tvBiodataNama;
    TextView tvBiodataNim;
    TextView tvBiodataKelas;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_biodata, container, false);
        ivBiodata = view.findViewById(R.id.iv_biodata);
        tvBiodataNama = view.findViewById(R.id.tv_biodata_nama);
        tvBiodataNim = view.findViewById(R.id.tv_biodata_nim);
        tvBiodataKelas = view.findViewById(R.id.tv_biodata_kelas);

        Animation bottomToTop = AnimationUtils.loadAnimation(getActivity(),R.anim.bottom_to_top);
        Animation bottomToTop2 = AnimationUtils.loadAnimation(getActivity(),R.anim.bottom_to_top2);

        ivBiodata.startAnimation(bottomToTop);
        tvBiodataNama.startAnimation(bottomToTop2);
        tvBiodataNim.startAnimation(bottomToTop2);
        tvBiodataKelas.startAnimation(bottomToTop2);

        return view;
    }
}
