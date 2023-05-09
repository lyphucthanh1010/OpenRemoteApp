package com.example.nt118n11mmcl_projectfinal;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class BoardPagerAdapter extends FragmentStatePagerAdapter {
    public BoardPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new OnboardingFragment1();
            case 1:
                return new OnboardingFragment2();
            case 2:
                return new OnboardingFragment3();

            default:
                return new OnboardingFragment1();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
