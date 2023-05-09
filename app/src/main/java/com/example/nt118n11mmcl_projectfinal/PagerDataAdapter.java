package com.example.nt118n11mmcl_projectfinal;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerDataAdapter extends FragmentStatePagerAdapter {

    public PagerDataAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new AlarmFragment();
            case 1:
                return new DataTableFragment();
            default:
                return new AlarmFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
