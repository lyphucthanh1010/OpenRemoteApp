package com.example.nt118n11mmcl_projectfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.nt118n11mmcl_projectfinal.Model.UserCurrent;
import com.example.nt118n11mmcl_projectfinal.Model.attributes;
import com.example.nt118n11mmcl_projectfinal.Model.humidity;
import com.example.nt118n11mmcl_projectfinal.Model.temperature;
import com.example.nt118n11mmcl_projectfinal.Model.windSpeed;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    APIInterface apiInterface;
    ViewPager viewPager;
    Context context;
    Integer[] colors = null;
    RecyclerMainAdaptor adapter;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    List<UserCurrent> ListAsset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListAsset = new ArrayList<>();
        ImageSlider imageSlider = findViewById(R.id.imgslider);
        ArrayList<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.uit, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.nc, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.osmdroid, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.openremotelong, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.openremotedetail, ScaleTypes.FIT));
        imageSlider.setImageList(slideModels, ScaleTypes.FIT);
        RelativeLayout rlt1 = findViewById(R.id.map);
        rlt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RemoteActivity.class));
            }
        });
        RelativeLayout rlt4 = findViewById(R.id.graph);
        rlt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, GraphActivity.class));
            }
        });
        RelativeLayout rlt3 = findViewById(R.id.device);
        rlt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ActivityGetData.class));
            }
        });
    }
}