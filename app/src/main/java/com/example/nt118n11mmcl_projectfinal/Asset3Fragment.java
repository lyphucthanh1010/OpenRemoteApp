package com.example.nt118n11mmcl_projectfinal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.Date;

public class Asset3Fragment extends Fragment {
    SimpleDateFormat sdf = new SimpleDateFormat("dd ");
    SQLiteDatabase sqLiteDatabase;
    DataGraph dataGraph;
    APIInterface apiInterface;

    GraphView graph7; GraphView graph8;
    GraphView graph9;
    GraphView graph23; GraphView graph24;
    GraphView graph25; GraphView graph26;
    LineGraphSeries<DataPoint> series7 = new LineGraphSeries<>(new DataPoint[0]);
    LineGraphSeries<DataPoint> series8 = new LineGraphSeries<>(new DataPoint[0]);
    LineGraphSeries<DataPoint> series9 = new LineGraphSeries<>(new DataPoint[0]);
    LineGraphSeries<DataPoint> series23 = new LineGraphSeries<>(new DataPoint[0]);
    LineGraphSeries<DataPoint> series24 = new LineGraphSeries<>(new DataPoint[0]);
    GraphDatabaseHelper graphDatabaseHelper;
    LineGraphSeries<DataPoint> series25 = new LineGraphSeries<>(new DataPoint[0]);
    LineGraphSeries<DataPoint> series26 = new LineGraphSeries<>(new DataPoint[0]);
    private Context context;
    DataGraphAdapter dataGraphAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.asset3_fragment, container, false);
        this.context = getContext();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        graph26 = (GraphView)  view.findViewById(R.id.graphmin3);
        graphDatabaseHelper = new GraphDatabaseHelper(context);
        sqLiteDatabase = graphDatabaseHelper.getWritableDatabase();
        series26.resetData(getDataPoint26());
        graph26.addSeries(series26);
        series26.setTitle("Min temperature");
        series26.setThickness(8);
        graph26.getViewport().setXAxisBoundsManual(true);
        graph26.getViewport().setYAxisBoundsManual(true);
        graph26.getViewport().scrollToEnd();
        graph26.getViewport().setScalable(true);
        graph26.getViewport().setScalableY(true);
        graph26.getLegendRenderer().setVisible(true);
        graph26.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
        graph26.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
            public String formatLabel(double value, boolean x){
                if (x)
                {
                    return sdf.format(new Date((long)value));
                }else{
                    return super.formatLabel(value, x);
                }
            }
        });
        GridLabelRenderer gridLabel = graph26.getGridLabelRenderer();
        gridLabel.setHorizontalAxisTitle("Time");
        gridLabel.setHorizontalAxisTitleTextSize(30);
        gridLabel.setVerticalAxisTitle("Min temperature (Celsius)");
        ImageView img = view.findViewById(R.id.backpic);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
        graph25 = (GraphView)  view.findViewById(R.id.graphmax3);
        graphDatabaseHelper = new GraphDatabaseHelper(context);
        sqLiteDatabase = graphDatabaseHelper.getWritableDatabase();
        series25.resetData(getDataPoint25());
        graph25.addSeries(series25);
        series25.setTitle("Max temperature");
        series25.setThickness(8);
        graph25.getViewport().setXAxisBoundsManual(true);
        graph25.getViewport().setYAxisBoundsManual(true);
        graph25.getViewport().scrollToEnd();
        graph25.getViewport().setScalable(true);
        graph25.getViewport().setScalableY(true);
        graph25.getLegendRenderer().setVisible(true);
        graph25.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
        graph25.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
            public String formatLabel(double value, boolean x){
                if (x)
                {
                    return sdf.format(new Date((long)value));
                }else{
                    return super.formatLabel(value, x);
                }
            }
        });
        GridLabelRenderer gridLabel2 = graph25.getGridLabelRenderer();
        gridLabel2.setHorizontalAxisTitle("Time");
        gridLabel2.setHorizontalAxisTitleTextSize(30);
        gridLabel2.setVerticalAxisTitle("Max temperature (Celsius)");

        graph24 = (GraphView)  view.findViewById(R.id.graphpressure3);
        graphDatabaseHelper = new GraphDatabaseHelper(context);
        sqLiteDatabase = graphDatabaseHelper.getWritableDatabase();
        series24.resetData(getDataPoint24());
        graph24.addSeries(series24);
        series24.setTitle("Pressure");
        series24.setThickness(8);
        graph24.getViewport().setXAxisBoundsManual(true);
        graph24.getViewport().setYAxisBoundsManual(true);
        graph24.getViewport().scrollToEnd();
        graph24.getViewport().setScalable(true);
        graph24.getViewport().setScalableY(true);
        graph24.getLegendRenderer().setVisible(true);
        graph24.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
        graph24.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
            public String formatLabel(double value, boolean x){
                if (x)
                {
                    return sdf.format(new Date((long)value));
                }else{
                    return super.formatLabel(value, x);
                }
            }
        });
        GridLabelRenderer gridLabel3 = graph24.getGridLabelRenderer();
        gridLabel3.setHorizontalAxisTitle("Time");
        gridLabel3.setHorizontalAxisTitleTextSize(30);
        gridLabel3.setVerticalAxisTitle("Pressure");

        graph23 = (GraphView)  view.findViewById(R.id.graphwinddirection3);
        graphDatabaseHelper = new GraphDatabaseHelper(context);
        sqLiteDatabase = graphDatabaseHelper.getWritableDatabase();
        series23.resetData(getDataPoint23());
        graph23.addSeries(series23);
        series23.setTitle("Wind direction");
        series23.setThickness(8);
        graph23.getViewport().setXAxisBoundsManual(true);
        graph23.getViewport().setYAxisBoundsManual(true);
        graph23.getViewport().scrollToEnd();
        graph23.getViewport().setScalable(true);
        graph23.getViewport().setScalableY(true);
        graph23.getLegendRenderer().setVisible(true);
        graph23.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
        graph23.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
            public String formatLabel(double value, boolean x){
                if (x)
                {
                    return sdf.format(new Date((long)value));
                }else{
                    return super.formatLabel(value, x);
                }
            }
        });
        GridLabelRenderer gridLabel4 = graph23.getGridLabelRenderer();
        gridLabel4.setHorizontalAxisTitle("Time");
        gridLabel4.setHorizontalAxisTitleTextSize(30);
        gridLabel4.setVerticalAxisTitle("Wind direction");

        graph9 = (GraphView) view.findViewById(R.id.graphwindspeed3);
        graphDatabaseHelper = new GraphDatabaseHelper(context);
        sqLiteDatabase = graphDatabaseHelper.getWritableDatabase();
        series9.resetData(getDataPoint9());
        graph9.addSeries(series9);
        series9.setTitle("Windspeed");
        series9.setThickness(8);
        graph9.getViewport().setXAxisBoundsManual(true);
        graph9.getViewport().setYAxisBoundsManual(true);
        graph9.getViewport().scrollToEnd();
        graph9.getViewport().setScalable(true);
        graph9.getViewport().setScalableY(true);
        graph9.getLegendRenderer().setVisible(true);
        graph9.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
        graph9.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
            public String formatLabel(double value, boolean x){
                if (x)
                {
                    return sdf.format(new Date((long)value));
                }else{
                    return super.formatLabel(value, x);
                }
            }
        });
        GridLabelRenderer gridLabel5 = graph9.getGridLabelRenderer();
        gridLabel5.setHorizontalAxisTitle("Time");
        gridLabel5.setHorizontalAxisTitleTextSize(30);
        gridLabel5.setVerticalAxisTitle("Wind speed (km/h)");

        graph8 = (GraphView) view.findViewById(R.id.graphhumidity3);
        graphDatabaseHelper = new GraphDatabaseHelper(context);
        sqLiteDatabase = graphDatabaseHelper.getWritableDatabase();
        series8.resetData(getDataPoint8());
        graph8.addSeries(series8);
        series8.setTitle("Humidity");
        series8.setThickness(8);
        graph8.getLegendRenderer().setVisible(true);
        graph8.getViewport().setXAxisBoundsManual(true);
        graph8.getViewport().setYAxisBoundsManual(true);
        graph8.getViewport().scrollToEnd();
        graph8.getViewport().setScalable(true);
        graph8.getViewport().setScalableY(true);
        graph8.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
        graph8.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
            public String formatLabel(double value, boolean x){
                if (x)
                {
                    return sdf.format(new Date((long)value));
                }else{
                    return super.formatLabel(value, x);
                }
            }
        });
        GridLabelRenderer gridLabel6 = graph8.getGridLabelRenderer();
        gridLabel6.setHorizontalAxisTitle("Time");
        gridLabel6.setHorizontalAxisTitleTextSize(30);
        gridLabel6.setVerticalAxisTitle("Humidity (%)");
        gridLabel6.setVerticalAxisTitleTextSize(30);

        graph7 = (GraphView) view.findViewById(R.id.graphtemper3);
        graphDatabaseHelper = new GraphDatabaseHelper(context);
        sqLiteDatabase = graphDatabaseHelper.getWritableDatabase();
        series7.resetData(getDataPoint7());
        graph7.addSeries(series7);
        series7.setTitle("Temperature");
        series7.setThickness(8);
        graph7.getLegendRenderer().setVisible(true);
        graph7.getViewport().setXAxisBoundsManual(true);
        graph7.getViewport().setYAxisBoundsManual(true);
        graph7.getViewport().scrollToEnd();
        graph7.getViewport().setScalable(true);
        graph7.getViewport().setScalableY(true);
        graph7.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
        graph7.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
            public String formatLabel(double value, boolean x){
                if (x)
                {
                    return sdf.format(new Date((long)value));
                }else{
                    return super.formatLabel(value, x);
                }
            }
        });
        GridLabelRenderer gridLabel7 = graph7.getGridLabelRenderer();
        gridLabel7.setHorizontalAxisTitle("Time");
        gridLabel7.setHorizontalAxisTitleTextSize(30);
        gridLabel7.setVerticalAxisTitle("Temperature (Celsius)");
        gridLabel7.setVerticalAxisTitleTextSize(30);

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
    private DataPoint[] getDataPoint23() {
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
    private DataPoint[] getDataPoint24() {
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

    private DataPoint[] getDataPoint26() {
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
    private DataPoint[] getDataPoint25() {
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

}
