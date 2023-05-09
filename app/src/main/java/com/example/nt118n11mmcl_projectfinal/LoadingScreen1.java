package com.example.nt118n11mmcl_projectfinal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoadingScreen1 extends AppCompatActivity {
    Animation topAmin , bottomAmin;
    ImageView logo;
    TextView logoName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_loadingscreen_1);
        topAmin = AnimationUtils.loadAnimation(this,R.anim.top_anim);
        bottomAmin = AnimationUtils.loadAnimation(this,R.anim.bot_anim);
        logo = (ImageView) findViewById(R.id.logo);
        logoName = (TextView) findViewById(R.id.texttitle);

        logo.setAnimation(topAmin);
        logoName.setAnimation(bottomAmin);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable(){
            @Override
            public void run(){
                startActivity(new Intent(LoadingScreen1.this, OnBoardActivity.class));
                finish();
            }
        },3000);
    }
}
