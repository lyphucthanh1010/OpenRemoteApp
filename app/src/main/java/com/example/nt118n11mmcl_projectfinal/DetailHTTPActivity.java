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
import com.example.nt118n11mmcl_projectfinal.Model.baseURL;
import com.example.nt118n11mmcl_projectfinal.Model.followRedirects;
import com.example.nt118n11mmcl_projectfinal.Model.location2;
import com.example.nt118n11mmcl_projectfinal.Model.notes;
import com.example.nt118n11mmcl_projectfinal.Model.pollingMillis;
import com.example.nt118n11mmcl_projectfinal.Model.requestTimeoutMillis;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailHTTPActivity extends AppCompatActivity {
    APIInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_httpasset);
        Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
            return;
        }
        UserCurrent userCurrent = (UserCurrent) bundle.get("Asset");
        TextView tvtype = findViewById(R.id.http);
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
                    if (us.get(i).getType().equals("HTTPAgent")) {
                        TextView tv= findViewById(R.id.tvlocation1);
                        TextView tv2= findViewById(R.id.tvchild1);
                        TextView tv3= findViewById(R.id.tvweaid1);
                        TextView tv4= findViewById(R.id.tvweahumi1);
                        TextView tv5= findViewById(R.id.tvlocation3);
                        TextView tv6= findViewById(R.id.tvagent1);
                        TextView tv7= findViewById(R.id.tvagent3);
                        TextView tv8= findViewById(R.id.tvpolling1);
                        Gson gson = new Gson();
                        String json = gson.toJson(us.get(i).attributes);
                        attributes attr = gson.fromJson(json, attributes.class);
                        json = gson.toJson(attr.baseURL);
                        baseURL base = gson.fromJson(json, baseURL.class);
                        json = gson.toJson(attr.requestTimeoutMillis);
                        requestTimeoutMillis timeout = gson.fromJson(json, requestTimeoutMillis.class);
                        json = gson.toJson(attr.notes);
                        notes note = gson.fromJson(json , notes.class);
                        json = gson.toJson(attr.followRedirects);
                        followRedirects redirects = gson.fromJson(json, followRedirects.class);
                        json = gson.toJson(attr.location);
                        location2 loca = gson.fromJson(json , location2.class);
                        json = gson.toJson(attr.agentDisabled);
                        agentDisabled agedis = gson.fromJson(json, agentDisabled.class);
                        json = gson.toJson(attr.agentStatus);
                        agentStatus agesta = gson.fromJson(json, agentStatus.class);
                        json = gson.toJson(attr.pollingMillis);
                        pollingMillis poll = gson.fromJson(json , pollingMillis.class);
                        tv.setText(""+ base.value);
                        tv2.setText(""+ timeout.value);
                        tv3.setText(""+ note.value);
                        tv4.setText(""+ redirects.value);
                        tv5.setText(""+ loca.value2);
                        tv6.setText(""+agedis.value);
                        tv7.setText(""+ agesta.value);
                        tv8.setText(""+poll.value);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<UserCurrent>> call, Throwable t) {

            }
        });
    }
}
