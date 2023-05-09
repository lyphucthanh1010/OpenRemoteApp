package com.example.nt118n11mmcl_projectfinal;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nt118n11mmcl_projectfinal.Model.UserCurrent;
import com.example.nt118n11mmcl_projectfinal.Model.attributes;
import com.example.nt118n11mmcl_projectfinal.Model.data;
import com.example.nt118n11mmcl_projectfinal.Model.location;
import com.example.nt118n11mmcl_projectfinal.Model.location2;
import com.example.nt118n11mmcl_projectfinal.Model.notes;
import com.example.nt118n11mmcl_projectfinal.Model.subscribeAttribute;
import com.example.nt118n11mmcl_projectfinal.Model.writeAttribute;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailThingActivity extends AppCompatActivity {
    private APIInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thingasset);
        Bundle bundle = getIntent().getExtras();
        if(bundle == null)
        {
            return;
        }
        UserCurrent userCurrent= (UserCurrent) bundle.get("Asset");

        TextView tvtype = findViewById(R.id.tvthing);
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
                for (int i = 0; i < us.size(); i++) {
                    if (us.get(i).getType().equals("ThingAsset")) {
                        Gson gson = new Gson();
                        String json = gson.toJson(us.get(i).attributes);
                        attributes attr = gson.fromJson(json, attributes.class);
                        json = gson.toJson(attr.notes);
                        notes note = gson.fromJson(json, notes.class);
                        json = gson.toJson(attr.data);
                        data data = gson.fromJson(json, data.class);
                        json = gson.toJson(attr.location);
                        location2 loca = gson.fromJson(json, location2.class);
                        json = gson.toJson(attr.writeAttribute);
                        writeAttribute writeAttribute = gson.fromJson(json , com.example.nt118n11mmcl_projectfinal.Model.writeAttribute.class);
                        json = gson.toJson(attr.subscribeAttribute);
                        subscribeAttribute subscribeAttribute = gson.fromJson(json , com.example.nt118n11mmcl_projectfinal.Model.subscribeAttribute.class);
                        TextView tv1 = findViewById(R.id.tvnote1);
                        TextView tv2 = findViewById(R.id.tvlocation1);
                        TextView tv3 = findViewById(R.id.tvchild1);
                        TextView tv4 = findViewById(R.id.tvweaid1);
                        TextView tv5 = findViewById(R.id.tvlocation3);
                        tv2.setText(""+writeAttribute.value);
                        tv3.setText(""+ subscribeAttribute.value);
                        tv4.setText(""+ note.value);
                        tv5.setText(""+ loca.value2);

                    }
                }
            }
            @Override
            public void onFailure(Call<List<UserCurrent>> call, Throwable t) {

            }
        });
    }
}