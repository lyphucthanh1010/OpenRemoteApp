package com.example.nt118n11mmcl_projectfinal;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nt118n11mmcl_projectfinal.Model.Asset;
import com.example.nt118n11mmcl_projectfinal.Model.attributes;
import com.example.nt118n11mmcl_projectfinal.Model.humidity;
import com.example.nt118n11mmcl_projectfinal.Model.main;
import com.example.nt118n11mmcl_projectfinal.Model.temperature;
import com.example.nt118n11mmcl_projectfinal.Model.value;
import com.example.nt118n11mmcl_projectfinal.Model.weatherData;
import com.example.nt118n11mmcl_projectfinal.Model.windDirection;
import com.example.nt118n11mmcl_projectfinal.Model.windSpeed;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivitySQL extends AppCompatActivity {
    public List<DataGraph> dataGraphs;
    APIInterface apiInterface;
    private ListView lvContact;
    private DataGraphAdapter dataGraphAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql);
            this.lvContact = (ListView) findViewById(R.id.lvContact);
            String pathdb = getDatabasePath("dataManager").getPath();
        Log.d("DB_Path: ", pathdb); //

        // Gọi Database
        GraphDatabaseHelper db = new GraphDatabaseHelper(this);
        Log.d("Insert: ", "Inserting ..");
         apiInterface = APIClient.getClient().create(APIInterface.class);
        // Hiển thị lên ListView
        this.dataGraphAdapter = new DataGraphAdapter(this.dataGraphs);
        this.lvContact.setAdapter(dataGraphAdapter);
        this.lvContact.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                if (db.deleteContact(dataGraphs.get(position).getIddtb())) {
                    Toast.makeText(ActivitySQL.this, "Deleted " + dataGraphs.get(position).getName(), Toast.LENGTH_SHORT).show();

                    Log.d("Delete Database", "Deleted: " + dataGraphs.get(position).getIddtb() + "|" + dataGraphs.get(position).getName());
                } else {
                    Toast.makeText(ActivitySQL.this, "Failed!", Toast.LENGTH_SHORT).show();
                    Log.d("Delete Database", "Failed");
                }
                dataGraphs.remove(position);
               dataGraphAdapter.updateData();
                return false;
            }
        });
        for (DataGraph cn : this.dataGraphs) {
            String log = "Id: " + cn.getId() + ", Name: " + cn.getName();
            Log.e("Name: ", log);
        }
        ImageView img= findViewById(R.id.backpic);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                ActivitySQL.super.onBackPressed();
            }
        });
    }

}
