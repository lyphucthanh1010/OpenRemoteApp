package com.example.nt118n11mmcl_projectfinal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

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
import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityWeatherData3 extends AppCompatActivity {
    APIInterface apiInterface;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM ");
    LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[0]);
    LineGraphSeries<DataPoint> series2 = new LineGraphSeries<>(new DataPoint[0]);
    LineGraphSeries<DataPoint> series3 = new LineGraphSeries<>(new DataPoint[0]);
    LineGraphSeries<DataPoint> series4 = new LineGraphSeries<>(new DataPoint[0]);
    LineGraphSeries<DataPoint> series7 = new LineGraphSeries<>(new DataPoint[0]);
    LineGraphSeries<DataPoint> series8 = new LineGraphSeries<>(new DataPoint[0]);
    GraphDatabaseHelper graphDatabaseHelper;
    SQLiteDatabase sqLiteDatabase;
    DataGraph dataGraph;
    DataGraphAdapter dataGraphAdapter;
    GraphActivity graphActivity;
    LineGraphSeries<DataPoint> series9 = new LineGraphSeries<>(new DataPoint[0]);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weatherdata3);
        apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<Asset> call = apiInterface.getAsset("4cdWlxEvmDRBBDEc2HRsaF");
        call.enqueue(new Callback<Asset>() {
            @Override
            public void onResponse(Call<Asset> call, Response<Asset> response) {
                Asset as = response.body();
                Gson gson = new Gson();
                String json = gson.toJson(as.attributes);
                attributes attrObj = gson.fromJson(json, attributes.class);
                json = gson.toJson(attrObj.weatherData);
                weatherData weaobj = gson.fromJson(json, weatherData.class);
                json = gson.toJson(weaobj.value);
                value vlueobj = gson.fromJson(json, value.class);
                json = gson.toJson(vlueobj.main);
                main mainobj =gson.fromJson(json, main.class);
                json = gson.toJson(attrObj.windSpeed);
                windSpeed windsobj = gson.fromJson(json, windSpeed.class);
                json = gson.toJson(attrObj.temperature);
                temperature temobj = gson.fromJson(json, temperature.class);
                json = gson.toJson(attrObj.humidity);
                humidity humidobj = gson.fromJson(json, humidity.class);
                json = gson.toJson(attrObj.windDirection);
                windDirection winddiobj = gson.fromJson(json, windDirection.class);
                TextView tv = findViewById(R.id.tvweaid5);
                tv.setText(as.id.toString());
                TextView tv2 = findViewById(R.id.tvweatemper5);
                tv2.setText(temobj.value.toString());
                TextView tv3 = findViewById(R.id.tvweahumi5);
                tv3.setText(humidobj.value.toString());
                TextView tv4= findViewById(R.id.tvweawinddi5);
                tv4.setText(winddiobj.value.toString());
                TextView tv5 = findViewById(R.id.tvweawindspeed5);
                tv5.setText(windsobj.value.toString());
                TextView tv6 = findViewById(R.id.tvweapressnext5);
                tv6.setText(mainobj.pressure.toString());
                TextView tv7 = findViewById(R.id.tvweamaxtempnext5);
                tv7.setText(mainobj.temp_max.toString());
                TextView tv8 = findViewById(R.id.tvweamintempnext5);
                tv8.setText(mainobj.temp_min.toString());
//                TextView tv9 = findViewById(R.id.tvweaseanext5);
//                tv9.setText(mainobj.sea_level.toString());
//                TextView tv10 = findViewById(R.id.tvweagroundnext5);
//                tv10.setText(mainobj.grnd_level.toString());
            }

            @Override
            public void onFailure(Call<Asset> call, Throwable t) {

            }
        });
        RelativeLayout rlt7 = findViewById(R.id.rtltemper1);
        rlt7.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                LayoutInflater li = LayoutInflater.from(ActivityWeatherData3.this);
                View customDialogView = li.inflate(R.layout.custom_dialog, null);
                final AlertDialog alertDialogBuilder  = new AlertDialog.Builder(ActivityWeatherData3.this).create();
                final GraphView grphview7 =  (GraphView) customDialogView.findViewById(R.id.graphdialog);
                alertDialogBuilder.setView(customDialogView);
                alertDialogBuilder.show();
                final TextView tv7 = (TextView) customDialogView.findViewById(R.id.titledialog);
                tv7.setText("Weather Asset 3 Temperature");
                graphDatabaseHelper = new GraphDatabaseHelper(ActivityWeatherData3.this);
                sqLiteDatabase = graphDatabaseHelper.getWritableDatabase();
                series7.resetData(getDataPoint7());
                grphview7.addSeries(series7);
                series7.setTitle("Temperature");
                series7.setThickness(8);
                grphview7.getLegendRenderer().setVisible(true);
                grphview7.getViewport().setXAxisBoundsManual(true);
                grphview7.getViewport().setYAxisBoundsManual(true);
                grphview7.getViewport().scrollToEnd();
                grphview7.getViewport().setScalable(true);
                grphview7.getViewport().setScalableY(true);
                grphview7.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
                grphview7.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
                    public String formatLabel(double value, boolean x){
                        if (x)
                        {
                            return sdf.format(new Date((long)value));
                        }else{
                            return super.formatLabel(value, x);
                        }
                    }
                });
                GridLabelRenderer gridLabel = grphview7.getGridLabelRenderer();
                gridLabel.setHorizontalAxisTitle("Time");
                gridLabel.setHorizontalAxisTitleTextSize(30);
                gridLabel.setVerticalAxisTitle("Temperature (Celsius)");
                gridLabel.setVerticalAxisTitleTextSize(30);
                return true;
            }
        });
        ImageView img= findViewById(R.id.backpic2);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                ActivityWeatherData3.super.onBackPressed();
            }
        });
        RelativeLayout rlt8 = findViewById(R.id.rtlhumidity1);
        rlt8.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                LayoutInflater li = LayoutInflater.from(ActivityWeatherData3.this);
                View customDialogView = li.inflate(R.layout.custom_dialog, null);
                final AlertDialog alertDialogBuilder  = new AlertDialog.Builder(ActivityWeatherData3.this).create();
                final GraphView grphview8 =  (GraphView) customDialogView.findViewById(R.id.graphdialog);
                final TextView tv8 = (TextView) customDialogView.findViewById(R.id.titledialog);
                tv8.setText("Weather Asset 3 Humidity");
                alertDialogBuilder.setView(customDialogView);
                alertDialogBuilder.show();
                graphDatabaseHelper = new GraphDatabaseHelper(ActivityWeatherData3.this);
                sqLiteDatabase = graphDatabaseHelper.getWritableDatabase();
                series8.resetData(getDataPoint8());
                grphview8.addSeries(series8);
                series8.setTitle("Humidity");
                series8.setThickness(8);
                grphview8.getLegendRenderer().setVisible(true);
                grphview8.getViewport().setXAxisBoundsManual(true);
                grphview8.getViewport().setYAxisBoundsManual(true);
                grphview8.getViewport().scrollToEnd();
                grphview8.getViewport().setScalable(true);
                grphview8.getViewport().setScalableY(true);
                grphview8.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
                grphview8.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
                    public String formatLabel(double value, boolean x){
                        if (x)
                        {
                            return sdf.format(new Date((long)value));
                        }else{
                            return super.formatLabel(value, x);
                        }
                    }
                });
                GridLabelRenderer gridLabel = grphview8.getGridLabelRenderer();
                gridLabel.setHorizontalAxisTitle("Time");
                gridLabel.setHorizontalAxisTitleTextSize(30);
                gridLabel.setVerticalAxisTitle("Humidity (%)");
                gridLabel.setVerticalAxisTitleTextSize(30);
                return true;
            }
        });
        RelativeLayout rlt9 = findViewById(R.id.rtlwindspeed1);
        rlt9.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                LayoutInflater li = LayoutInflater.from(ActivityWeatherData3.this);
                View customDialogView = li.inflate(R.layout.custom_dialog, null);
                final AlertDialog alertDialogBuilder  = new AlertDialog.Builder(ActivityWeatherData3.this).create();
                final GraphView grphview9 =  (GraphView) customDialogView.findViewById(R.id.graphdialog);
                final TextView tv9 = (TextView) customDialogView.findViewById(R.id.titledialog);
                tv9.setText("Weather Asset 3 Wind speed");
                alertDialogBuilder.setView(customDialogView);
                alertDialogBuilder.show();
                graphDatabaseHelper = new GraphDatabaseHelper(ActivityWeatherData3.this);
                sqLiteDatabase = graphDatabaseHelper.getWritableDatabase();
                series9.resetData(getDataPoint9());
                grphview9.addSeries(series9);
                series9.setTitle("Windspeed");
                series9.setThickness(8);
                grphview9.getViewport().setXAxisBoundsManual(true);
                grphview9.getViewport().setYAxisBoundsManual(true);
                grphview9.getViewport().scrollToEnd();
                grphview9.getViewport().setScalable(true);
                grphview9.getViewport().setScalableY(true);
                grphview9.getLegendRenderer().setVisible(true);
                grphview9.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
                grphview9.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
                    public String formatLabel(double value, boolean x){
                        if (x)
                        {
                            return sdf.format(new Date((long)value));
                        }else{
                            return super.formatLabel(value, x);
                        }
                    }
                });
                GridLabelRenderer gridLabel = grphview9.getGridLabelRenderer();
                gridLabel.setHorizontalAxisTitle("Time");
                gridLabel.setHorizontalAxisTitleTextSize(30);
                gridLabel.setVerticalAxisTitle("Wind speed (km/h)");
                return true;
            }
        });
        RelativeLayout rltdirec = findViewById(R.id.rtlwinddirec1);
        rltdirec.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                LayoutInflater li = LayoutInflater.from(ActivityWeatherData3.this);
                View customDialogView = li.inflate(R.layout.custom_dialog, null);
                final AlertDialog alertDialogBuilder  = new AlertDialog.Builder(ActivityWeatherData3.this).create();
                final GraphView grphview4 =  (GraphView) customDialogView.findViewById(R.id.graphdialog);
                alertDialogBuilder.setView(customDialogView);
                alertDialogBuilder.show();
                final TextView tv3 = (TextView) customDialogView.findViewById(R.id.titledialog);
                tv3.setText("Weather Asset 3 Wind direction");
                graphDatabaseHelper = new GraphDatabaseHelper(ActivityWeatherData3.this);
                sqLiteDatabase = graphDatabaseHelper.getWritableDatabase();
                series4.resetData(getDataPoint4());
                grphview4.addSeries(series4);
                series4.setTitle("Wind direction");
                series4.setThickness(8);
                grphview4.getLegendRenderer().setVisible(true);
                grphview4.getViewport().setXAxisBoundsManual(true);
                grphview4.getViewport().setYAxisBoundsManual(true);
                grphview4.getViewport().scrollToEnd();
                grphview4.getViewport().setScalable(true);
                grphview4.getViewport().setScalableY(true);
                grphview4.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
                grphview4.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
                    public String formatLabel(double value, boolean x){
                        if (x)
                        {
                            return sdf.format(new Date((long)value));
                        }else{
                            return super.formatLabel(value, x);
                        }
                    }
                });
                GridLabelRenderer gridLabel = grphview4.getGridLabelRenderer();
                gridLabel.setHorizontalAxisTitle("Time");
                gridLabel.setHorizontalAxisTitleTextSize(30);
                gridLabel.setVerticalAxisTitle("Wind direction");
                gridLabel.setVerticalAxisTitleTextSize(30);
                return true;
            }

        });
        RelativeLayout rltpress = findViewById(R.id.rtltemper7);
        rltpress.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                LayoutInflater li = LayoutInflater.from(ActivityWeatherData3.this);
                View customDialogView = li.inflate(R.layout.custom_dialog, null);
                final AlertDialog alertDialogBuilder  = new AlertDialog.Builder(ActivityWeatherData3.this).create();
                final GraphView grphview =  (GraphView) customDialogView.findViewById(R.id.graphdialog);
                alertDialogBuilder.setView(customDialogView);
                alertDialogBuilder.show();
                final TextView tv3 = (TextView) customDialogView.findViewById(R.id.titledialog);
                tv3.setText("Weather Asset 3 Pressure");
                graphDatabaseHelper = new GraphDatabaseHelper(ActivityWeatherData3.this);
                sqLiteDatabase = graphDatabaseHelper.getWritableDatabase();
                series.resetData(getDataPoint());
                grphview.addSeries(series);
                series.setTitle("Pressure");
                series.setThickness(8);
                grphview.getLegendRenderer().setVisible(true);
                grphview.getViewport().setXAxisBoundsManual(true);
                grphview.getViewport().setYAxisBoundsManual(true);
                grphview.getViewport().scrollToEnd();
                grphview.getViewport().setScalable(true);
                grphview.getViewport().setScalableY(true);
                grphview.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
                grphview.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
                    public String formatLabel(double value, boolean x){
                        if (x)
                        {
                            return sdf.format(new Date((long)value));
                        }else{
                            return super.formatLabel(value, x);
                        }
                    }
                });
                GridLabelRenderer gridLabel = grphview.getGridLabelRenderer();
                gridLabel.setHorizontalAxisTitle("Time");
                gridLabel.setHorizontalAxisTitleTextSize(30);
                gridLabel.setVerticalAxisTitle("Pressure");
                gridLabel.setVerticalAxisTitleTextSize(30);
                return true;
            }
        });
        RelativeLayout rltmaxtemp = findViewById(R.id.rtlhumidity7);
        rltmaxtemp.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                LayoutInflater li = LayoutInflater.from(ActivityWeatherData3.this);
                View customDialogView = li.inflate(R.layout.custom_dialog, null);
                final AlertDialog alertDialogBuilder  = new AlertDialog.Builder(ActivityWeatherData3.this).create();
                final GraphView grphview2 =  (GraphView) customDialogView.findViewById(R.id.graphdialog);
                alertDialogBuilder.setView(customDialogView);
                alertDialogBuilder.show();
                final TextView tv3 = (TextView) customDialogView.findViewById(R.id.titledialog);
                tv3.setText("Weather Asset 3 Max temperature");
                graphDatabaseHelper = new GraphDatabaseHelper(ActivityWeatherData3.this);
                sqLiteDatabase = graphDatabaseHelper.getWritableDatabase();
                series2.resetData(getDataPoint2());
                grphview2.addSeries(series2);
                series2.setTitle("Max temperature");
                series2.setThickness(8);
                grphview2.getViewport().setXAxisBoundsManual(true);
                grphview2.getViewport().setYAxisBoundsManual(true);
                grphview2.getViewport().scrollToEnd();
                grphview2.getViewport().setScalable(true);
                grphview2.getViewport().setScalableY(true);
                grphview2.getLegendRenderer().setVisible(true);
                grphview2.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
                grphview2.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
                    public String formatLabel(double value, boolean x){
                        if (x)
                        {
                            return sdf.format(new Date((long)value));
                        }else{
                            return super.formatLabel(value, x);
                        }
                    }
                });
                GridLabelRenderer gridLabel = grphview2.getGridLabelRenderer();
                gridLabel.setHorizontalAxisTitle("Time");
                gridLabel.setHorizontalAxisTitleTextSize(30);
                gridLabel.setVerticalAxisTitle("Max temperature (Celsius)");
                return true;
            }
        });
        RelativeLayout rltmintemp = findViewById(R.id.rtlwinddirec4);
        rltmintemp.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                LayoutInflater li = LayoutInflater.from(ActivityWeatherData3.this);
                View customDialogView = li.inflate(R.layout.custom_dialog, null);
                final AlertDialog alertDialogBuilder  = new AlertDialog.Builder(ActivityWeatherData3.this).create();
                final GraphView grphview3 =  (GraphView) customDialogView.findViewById(R.id.graphdialog);
                alertDialogBuilder.setView(customDialogView);
                alertDialogBuilder.show();
                final TextView tv3 = (TextView) customDialogView.findViewById(R.id.titledialog);
                tv3.setText("Weather Asset 3 Min temperature");
                graphDatabaseHelper = new GraphDatabaseHelper(ActivityWeatherData3.this);
                sqLiteDatabase = graphDatabaseHelper.getWritableDatabase();
                series3.resetData(getDataPoint3());
                grphview3.addSeries(series3);
                series3.setTitle("Min temperature");
                series3.setThickness(8);
                grphview3.getViewport().setXAxisBoundsManual(true);
                grphview3.getViewport().setYAxisBoundsManual(true);
                grphview3.getViewport().scrollToEnd();
                grphview3.getViewport().setScalable(true);
                grphview3.getViewport().setScalableY(true);
                grphview3.getLegendRenderer().setVisible(true);
                grphview3.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
                grphview3.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
                    public String formatLabel(double value, boolean x){
                        if (x)
                        {
                            return sdf.format(new Date((long)value));
                        }else{
                            return super.formatLabel(value, x);
                        }
                    }
                });
                GridLabelRenderer gridLabel = grphview3.getGridLabelRenderer();
                gridLabel.setHorizontalAxisTitle("Time");
                gridLabel.setHorizontalAxisTitleTextSize(30);
                gridLabel.setVerticalAxisTitle("Min temperature (Celsius)");
                return true;
            }
        });
    }

    private DataPoint[] getDataPoint3() {
        String[] columns = {"KEY_TIME2","KEY_TEMPMIN"};
        Cursor cursor = graphDatabaseHelper.GetData("SELECT * FROM contacts WHERE name = 'Weather Asset 3' ");
        DataPoint[] dp = new DataPoint[cursor.getCount()];
        //  if(cursor.getString(1)== "6H4PeKLRMea1L0WsRXXWp9") {
        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToNext();
            dp[i] = new DataPoint(cursor.getLong(13), cursor.getDouble(10));
        }
        //}
        return dp;
    }

    private DataPoint[] getDataPoint2() {
        String[] columns = {"KEY_TIME2","KEY_TEMPMAX"};
        Cursor cursor = graphDatabaseHelper.GetData("SELECT * FROM contacts WHERE name = 'Weather Asset 3' ");
        DataPoint[] dp = new DataPoint[cursor.getCount()];
        //  if(cursor.getString(1)== "6H4PeKLRMea1L0WsRXXWp9") {
        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToNext();
            dp[i] = new DataPoint(cursor.getLong(13), cursor.getDouble(9));
        }
        //}
        return dp;
    }

    private DataPoint[] getDataPoint() {
        String[] columns = {"KEY_TIME2","KEY_PRESSURE"};
        Cursor cursor = graphDatabaseHelper.GetData("SELECT * FROM contacts WHERE name = 'Weather Asset 3' ");
        DataPoint[] dp = new DataPoint[cursor.getCount()];
        //  if(cursor.getString(1)== "6H4PeKLRMea1L0WsRXXWp9") {
        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToNext();
            dp[i] = new DataPoint(cursor.getLong(13), cursor.getLong(16));
        }
        //}
        return dp;
    }

    private DataPoint[] getDataPoint4() {
        String[] columns = {"KEY_WINDTIMESTAMP","KEY_WINDDIREC"};
        Cursor cursor = graphDatabaseHelper.GetData("SELECT * FROM contacts WHERE name = 'Weather Asset 3' ");
        DataPoint[] dp = new DataPoint[cursor.getCount()];
        //  if(cursor.getString(1)== "6H4PeKLRMea1L0WsRXXWp9") {
        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToNext();
            dp[i] = new DataPoint(cursor.getLong(15), cursor.getLong(14));
        }
        //}
        return dp;
    }

    private DataPoint[] getDataPoint9(){
        String[] columns = {"KEY_WINDSTIME","KEY_WINDSPEED"};
        Cursor cursor = graphDatabaseHelper.GetData("SELECT * FROM contacts WHERE name = 'Weather Asset 3' ");
        DataPoint[] dp = new DataPoint[cursor.getCount()];
        //  if(cursor.getString(1)== "6H4PeKLRMea1L0WsRXXWp9") {
        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToNext();
            dp[i] = new DataPoint(cursor.getFloat(8), cursor.getInt(7));
        }
        //}
        return dp;
    }
    private DataPoint[] getDataPoint8(){
        String[] columns = {"KEY_HUMITIME","KEY_HUMIDITY"};
        Cursor cursor = graphDatabaseHelper.GetData("SELECT * FROM contacts WHERE name = 'Weather Asset 3' ");
        DataPoint[] dp = new DataPoint[cursor.getCount()];
        //  if(cursor.getString(1)== "6H4PeKLRMea1L0WsRXXWp9") {
        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToNext();
            dp[i] = new DataPoint(cursor.getLong(6), cursor.getInt(5));
        }
        //}
        return dp;
    }
    private DataPoint[] getDataPoint7(){
        String[] columns = {"KEY_TEMPTIMESTAMP","KEY_TEMPERATURE"};
        Cursor cursor = graphDatabaseHelper.GetData("SELECT * FROM contacts WHERE name = 'Weather Asset 3'");
        DataPoint[] dp = new DataPoint[cursor.getCount()];
        //  if(cursor.getString(1)== "6H4PeKLRMea1L0WsRXXWp9") {
        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToNext();
            dp[i] = new DataPoint(cursor.getLong(4), cursor.getDouble(3));
        }
        //  }
        return dp;
    }
}