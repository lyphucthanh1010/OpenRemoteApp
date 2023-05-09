package com.example.nt118n11mmcl_projectfinal;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerGraphAdapter extends FragmentStatePagerAdapter {
    public PagerGraphAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Asset1Fragment();
            case 1:
                return new Asset2Fragment();
            case 2:
                return new Asset3Fragment();
            default:
                return new Asset1Fragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
