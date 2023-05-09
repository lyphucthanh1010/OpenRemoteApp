package com.example.nt118n11mmcl_projectfinal;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nt118n11mmcl_projectfinal.Model.History;
import com.example.nt118n11mmcl_projectfinal.Model.UserCurrent;
import com.example.nt118n11mmcl_projectfinal.Model.attributes;
import com.example.nt118n11mmcl_projectfinal.Model.consoleFlatform;
import com.example.nt118n11mmcl_projectfinal.Model.consoleProvider;
import com.example.nt118n11mmcl_projectfinal.Model.consoleVersion;
import com.example.nt118n11mmcl_projectfinal.Model.location2;
import com.example.nt118n11mmcl_projectfinal.Model.notes;
import com.google.gson.Gson;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailConsoleActivity extends AppCompatActivity {
    private  APIInterface apiInterface;

    private ListView lvContact;
    private Context context;

    public List<DataGraph> dataGraphs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consoleasset);
        Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
            return;
        }
        UserCurrent userCurrent = (UserCurrent) bundle.get("Asset");
        TextView tvtype = findViewById(R.id.console);
        tvtype.setText(userCurrent.getType());
        ImageView img = findViewById(R.id.backpic);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<List<UserCurrent>> call = apiInterface.getUsCurrent();
        call.enqueue(new Callback<List<UserCurrent>>() {
            @Override
            public void onResponse(Call<List<UserCurrent>> call, Response<List<UserCurrent>> response) {
                List<UserCurrent> us = response.body();
                for (int i =0 ; i< us.size() ; i++) {
                    if (us.get(i).getType().equals("ConsoleAsset")) {
                        TextView tv= findViewById(R.id.tvnote1);
                        TextView tv2= findViewById(R.id.tvlocation1);
                        TextView tv3= findViewById(R.id.tvweaid1);
                        TextView tv4= findViewById(R.id.tvweatemper1);
                        Gson gson = new Gson();
                        String json = gson.toJson(us.get(i).attributes);
                        attributes attr = gson.fromJson(json, attributes.class);
                        json = gson.toJson(attr.notes);
                        notes note= gson.fromJson(json, notes.class);
                        json = gson.toJson(attr.location);
                        location2 loca = gson.fromJson(json, location2.class);
                        json = gson.toJson(attr.consoleVersion);
                        consoleVersion conver = gson.fromJson(json, consoleVersion.class);
                        json = gson.toJson(attr.consolePlatform);
                        consoleFlatform conplat = gson.fromJson(json, consoleFlatform.class);
                        tv.setText(""+ note.value);
                        tv2.setText(""+ loca.value2);
                        tv3.setText(""+conver.value);
                        tv4.setText(""+conplat.value);

                    }
                }
            }

            @Override
            public void onFailure(Call<List<UserCurrent>> call, Throwable t) {

            }
        });

    }
}