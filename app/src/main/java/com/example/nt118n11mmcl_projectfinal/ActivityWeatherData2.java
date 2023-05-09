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

public class ActivityWeatherData2 extends AppCompatActivity {
    APIInterface apiInterface;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM ");

    LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[0]);
    LineGraphSeries<DataPoint> series2 = new LineGraphSeries<>(new DataPoint[0]);
    LineGraphSeries<DataPoint> series3 = new LineGraphSeries<>(new DataPoint[0]);
    LineGraphSeries<DataPoint> series4 = new LineGraphSeries<>(new DataPoint[0]);
    LineGraphSeries<DataPoint> series5 = new LineGraphSeries<>(new DataPoint[0]);
    LineGraphSeries<DataPoint> series6 = new LineGraphSeries<>(new DataPoint[0]);
    LineGraphSeries<DataPoint> series7 = new LineGraphSeries<>(new DataPoint[0]);
    LineGraphSeries<DataPoint> series8 = new LineGraphSeries<>(new DataPoint[0]);
    LineGraphSeries<DataPoint> series9 = new LineGraphSeries<>(new DataPoint[0]);


    GraphDatabaseHelper graphDatabaseHelper;
    SQLiteDatabase sqLiteDatabase;
    DataGraph dataGraph;
    DataGraphAdapter dataGraphAdapter;
    GraphActivity graphActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weatherdata2);
        apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<Asset> call = apiInterface.getAsset("2UZPM2Mvu11Xyq5jCWNMX1");
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
                TextView tv = findViewById(R.id.tvweaid3);
                tv.setText(as.id.toString());
                TextView tv2 = findViewById(R.id.tvweatemper3);
                tv2.setText(temobj.value.toString());
                TextView tv3 = findViewById(R.id.tvweahumi3);
                tv3.setText(humidobj.value.toString());
                TextView tv4= findViewById(R.id.tvweawinddi3);
                tv4.setText(winddiobj.value.toString());
                TextView tv5 = findViewById(R.id.tvweawindspeed3);
                tv5.setText(windsobj.value.toString());
                TextView tv6 = findViewById(R.id.tvweapressnext3);
                tv6.setText(mainobj.pressure.toString());
                TextView tv7 = findViewById(R.id.tvweamaxtempnext3);
                tv7.setText(mainobj.temp_max.toString());
                TextView tv8 = findViewById(R.id.tvweamintempnext3);
                tv8.setText(mainobj.temp_min.toString());
                TextView tv9 = findViewById(R.id.tvweaseanext3);
                tv9.setText(mainobj.sea_level.toString());
                TextView tv10 = findViewById(R.id.tvweagroundnext3);
                tv10.setText(mainobj.grnd_level.toString());
            }

            @Override
            public void onFailure(Call<Asset> call, Throwable t) {

            }
        });
        RelativeLayout rlt4 = findViewById(R.id.rtltemper1);
        rlt4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                LayoutInflater li = LayoutInflater.from(ActivityWeatherData2.this);
                View customDialogView = li.inflate(R.layout.custom_dialog, null);
                final AlertDialog alertDialogBuilder  = new AlertDialog.Builder(ActivityWeatherData2.this).create();
                final GraphView grphview1 =  (GraphView) customDialogView.findViewById(R.id.graphdialog);
                final TextView tv4 = (TextView) customDialogView.findViewById(R.id.titledialog);
                tv4.setText("Weather Asset 2 Temperature");
                alertDialogBuilder.setView(customDialogView);
                alertDialogBuilder.show();
                graphDatabaseHelper = new GraphDatabaseHelper(ActivityWeatherData2.this);
                sqLiteDatabase = graphDatabaseHelper.getWritableDatabase();
                series.resetData(getDataPoint());
                grphview1.addSeries(series);
                series.setTitle("Temperature");
                series.setThickness(8);
                grphview1.getViewport().setXAxisBoundsManual(true);
                grphview1.getViewport().setYAxisBoundsManual(true);
                grphview1.getViewport().scrollToEnd();
                grphview1.getViewport().setScalable(true);
                grphview1.getViewport().setScalableY(true);
                grphview1.getLegendRenderer().setVisible(true);
                grphview1.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
                grphview1.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
                    public String formatLabel(double value, boolean x){
                        if (x)
                        {
                            return sdf.format(new Date((long)value));
                        }else{
                            return super.formatLabel(value, x);
                        }
                    }
                });
                GridLabelRenderer gridLabel = grphview1.getGridLabelRenderer();
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
                ActivityWeatherData2.super.onBackPressed();
            }
        });
        RelativeLayout rlt5= findViewById(R.id.rtlhumidity1);
        rlt5.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                LayoutInflater li = LayoutInflater.from(ActivityWeatherData2.this);
                View customDialogView = li.inflate(R.layout.custom_dialog, null);
                final AlertDialog alertDialogBuilder  = new AlertDialog.Builder(ActivityWeatherData2.this).create();
                final GraphView grphview2 =  (GraphView) customDialogView.findViewById(R.id.graphdialog);
                alertDialogBuilder.setView(customDialogView);
                alertDialogBuilder.show();
                final TextView tv5 = (TextView) customDialogView.findViewById(R.id.titledialog);
                tv5.setText("Weather Asset 2 Humidity");
                graphDatabaseHelper = new GraphDatabaseHelper(ActivityWeatherData2.this);
                sqLiteDatabase = graphDatabaseHelper.getWritableDatabase();
                series2.resetData(getDataPoint2());
                grphview2.addSeries(series2);
                series2.setTitle("Humidity");
                grphview2.getViewport().setXAxisBoundsManual(true);
                grphview2.getViewport().setYAxisBoundsManual(true);
                grphview2.getViewport().scrollToEnd();
                grphview2.getViewport().setScalable(true);
                grphview2.getViewport().setScalableY(true);
                series2.setThickness(8);
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
                gridLabel.setVerticalAxisTitle("Humidity (%)");
                gridLabel.setVerticalAxisTitleTextSize(30);
                return true;
            }
        });
        RelativeLayout rlt6 = findViewById(R.id.rtlwindspeed1);
        rlt6.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                LayoutInflater li = LayoutInflater.from(ActivityWeatherData2.this);
                View customDialogView = li.inflate(R.layout.custom_dialog, null);
                final AlertDialog alertDialogBuilder  = new AlertDialog.Builder(ActivityWeatherData2.this).create();
                final GraphView grphview3 =  (GraphView) customDialogView.findViewById(R.id.graphdialog);
                alertDialogBuilder.setView(customDialogView);
                alertDialogBuilder.show();
                final TextView tv6 = (TextView) customDialogView.findViewById(R.id.titledialog);
                tv6.setText("Weather Asset 2 Wind speed");
                graphDatabaseHelper = new GraphDatabaseHelper(ActivityWeatherData2.this);
                sqLiteDatabase = graphDatabaseHelper.getWritableDatabase();
                series3.resetData(getDataPoint3());
                grphview3.addSeries(series3);
                series3.setTitle("Windspeed");
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
                gridLabel.setVerticalAxisTitle("Wind speed (km/h)");
                return true;
            }
        });
        RelativeLayout rltdirec = findViewById(R.id.rtlwinddirec1);
        rltdirec.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                LayoutInflater li = LayoutInflater.from(ActivityWeatherData2.this);
                View customDialogView = li.inflate(R.layout.custom_dialog, null);
                final AlertDialog alertDialogBuilder  = new AlertDialog.Builder(ActivityWeatherData2.this).create();
                final GraphView grphview4 =  (GraphView) customDialogView.findViewById(R.id.graphdialog);
                alertDialogBuilder.setView(customDialogView);
                alertDialogBuilder.show();
                final TextView tv3 = (TextView) customDialogView.findViewById(R.id.titledialog);
                tv3.setText("Weather Asset 2 Wind direction");
                graphDatabaseHelper = new GraphDatabaseHelper(ActivityWeatherData2.this);
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
                LayoutInflater li = LayoutInflater.from(ActivityWeatherData2.this);
                View customDialogView = li.inflate(R.layout.custom_dialog, null);
                final AlertDialog alertDialogBuilder  = new AlertDialog.Builder(ActivityWeatherData2.this).create();
                final GraphView grphview5 =  (GraphView) customDialogView.findViewById(R.id.graphdialog);
                alertDialogBuilder.setView(customDialogView);
                alertDialogBuilder.show();
                final TextView tv3 = (TextView) customDialogView.findViewById(R.id.titledialog);
                tv3.setText("Weather Asset 2 Pressure");
                graphDatabaseHelper = new GraphDatabaseHelper(ActivityWeatherData2.this);
                sqLiteDatabase = graphDatabaseHelper.getWritableDatabase();
                series5.resetData(getDataPoint5());
                grphview5.addSeries(series5);
                series5.setTitle("Pressure");
                series5.setThickness(8);
                grphview5.getLegendRenderer().setVisible(true);
                grphview5.getViewport().setXAxisBoundsManual(true);
                grphview5.getViewport().setYAxisBoundsManual(true);
                grphview5.getViewport().scrollToEnd();
                grphview5.getViewport().setScalable(true);
                grphview5.getViewport().setScalableY(true);
                grphview5.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
                grphview5.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
                    public String formatLabel(double value, boolean x){
                        if (x)
                        {
                            return sdf.format(new Date((long)value));
                        }else{
                            return super.formatLabel(value, x);
                        }
                    }
                });
                GridLabelRenderer gridLabel = grphview5.getGridLabelRenderer();
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
                LayoutInflater li = LayoutInflater.from(ActivityWeatherData2.this);
                View customDialogView = li.inflate(R.layout.custom_dialog, null);
                final AlertDialog alertDialogBuilder  = new AlertDialog.Builder(ActivityWeatherData2.this).create();
                final GraphView grphview6 =  (GraphView) customDialogView.findViewById(R.id.graphdialog);
                alertDialogBuilder.setView(customDialogView);
                alertDialogBuilder.show();
                final TextView tv3 = (TextView) customDialogView.findViewById(R.id.titledialog);
                tv3.setText("Weather Asset 2 Max temperature");
                graphDatabaseHelper = new GraphDatabaseHelper(ActivityWeatherData2.this);
                sqLiteDatabase = graphDatabaseHelper.getWritableDatabase();
                series6.resetData(getDataPoint6());
                grphview6.addSeries(series6);
                series6.setTitle("Max temperature");
                series6.setThickness(8);
                grphview6.getViewport().setXAxisBoundsManual(true);
                grphview6.getViewport().setYAxisBoundsManual(true);
                grphview6.getViewport().scrollToEnd();
                grphview6.getViewport().setScalable(true);
                grphview6.getViewport().setScalableY(true);
                grphview6.getLegendRenderer().setVisible(true);
                grphview6.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
                grphview6.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
                    public String formatLabel(double value, boolean x){
                        if (x)
                        {
                            return sdf.format(new Date((long)value));
                        }else{
                            return super.formatLabel(value, x);
                        }
                    }
                });
                GridLabelRenderer gridLabel = grphview6.getGridLabelRenderer();
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
                LayoutInflater li = LayoutInflater.from(ActivityWeatherData2.this);
                View customDialogView = li.inflate(R.layout.custom_dialog, null);
                final AlertDialog alertDialogBuilder  = new AlertDialog.Builder(ActivityWeatherData2.this).create();
                final GraphView grphview7 =  (GraphView) customDialogView.findViewById(R.id.graphdialog);
                alertDialogBuilder.setView(customDialogView);
                alertDialogBuilder.show();
                final TextView tv3 = (TextView) customDialogView.findViewById(R.id.titledialog);
                tv3.setText("Weather Asset 2 Min temperature");
                graphDatabaseHelper = new GraphDatabaseHelper(ActivityWeatherData2.this);
                sqLiteDatabase = graphDatabaseHelper.getWritableDatabase();
                series7.resetData(getDataPoint7());
                grphview7.addSeries(series7);
                series7.setTitle("Min temperature");
                series7.setThickness(8);
                grphview7.getViewport().setXAxisBoundsManual(true);
                grphview7.getViewport().setYAxisBoundsManual(true);
                grphview7.getViewport().scrollToEnd();
                grphview7.getViewport().setScalable(true);
                grphview7.getViewport().setScalableY(true);
                grphview7.getLegendRenderer().setVisible(true);
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
                gridLabel.setVerticalAxisTitle("Min temperature (Celsius)");
                return true;
            }
        });
        RelativeLayout rltsea = findViewById(R.id.rtlwindspeed7);
        rltsea.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                LayoutInflater li = LayoutInflater.from(ActivityWeatherData2.this);
                View customDialogView = li.inflate(R.layout.custom_dialog, null);
                final AlertDialog alertDialogBuilder  = new AlertDialog.Builder(ActivityWeatherData2.this).create();
                final GraphView grphview8 =  (GraphView) customDialogView.findViewById(R.id.graphdialog);
                alertDialogBuilder.setView(customDialogView);
                alertDialogBuilder.show();
                final TextView tv3 = (TextView) customDialogView.findViewById(R.id.titledialog);
                tv3.setText("Weather Asset 2 Sea level");
                graphDatabaseHelper = new GraphDatabaseHelper(ActivityWeatherData2.this);
                sqLiteDatabase = graphDatabaseHelper.getWritableDatabase();
                series8.resetData(getDataPoint8());
                grphview8.addSeries(series8);
                series8.setTitle("Sea level");
                series8.setThickness(8);
                grphview8.getViewport().setXAxisBoundsManual(true);
                grphview8.getViewport().setYAxisBoundsManual(true);
                grphview8.getViewport().scrollToEnd();
                grphview8.getViewport().setScalable(true);
                grphview8.getViewport().setScalableY(true);
                grphview8.getLegendRenderer().setVisible(true);
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
                gridLabel.setVerticalAxisTitle("Sea level");
                return true;
            }
        });
        RelativeLayout rltgrnd = findViewById(R.id.rtlid);
        rltgrnd.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                LayoutInflater li = LayoutInflater.from(ActivityWeatherData2.this);
                View customDialogView = li.inflate(R.layout.custom_dialog, null);
                final AlertDialog alertDialogBuilder  = new AlertDialog.Builder(ActivityWeatherData2.this).create();
                final GraphView grphview9 =  (GraphView) customDialogView.findViewById(R.id.graphdialog);
                alertDialogBuilder.setView(customDialogView);
                alertDialogBuilder.show();
                final TextView tv3 = (TextView) customDialogView.findViewById(R.id.titledialog);
                tv3.setText("Weather Asset 2 Ground level");
                graphDatabaseHelper = new GraphDatabaseHelper(ActivityWeatherData2.this);
                sqLiteDatabase = graphDatabaseHelper.getWritableDatabase();
                series9.resetData(getDataPoint9());
                grphview9.addSeries(series9);
                series9.setTitle("Ground level");
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
                gridLabel.setVerticalAxisTitle("Ground level");
                return true;
            }
        });
    }

    private DataPoint[] getDataPoint8() {
        String[] columns = {"KEY_TIME2","KEY_SEALEVEL"};
        Cursor cursor = graphDatabaseHelper.GetData("SELECT * FROM contacts WHERE name = 'Weather Asset 2' ");
        DataPoint[] dp = new DataPoint[cursor.getCount()];
        //  if(cursor.getString(1)== "6H4PeKLRMea1L0WsRXXWp9") {
        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToNext();
            dp[i] = new DataPoint(cursor.getLong(13), cursor.getLong(11));
        }
        //}
        return dp;
    }

    private DataPoint[] getDataPoint9() {
        String[] columns = {"KEY_TIME2","KEY_GRNDLEVEL"};
        Cursor cursor = graphDatabaseHelper.GetData("SELECT * FROM contacts WHERE name = 'Weather Asset 2' ");
        DataPoint[] dp = new DataPoint[cursor.getCount()];
        //  if(cursor.getString(1)== "6H4PeKLRMea1L0WsRXXWp9") {
        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToNext();
            dp[i] = new DataPoint(cursor.getLong(13), cursor.getLong(12));
        }
        //}
        return dp;
    }

    private DataPoint[] getDataPoint7() {
        String[] columns = {"KEY_TIME2","KEY_TEMPMIN"};
        Cursor cursor = graphDatabaseHelper.GetData("SELECT * FROM contacts WHERE name = 'Weather Asset 2' ");
        DataPoint[] dp = new DataPoint[cursor.getCount()];
        //  if(cursor.getString(1)== "6H4PeKLRMea1L0WsRXXWp9") {
        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToNext();
            dp[i] = new DataPoint(cursor.getLong(13), cursor.getDouble(10));
        }
        //}
        return dp;
    }

    private DataPoint[] getDataPoint6() {
        String[] columns = {"KEY_TIME2","KEY_TEMPMAX"};
        Cursor cursor = graphDatabaseHelper.GetData("SELECT * FROM contacts WHERE name = 'Weather Asset 2' ");
        DataPoint[] dp = new DataPoint[cursor.getCount()];
        //  if(cursor.getString(1)== "6H4PeKLRMea1L0WsRXXWp9") {
        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToNext();
            dp[i] = new DataPoint(cursor.getLong(13), cursor.getDouble(9));
        }
        //}
        return dp;
    }

    private DataPoint[] getDataPoint5() {
        String[] columns = {"KEY_TIME2","KEY_PRESSURE"};
        Cursor cursor = graphDatabaseHelper.GetData("SELECT * FROM contacts WHERE name = 'Weather Asset 2' ");
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
        Cursor cursor = graphDatabaseHelper.GetData("SELECT * FROM contacts WHERE name = 'Weather Asset 2' ");
        DataPoint[] dp = new DataPoint[cursor.getCount()];
        //  if(cursor.getString(1)== "6H4PeKLRMea1L0WsRXXWp9") {
        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToNext();
            dp[i] = new DataPoint(cursor.getLong(15), cursor.getLong(14));
        }
        //}
        return dp;
    }

    private DataPoint[] getDataPoint3(){
        String[] columns = {"KEY_WINDSTIME","KEY_WINDSPEED"};
        Cursor cursor = graphDatabaseHelper.GetData("SELECT * FROM contacts WHERE name = 'Weather Asset 2' ");
        DataPoint[] dp = new DataPoint[cursor.getCount()];
        //  if(cursor.getString(1)== "6H4PeKLRMea1L0WsRXXWp9") {
        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToNext();
            dp[i] = new DataPoint(cursor.getLong(8), cursor.getInt(7));
        }
        //}
        return dp;
    }
    private DataPoint[] getDataPoint2(){
        String[] columns = {"KEY_HUMITIME","KEY_HUMIDITY"};
        Cursor cursor = graphDatabaseHelper.GetData("SELECT * FROM contacts WHERE name = 'Weather Asset 2' ");
        DataPoint[] dp = new DataPoint[cursor.getCount()];
        //  if(cursor.getString(1)== "6H4PeKLRMea1L0WsRXXWp9") {
        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToNext();
            dp[i] = new DataPoint(cursor.getLong(6), cursor.getInt(5));
        }
        //}
        return dp;
    }
    private DataPoint[] getDataPoint(){
        String[] columns = {"KEY_TEMPTIMESTAMP","KEY_TEMPERATURE"};
        Cursor cursor = graphDatabaseHelper.GetData("SELECT * FROM contacts WHERE name = 'Weather Asset 2' ");
        DataPoint[] dp = new DataPoint[cursor.getCount()];
        //  if(cursor.getString(1)== "6H4PeKLRMea1L0WsRXXWp9") {
        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToNext();
            dp[i] = new DataPoint(cursor.getLong(4), cursor.getInt(3));
        }
        //}
        return dp;
    }
}