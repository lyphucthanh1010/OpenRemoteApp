package com.example.nt118n11mmcl_projectfinal;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.Date;

public class GraphActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigraph;
    private ViewPager ViewPagergraph;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager_graph);
        ViewPagergraph = findViewById(R.id.viewPagergraph);
        bottomNavigraph = findViewById(R.id.bottomNavigation);
        setViewPagerGraph();
//        getSupportActionBar().setTitle("Asset 1");
        bottomNavigraph.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch(id){
                    case R.id.asset1:
                        ViewPagergraph.setCurrentItem(0);
//                        getSupportActionBar().setTitle("Asset 1");
                        break;
                    case R.id.asset2:
                        ViewPagergraph.setCurrentItem(1);
//                        getSupportActionBar().setTitle("Asset 2");
                        break;
                    case R.id.asset3:
                        ViewPagergraph.setCurrentItem(3);
//                        getSupportActionBar().setTitle("Asset 3");
                        break;
                }
                return true;
            }
        });
    }
    public void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }
    private void setViewPagerGraph() {
        PagerGraphAdapter pagerGraphAdapter =new PagerGraphAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        ViewPagergraph.setAdapter(pagerGraphAdapter);
        ViewPagergraph.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        bottomNavigraph.getMenu().findItem(R.id.asset1).setChecked(true);
                        break;
                    case 1:
                        bottomNavigraph.getMenu().findItem(R.id.asset2).setChecked(true);
                        break;
                    case 2:
                        bottomNavigraph.getMenu().findItem(R.id.asset3).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
