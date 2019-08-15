package com.jihan.jibio.onboarding;

/**
 * Tanggal  : 5 Aug 2019
 * Nim      : 10116356
 * Nama     : Jihan Candri Dinasty
 * Kelas    : AKB-8
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import com.jihan.jibio.R;
import com.jihan.jibio.login.LoginActivity;
import me.relex.circleindicator.CircleIndicator;

public class OnboardActivity extends AppCompatActivity {
    ViewPager viewPager;
    PagerAdapter pagerAdapter;
    CircleIndicator indicator;
    TextView btnDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboard);
        btnDone = findViewById(R.id.btn_done);

        viewPager = findViewById(R.id.vp_onboard);
        pagerAdapter = new OnBoardActivityAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        indicator = findViewById(R.id.indicator);

        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());
        setupViewPager(viewPager);


        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OnboardActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (viewPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }

    private void setupViewPager(ViewPager viewPager) {
        OnBoardActivityAdapter pagerAdapter = new OnBoardActivityAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(new OnboardSatu());
        pagerAdapter.addFragment(new OnboardDua());
        pagerAdapter.addFragment(new OnboardTiga());
        viewPager.setAdapter(pagerAdapter);
        indicator.setViewPager(viewPager);

    }

    public class ZoomOutPageTransformer implements ViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.85f;
        private static final float MIN_ALPHA = 0.5f;

        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();
            int pageHeight = view.getHeight();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0f);

            } else if (position <= 1) { // [-1,1]
                // Modify the default slide transition to shrink the page as well
                float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
                float vertMargin = pageHeight * (1 - scaleFactor) / 2;
                float horzMargin = pageWidth * (1 - scaleFactor) / 2;
                if (position < 0) {
                    view.setTranslationX(horzMargin - vertMargin / 2);
                } else {
                    view.setTranslationX(-horzMargin + vertMargin / 2);
                }

                // Scale the page down (between MIN_SCALE and 1)
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

                // Fade the page relative to its size.
                view.setAlpha(MIN_ALPHA +
                        (scaleFactor - MIN_SCALE) /
                                (1 - MIN_SCALE) * (1 - MIN_ALPHA));

            } else {
                // This page is way off-screen to the right.
                view.setAlpha(0f);
            }
        }
    }
}
