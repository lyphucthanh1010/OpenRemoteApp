package com.example.nt118n11mmcl_projectfinal;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nt118n11mmcl_projectfinal.Model.UserCurrent;
import com.example.nt118n11mmcl_projectfinal.Model.agentDisabled;
import com.example.nt118n11mmcl_projectfinal.Model.agentStatus;
import com.example.nt118n11mmcl_projectfinal.Model.attributes;
import com.example.nt118n11mmcl_projectfinal.Model.location2;
import com.example.nt118n11mmcl_projectfinal.Model.notes;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailSimuActivity extends AppCompatActivity {
    private APIInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulatorasset);
        Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
            return;
        }
        UserCurrent userCurrent = (UserCurrent) bundle.get("Asset");
        TextView tvtype = findViewById(R.id.simu);
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
                    if (us.get(i).getType().equals("SimulatorAgent")) {
                        TextView tv = findViewById(R.id.tvweaid1);
                        TextView tv2 = findViewById(R.id.tvlocation3);
                        TextView tv3 = findViewById(R.id.tvagent1);
                        TextView tv4 = findViewById(R.id.tvagent3);
                        Gson gson = new Gson();
                        String json = gson.toJson(us.get(i).attributes);
                        attributes attr = gson.fromJson(json, attributes.class);
                        json = gson.toJson(attr.notes);
                        notes note = gson.fromJson(json, notes.class);
                        json = gson.toJson(attr.location);
                        location2 loca = gson.fromJson(json , location2.class);
                        json = gson.toJson(attr.agentDisabled);
                        agentDisabled agedis = gson.fromJson(json, agentDisabled.class);
                        json = gson.toJson(attr.agentStatus);
                        agentStatus agesta = gson.fromJson(json , agentStatus.class);
                        tv.setText(""+note.value);
                        tv2.setText(""+loca.value2);
                        tv3.setText(""+ agedis.value);
                        tv4.setText(""+ agesta.value);

                    }
                }
            }

            @Override
            public void onFailure(Call<List<UserCurrent>> call, Throwable t) {

            }
        });
    }
}
