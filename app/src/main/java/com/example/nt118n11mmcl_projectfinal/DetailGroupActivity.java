package com.example.nt118n11mmcl_projectfinal;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nt118n11mmcl_projectfinal.Model.UserCurrent;
import com.example.nt118n11mmcl_projectfinal.Model.attributes;
import com.example.nt118n11mmcl_projectfinal.Model.childAssetType;
import com.example.nt118n11mmcl_projectfinal.Model.location;
import com.example.nt118n11mmcl_projectfinal.Model.location2;
import com.example.nt118n11mmcl_projectfinal.Model.notes;
import com.google.gson.Gson;

import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailGroupActivity extends AppCompatActivity {
    APIInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groupasset);
        Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
            return;
        }
        UserCurrent userCurrent = (UserCurrent) bundle.get("Asset");
        TextView tvtype = findViewById(R.id.group);
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
                for (int i =0 ; i< us.size() ; i++)
                {
                    if (us.get(i).getType().equals("GroupAsset"))
                    {
                        TextView tv= findViewById(R.id.tvweaid1);
                        TextView tv2= findViewById(R.id.tvweatemper1);
                        TextView tv3= findViewById(R.id.tvweahumi1);
                        Gson gson = new Gson();
                        String json = gson.toJson(us.get(i).attributes);
                        attributes attr = gson.fromJson(json, attributes.class);
                        json = gson.toJson(attr.childAssetType);
                        childAssetType childAssetType = gson.fromJson(json, com.example.nt118n11mmcl_projectfinal.Model.childAssetType.class);
                        json = gson.toJson(attr.notes);
                        notes note = gson.fromJson(json, notes.class);
                        json = gson.toJson(attr.location);
                        location2 loca = gson.fromJson(json, location2.class);
                        tv.setText(" "+ note.value);
                        tv2.setText(""+ loca.value2);
                        tv3.setText(""+childAssetType.value.toString());


                    }
                }
            }

            @Override
            public void onFailure(Call<List<UserCurrent>> call, Throwable t) {

            }
        });
    }
}
