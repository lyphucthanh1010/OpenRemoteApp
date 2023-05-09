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
import com.example.nt118n11mmcl_projectfinal.Model.clientId;
import com.example.nt118n11mmcl_projectfinal.Model.host;
import com.example.nt118n11mmcl_projectfinal.Model.location;
import com.example.nt118n11mmcl_projectfinal.Model.location2;
import com.example.nt118n11mmcl_projectfinal.Model.notes;
import com.example.nt118n11mmcl_projectfinal.Model.port;
import com.example.nt118n11mmcl_projectfinal.Model.secureMode;
import com.example.nt118n11mmcl_projectfinal.Model.websocketPath;
import com.example.nt118n11mmcl_projectfinal.Model.websocketQuery;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailMQTTActivity extends AppCompatActivity {
    APIInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mqttasset);
        Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
            return;
        }
        UserCurrent userCurrent = (UserCurrent) bundle.get("Asset");

        TextView tvtype = findViewById(R.id.mqtt);
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
                    if (us.get(i).getType().equals("MQTTAgent")) {
                        TextView tv= findViewById(R.id.tvnote1);
                        TextView tv2= findViewById(R.id.tvlocation1);
                        TextView tv3= findViewById(R.id.tvchild1);
                        TextView tv4= findViewById(R.id.tvweaid1);
                        TextView tv5= findViewById(R.id.tvweatemper1);
                        TextView tv6= findViewById(R.id.tvweahumi1);
                        TextView tv7= findViewById(R.id.tvlocation3);
                        TextView tv8= findViewById(R.id.tvagent1);
                        TextView tv9= findViewById(R.id.tvagent3);
                        TextView tv10= findViewById(R.id.tvpolling1);
                        Gson gson = new Gson();
                        String json = gson.toJson(us.get(i).attributes);
                        attributes attr = gson.fromJson(json, attributes.class);
                        json = gson.toJson(attr.clientId);
                        clientId cli = gson.fromJson(json, clientId.class);
                        json = gson.toJson(attr.websocketPath);
                        websocketPath path = gson.fromJson(json, websocketPath.class);
                        json = gson.toJson(attr.websocketQuery);
                        websocketQuery query = gson.fromJson(json, websocketQuery.class);
                        json = gson.toJson(attr.notes);
                        notes note = gson.fromJson(json, notes.class);
                        json = gson.toJson(attr.port);
                        port port = gson.fromJson(json, port.class);
                        json = gson.toJson(attr.secureMode);
                        secureMode sec = gson.fromJson(json, secureMode.class);
                        json = gson.toJson(attr.location);
                        location2 loca = gson.fromJson(json , location2.class);
                        json = gson.toJson(attr.agentDisabled);
                        agentDisabled agedis = gson.fromJson(json , agentDisabled.class);
                        json = gson.toJson(attr.agentStatus);
                        agentStatus agesta = gson.fromJson(json, agentStatus.class);
                        json = gson.toJson(attr.host);
                        host host = gson.fromJson(json, host.class);
                        tv.setText(""+cli.value);
                        tv2.setText(""+ path.value);
                        tv3.setText(""+ query.value);
                        tv4.setText(""+ note.value);
                        tv5.setText(""+ port.value);
                        tv6.setText(""+ sec.value);
                        tv7.setText(""+loca.value2);
                        tv8.setText(""+ agedis.value);
                        tv9.setText(""+agesta.value);
                        tv10.setText(""+host.value);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<UserCurrent>> call, Throwable t) {

            }
        });
    }
}
