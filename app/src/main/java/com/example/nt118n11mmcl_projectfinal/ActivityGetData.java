package com.example.nt118n11mmcl_projectfinal;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.Calendar;

public class ActivityGetData extends AppCompatActivity {
    TimePicker tpTimePicker;
    TextView tvResult;
    Button btnCreate;
    EditText edtTitle;
    EditText edtContent;
    int hour;
    static final String TAG = "MainActivity";
    Calendar calendar;
    PendingIntent pendingIntent;
    int minute;
    String title;
    String content;
    AlarmManager alarmManager;
    private BottomNavigationView bottomNavidata;
    private ViewPager ViewPagerdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager_data);
        ViewPagerdata = findViewById(R.id.viewPagerdata);
        bottomNavidata = findViewById(R.id.bottomNavigationdata);
        setViewPagerData();
        bottomNavidata.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch(id){
                    case R.id.alarm:
                        ViewPagerdata.setCurrentItem(0);
//                        getSupportActionBar().setTitle("Asset 1");
                        break;
                    case R.id.dtatable:
                        ViewPagerdata.setCurrentItem(1);
//                        getSupportActionBar().setTitle("Asset 2");
                        break;
                }
                return true;
            }
        });
    }

    private void setViewPagerData() {
        PagerDataAdapter pagerDataAdapter =new PagerDataAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        ViewPagerdata.setAdapter(pagerDataAdapter);
        ViewPagerdata.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        bottomNavidata.getMenu().findItem(R.id.alarm).setChecked(true);
                        break;
                    case 1:
                        bottomNavidata.getMenu().findItem(R.id.dtatable).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }

}
