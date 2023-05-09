package com.example.nt118n11mmcl_projectfinal;

import static android.content.Context.ALARM_SERVICE;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

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

import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlarmFragment extends Fragment {
    private Context context;
    public List<DataGraph> dataGraphs;
    APIInterface apiInterface;
    private ListView lvContact;
    private DataGraphAdapter dataGraphAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.alarm_fragment, container, false);
        this.context = getContext();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        AppCompatButton btn = (AppCompatButton) view.findViewById(R.id.btnIns);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater li = LayoutInflater.from(context);
                View customDialogView = li.inflate(R.layout.custom_dialog2, null);
                final AlertDialog alertDialogBuilder  = new AlertDialog.Builder(context).create();
                alertDialogBuilder.setView(customDialogView);
                alertDialogBuilder.show();
            }
        });
        ImageView img = view.findViewById(R.id.backpic2);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finishAndRemoveTask();
            }
        });
        Button btn2= view.findViewById(R.id.btnCreate);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.HOUR_OF_DAY,07);
                calendar.set(Calendar.MINUTE,00);
                calendar.set(Calendar.SECOND,00);
                Toast.makeText(context, "Đã cài", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, Notification_receiver.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(context,100,intent,PendingIntent.FLAG_IMMUTABLE);
                AlarmManager alarmManager = (AlarmManager) getActivity().getSystemService(ALARM_SERVICE);
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY, pendingIntent);
                String pathdb = getActivity().getDatabasePath("dataManager").getPath(); // Lấy đường dẫn thư mục chứa database
                Log.d("DB_Path: ", pathdb); //


                // Gọi Database
                GraphDatabaseHelper db = new GraphDatabaseHelper(context);
                Log.d("Insert: ", "Inserting ..");
                apiInterface = APIClient.getClient().create(APIInterface.class);
                Call<Asset> call = apiInterface.getAsset("6H4PeKLRMea1L0WsRXXWp9");
                call.enqueue(new Callback<Asset>() {
                    @Override
                    public void onResponse(Call<Asset> call, Response<Asset> response) {
                        Asset as = response.body();
                        Gson gson = new Gson();
                        String json = gson.toJson(as.attributes);
                        attributes attrObj = gson.fromJson(json, attributes.class);
                        json = gson.toJson(attrObj.windDirection);
                        windDirection winddiobj = gson.fromJson(json, windDirection.class);
                        json = gson.toJson(attrObj.windSpeed);
                        windSpeed windsobj = gson.fromJson(json, windSpeed.class);
                        json = gson.toJson(attrObj.temperature);
                        temperature temobj = gson.fromJson(json, temperature.class);
                        json = gson.toJson(attrObj.humidity);
                        humidity humidobj = gson.fromJson(json, humidity.class);
                        json = gson.toJson(attrObj.weatherData);
                        weatherData weobj = gson.fromJson(json, weatherData.class);
                        json = gson.toJson(weobj.value);
                        value vlueobj =  gson.fromJson(json, value.class);
                        json = gson.toJson(vlueobj.main);
                        main mainobj = gson.fromJson(json, main.class);
                        db.addContact(new DataGraph(as.getId(),as.getName(),temobj.getValue().doubleValue(),temobj.getTimestamp().longValue(),humidobj.getValue(),humidobj.getTimestamp().longValue(),windsobj.getValue(), windsobj.getTimestamp().longValue(),mainobj.getTemp_max().doubleValue(), mainobj.getTemp_min().doubleValue(), mainobj.getSea_level().longValue(), mainobj.getGrnd_level().longValue(), weobj.getTimestamp().longValue(),winddiobj.getValue().longValue(), winddiobj.getTimestamp().longValue(), mainobj.getPressure().longValue(),null));
                    }

                    @Override
                    public void onFailure(Call<Asset> call, Throwable t) {

                    }
                });
                Call<Asset> call2 = apiInterface.getAsset("2UZPM2Mvu11Xyq5jCWNMX1");
                call2.enqueue(new Callback<Asset>() {
                    @Override
                    public void onResponse(Call<Asset> call2, Response<Asset> response) {
                        Asset as2 = response.body();
                        Gson gson = new Gson();
                        String json = gson.toJson(as2.attributes);
                        attributes attrObj2 = gson.fromJson(json, attributes.class);
                        json = gson.toJson(attrObj2.windDirection);
                        windDirection winddiobj2 = gson.fromJson(json, windDirection.class);
                        json = gson.toJson(attrObj2.windSpeed);
                        windSpeed windsobj2 = gson.fromJson(json, windSpeed.class);
                        json = gson.toJson(attrObj2.temperature);
                        temperature temobj2 = gson.fromJson(json, temperature.class);
                        json = gson.toJson(attrObj2.humidity);
                        humidity humidobj2 = gson.fromJson(json, humidity.class);
                        json = gson.toJson(attrObj2.weatherData);
                        weatherData weobj2 = gson.fromJson(json, weatherData.class);
                        json = gson.toJson(weobj2.value);
                        value vlueobj2 =  gson.fromJson(json, value.class);
                        json = gson.toJson(vlueobj2.main);
                        main mainobj2 = gson.fromJson(json, main.class);
                        db.addContact(new DataGraph(as2.getId(),as2.getName(),temobj2.getValue().doubleValue(),temobj2.getTimestamp().longValue(),humidobj2.getValue(),humidobj2.getTimestamp().longValue(),windsobj2.getValue(), windsobj2.getTimestamp().longValue(), mainobj2.getTemp_max().doubleValue(), mainobj2.getTemp_min().doubleValue(), mainobj2.getSea_level().longValue(), mainobj2.getGrnd_level().longValue(), weobj2.getTimestamp().longValue(),winddiobj2.getValue().longValue(), winddiobj2.getTimestamp().longValue(), mainobj2.getPressure().longValue(),null));
                    }

                    @Override
                    public void onFailure(Call<Asset> call2, Throwable t) {

                    }
                });
                Call<Asset> call3 = apiInterface.getAsset("4cdWlxEvmDRBBDEc2HRsaF");
                call3.enqueue(new Callback<Asset>() {
                    @Override
                    public void onResponse(Call<Asset> call3, Response<Asset> response) {
                        Asset as3 = response.body();
                        Gson gson = new Gson();
                        String json = gson.toJson(as3.attributes);
                        attributes attrObj3 = gson.fromJson(json, attributes.class);
                        json = gson.toJson(attrObj3.windDirection);
                        windDirection winddiobj3 = gson.fromJson(json, windDirection.class);
                        json = gson.toJson(attrObj3.windSpeed);
                        windSpeed windsobj3 = gson.fromJson(json, windSpeed.class);
                        json = gson.toJson(attrObj3.temperature);
                        temperature temobj3 = gson.fromJson(json, temperature.class);
                        json = gson.toJson(attrObj3.humidity);
                        humidity humidobj3 = gson.fromJson(json, humidity.class);
                        json = gson.toJson(attrObj3.weatherData);
                        weatherData weobj3 = gson.fromJson(json, weatherData.class);
                        json = gson.toJson(weobj3.value);
                        value vlueobj3 =  gson.fromJson(json, value.class);
                        json = gson.toJson(vlueobj3.main);
                        main mainobj3 = gson.fromJson(json, main.class);
                        db.addContact(new DataGraph(as3.getId(),as3.getName(),temobj3.getValue().doubleValue(),temobj3.getTimestamp().longValue(),humidobj3.getValue(),humidobj3.getTimestamp().longValue(),windsobj3.getValue(), windsobj3.getTimestamp().longValue(), mainobj3.getTemp_max().doubleValue(),mainobj3.getTemp_min().doubleValue(), null,null,weobj3.getTimestamp().longValue(),winddiobj3.getValue().longValue(), winddiobj3.getTimestamp().longValue(), mainobj3.getPressure().longValue(),null));
                    }

                    @Override
                    public void onFailure(Call<Asset> call3, Throwable t) {

                    }
                });
                dataGraphs = db.getAllContacts(); // Lấy dữ liệu từ trong database ra
    }
        });
    }
}
