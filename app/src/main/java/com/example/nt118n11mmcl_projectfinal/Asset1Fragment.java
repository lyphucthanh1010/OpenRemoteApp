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
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.Date;

public class Asset1Fragment extends Fragment {
    GraphDatabaseHelper graphDatabaseHelper;
    GraphView graph15;
    GraphView graph;GraphView graph2;
    GraphView graph3;
    GraphView graph10 ;GraphView graph11;
    GraphView graph12; GraphView graph13;

    GraphView graph14;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM");
    SQLiteDatabase sqLiteDatabase;
    DataGraph dataGraph;
    private Context context;
    DataGraphAdapter dataGraphAdapter;
    LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[0]);
    LineGraphSeries<DataPoint> series2 = new LineGraphSeries<>(new DataPoint[0]);
    LineGraphSeries<DataPoint> series3 = new LineGraphSeries<>(new DataPoint[0]);
    LineGraphSeries<DataPoint> series10 = new LineGraphSeries<>(new DataPoint[0]);
    LineGraphSeries<DataPoint> series11 = new LineGraphSeries<>(new DataPoint[0]);
    LineGraphSeries<DataPoint> series12 = new LineGraphSeries<>(new DataPoint[0]);
    LineGraphSeries<DataPoint> series13 = new LineGraphSeries<>(new DataPoint[0]);
    LineGraphSeries<DataPoint> series14 = new LineGraphSeries<>(new DataPoint[0]);
    LineGraphSeries<DataPoint> series15 = new LineGraphSeries<>(new DataPoint[0]);
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.asset1_fragment, container, false);
        this.context = getContext();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        ImageView img = view.findViewById(R.id.backpic);
//        img.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
////              GraphActivity.super.onBackPressed();
//            }
//        });
        ImageView img = view.findViewById(R.id.backpic);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
        graph15 = (GraphView)  view.findViewById(R.id.graphgrnd);
        graphDatabaseHelper = new GraphDatabaseHelper(context);
        sqLiteDatabase = graphDatabaseHelper.getWritableDatabase();
        series15.resetData(getDataPoint15());
        graph15.addSeries(series15);
        series15.setTitle("Ground level");
        series15.setThickness(8);
        graph15.getViewport().setXAxisBoundsManual(true);
        graph15.getViewport().setYAxisBoundsManual(true);
        graph15.getViewport().scrollToEnd();
        graph15.getViewport().setScalable(true);
        graph15.getViewport().setScalableY(true);
        graph15.getLegendRenderer().setVisible(true);
        graph15.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
        graph15.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
            public String formatLabel(double value, boolean x){
                if (x)
                {
                    return sdf.format(new Date((long)value));
                }else{
                    return super.formatLabel(value, x);
                }
            }
        });
        GridLabelRenderer gridLabel = graph15.getGridLabelRenderer();
        gridLabel.setHorizontalAxisTitle("Time");
        gridLabel.setHorizontalAxisTitleTextSize(30);
        gridLabel.setVerticalAxisTitle("Ground level");

        graph14 = (GraphView)  view.findViewById(R.id.graphsea);
        graphDatabaseHelper = new GraphDatabaseHelper(context);
        sqLiteDatabase = graphDatabaseHelper.getWritableDatabase();
        series14.resetData(getDataPoint14());
        graph14.addSeries(series14);
        series14.setTitle("Sea level");
        series14.setThickness(8);
        graph14.getViewport().setXAxisBoundsManual(true);
        graph14.getViewport().setYAxisBoundsManual(true);
        graph14.getViewport().scrollToEnd();
        graph14.getViewport().setScalable(true);
        graph14.getViewport().setScalableY(true);
        graph14.getLegendRenderer().setVisible(true);
        graph14.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
        graph14.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
            public String formatLabel(double value, boolean x){
                if (x)
                {
                    return sdf.format(new Date((long)value));
                }else{
                    return super.formatLabel(value, x);
                }
            }
        });
        GridLabelRenderer gridLabel2 = graph14.getGridLabelRenderer();
        gridLabel2.setHorizontalAxisTitle("Time");
        gridLabel2.setHorizontalAxisTitleTextSize(30);
        gridLabel2.setVerticalAxisTitle("Sea level");

        graph = (GraphView) view.findViewById(R.id.graphtemper);
        graphDatabaseHelper = new GraphDatabaseHelper(context);
        sqLiteDatabase = graphDatabaseHelper.getWritableDatabase();
        series.resetData(getDataPoint());
        graph.addSeries(series);
        series.setTitle("Temperature");
        series.setThickness(8);
        graph.getLegendRenderer().setVisible(true);
        graph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().scrollToEnd();
        graph.getViewport().setScalable(true);
        graph.getViewport().setScalableY(true);
        graph.getViewport().setScrollable(true);
        graph.getViewport().setScrollableY(true);
//        graph.getViewport().setMaxY(30);
//        graph.getViewport().setMinY(12);
               graph.getViewport().getMaxXAxisSize();
        graph.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
            public String formatLabel(double value, boolean x){
                if (x)
                {
                    return sdf.format(new Date((long)value));
                }else{
                    return super.formatLabel(value, x);
                }
            }
        });
        GridLabelRenderer gridLabel3 = graph.getGridLabelRenderer();
        gridLabel3.setHorizontalAxisTitle("Time");
        gridLabel3.setHorizontalAxisTitleTextSize(30);
        gridLabel3.setVerticalAxisTitle("Temperature (Celsius)");
        gridLabel3.setVerticalAxisTitleTextSize(30);

        graph3 = (GraphView) view.findViewById(R.id.graphwindspeed);
        graphDatabaseHelper = new GraphDatabaseHelper(context);
        sqLiteDatabase = graphDatabaseHelper.getWritableDatabase();
        series3.resetData(getDataPoint3());
        graph3.addSeries(series3);
        series3.setTitle("Windspeed");
        series3.setThickness(8);
        graph3.getLegendRenderer().setVisible(true);
        graph3.getViewport().setXAxisBoundsManual(true);
        graph3.getViewport().setYAxisBoundsManual(true);
        graph3.getViewport().scrollToEnd();
        graph3.getViewport().setScalable(true);
        graph3.getViewport().setScalableY(true);
        graph3.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
        graph3.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
            public String formatLabel(double value, boolean x){
                if (x)
                {
                    return sdf.format(new Date((long)value));
                }else{
                    return super.formatLabel(value, x);
                }
            }
        });
        GridLabelRenderer gridLabel4 = graph3.getGridLabelRenderer();
        gridLabel4.setHorizontalAxisTitle("Time");
        gridLabel4.setHorizontalAxisTitleTextSize(30);
        gridLabel4.setVerticalAxisTitle("Wind speed (km/h)");
        gridLabel4.setVerticalAxisTitleTextSize(30);

        graph2 = (GraphView) view.findViewById(R.id.graphhumidity);
        graphDatabaseHelper = new GraphDatabaseHelper(context);
        sqLiteDatabase = graphDatabaseHelper.getWritableDatabase();
        series2.resetData(getDataPoint2());
        graph2.addSeries(series2);
        series2.setTitle("Humidity");
        series2.setThickness(8);
        graph2.getViewport().setXAxisBoundsManual(true);
        graph2.getViewport().setYAxisBoundsManual(true);
        graph2.getViewport().scrollToEnd();
        graph2.getViewport().setScalable(true);
        graph2.getViewport().setScalableY(true);
        graph2.getLegendRenderer().setVisible(true);
        graph2.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
        graph2.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
            public String formatLabel(double value, boolean x){
                if (x)
                {
                    return sdf.format(new Date((long)value));
                }else{
                    return super.formatLabel(value, x);
                }
            }
        });
        GridLabelRenderer gridLabel5 = graph2.getGridLabelRenderer();
        gridLabel5.setHorizontalAxisTitle("Time");
        gridLabel5.setHorizontalAxisTitleTextSize(30);
        gridLabel5.setVerticalAxisTitle("Humidity (%)");
        gridLabel5.setVerticalAxisTitleTextSize(30);

        graph10 = (GraphView)  view.findViewById(R.id.graphwinddirection);
        graphDatabaseHelper = new GraphDatabaseHelper(context);
        sqLiteDatabase = graphDatabaseHelper.getWritableDatabase();
        series10.resetData(getDataPoint10());
        graph10.addSeries(series10);
        series10.setTitle("Wind direction");
        series10.setThickness(8);
        graph10.getViewport().setXAxisBoundsManual(true);
        graph10.getViewport().setYAxisBoundsManual(true);
        graph10.getViewport().scrollToEnd();
        graph10.getViewport().setScalable(true);
        graph10.getViewport().setScalableY(true);
        graph10.getLegendRenderer().setVisible(true);
        graph10.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
        graph10.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
            public String formatLabel(double value, boolean x){
                if (x)
                {
                    return sdf.format(new Date((long)value));
                }else{
                    return super.formatLabel(value, x);
                }
            }
        });
        GridLabelRenderer gridLabel6 = graph10.getGridLabelRenderer();
        gridLabel6.setHorizontalAxisTitle("Time");
        gridLabel6.setHorizontalAxisTitleTextSize(30);
        gridLabel6.setVerticalAxisTitle("Wind direction");

        graph11 = (GraphView)  view.findViewById(R.id.graphpressure);
        graphDatabaseHelper = new GraphDatabaseHelper(context);
        sqLiteDatabase = graphDatabaseHelper.getWritableDatabase();
        series11.resetData(getDataPoint11());
        graph11.addSeries(series11);
        series11.setTitle("Pressure");
        series11.setThickness(8);
        graph11.getViewport().setXAxisBoundsManual(true);
        graph11.getViewport().setYAxisBoundsManual(true);
        graph11.getViewport().scrollToEnd();
        graph11.getViewport().setScalable(true);
        graph11.getViewport().setScalableY(true);
        graph11.getLegendRenderer().setVisible(true);
        graph11.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
        graph11.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
            public String formatLabel(double value, boolean x){
                if (x)
                {
                    return sdf.format(new Date((long)value));
                }else{
                    return super.formatLabel(value, x);
                }
            }
        });
        GridLabelRenderer gridLabel7 = graph11.getGridLabelRenderer();
        gridLabel7.setHorizontalAxisTitle("Time");
        gridLabel7.setHorizontalAxisTitleTextSize(30);
        gridLabel7.setVerticalAxisTitle("Pressure");

        graph12 = (GraphView)  view.findViewById(R.id.graphmax);
        graphDatabaseHelper = new GraphDatabaseHelper(context);
        sqLiteDatabase = graphDatabaseHelper.getWritableDatabase();
        series12.resetData(getDataPoint12());
        graph12.addSeries(series12);
        series12.setTitle("Max temperature");
        series12.setThickness(8);
        graph12.getViewport().setXAxisBoundsManual(true);
        graph12.getViewport().setYAxisBoundsManual(true);
        graph12.getViewport().scrollToEnd();
        graph12.getViewport().setScalable(true);
        graph12.getViewport().setScalableY(true);
        graph12.getLegendRenderer().setVisible(true);
        graph12.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
        graph12.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
            public String formatLabel(double value, boolean x){
                if (x)
                {
                    return sdf.format(new Date((long)value));
                }else{
                    return super.formatLabel(value, x);
                }
            }
        });
        GridLabelRenderer gridLabel8 = graph12.getGridLabelRenderer();
        gridLabel8.setHorizontalAxisTitle("Time");
        gridLabel8.setHorizontalAxisTitleTextSize(30);
        gridLabel8.setVerticalAxisTitle("Max temperature (Celsius)");

        graph13 = (GraphView)  view.findViewById(R.id.graphmin);
        graphDatabaseHelper = new GraphDatabaseHelper(context);
        sqLiteDatabase = graphDatabaseHelper.getWritableDatabase();
        series13.resetData(getDataPoint13());
        graph13.addSeries(series13);
        series13.setTitle("Min temperature");
        series13.setThickness(8);
        graph13.getViewport().setXAxisBoundsManual(true);
        graph13.getViewport().setYAxisBoundsManual(true);
        graph13.getViewport().scrollToEnd();
        graph13.getViewport().setScalable(true);
        graph13.getViewport().setScalableY(true);
        graph13.getLegendRenderer().setVisible(true);
        graph13.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
        graph13.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
            public String formatLabel(double value, boolean x){
                if (x)
                {
                    return sdf.format(new Date((long)value));
                }else{
                    return super.formatLabel(value, x);
                }
            }
        });
        GridLabelRenderer gridLabel9 = graph13.getGridLabelRenderer();
        gridLabel9.setHorizontalAxisTitle("Time");
        gridLabel9.setHorizontalAxisTitleTextSize(30);
        gridLabel9.setVerticalAxisTitle("Min temperature (Celsius)");
    }
    private DataPoint[] getDataPoint13() {
        String[] columns = {"KEY_TIME2","KEY_TEMPMIN"};
        Cursor cursor = graphDatabaseHelper.GetData("SELECT * FROM contacts WHERE name = 'Weather Asset' ");
        DataPoint[] dp = new DataPoint[cursor.getCount()];
        //  if(cursor.getString(1)== "6H4PeKLRMea1L0WsRXXWp9") {
        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToNext();
            dp[i] = new DataPoint(cursor.getLong(13), cursor.getDouble(10));
        }
        //}
        return dp;
    }
    private DataPoint[] getDataPoint12() {
        String[] columns = {"KEY_TIME2","KEY_TEMPMAX"};
        Cursor cursor = graphDatabaseHelper.GetData("SELECT * FROM contacts WHERE name = 'Weather Asset' ");
        DataPoint[] dp = new DataPoint[cursor.getCount()];
        //  if(cursor.getString(1)== "6H4PeKLRMea1L0WsRXXWp9") {
        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToNext();
            dp[i] = new DataPoint(cursor.getLong(13), cursor.getDouble(9));
        }
        //}
        return dp;
    }
    private DataPoint[] getDataPoint11() {
        String[] columns = {"KEY_TIME2","KEY_PRESSURE"};
        Cursor cursor = graphDatabaseHelper.GetData("SELECT * FROM contacts WHERE name = 'Weather Asset' ");
        DataPoint[] dp = new DataPoint[cursor.getCount()];
        //  if(cursor.getString(1)== "6H4PeKLRMea1L0WsRXXWp9") {
        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToNext();
            dp[i] = new DataPoint(cursor.getLong(13), cursor.getLong(16));
        }
        //}
        return dp;
    }

    private DataPoint[] getDataPoint10() {
        String[] columns = {"KEY_WINDTIMESTAMP","KEY_WINDDIREC"};
        Cursor cursor = graphDatabaseHelper.GetData("SELECT * FROM contacts WHERE name = 'Weather Asset' ");
        DataPoint[] dp = new DataPoint[cursor.getCount()];
        //  if(cursor.getString(1)== "6H4PeKLRMea1L0WsRXXWp9") {
        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToNext();
            dp[i] = new DataPoint(cursor.getLong(15), cursor.getLong(14));
        }
        //}
        return dp;
    }
    private DataPoint[] getDataPoint15() {
        String[] columns = {"KEY_TIME2","KEY_GRNDLEVEL"};
        Cursor cursor = graphDatabaseHelper.GetData("SELECT * FROM contacts WHERE name = 'Weather Asset' ");
        DataPoint[] dp = new DataPoint[cursor.getCount()];
        //  if(cursor.getString(1)== "6H4PeKLRMea1L0WsRXXWp9") {
        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToNext();
            dp[i] = new DataPoint(cursor.getLong(13), cursor.getLong(12));
        }
        //}
        return dp;
    }
    private DataPoint[] getDataPoint14() {
        String[] columns = {"KEY_TIME2","KEY_SEALEVEL"};
        Cursor cursor = graphDatabaseHelper.GetData("SELECT * FROM contacts WHERE name = 'Weather Asset' ");
        DataPoint[] dp = new DataPoint[cursor.getCount()];
        //  if(cursor.getString(1)== "6H4PeKLRMea1L0WsRXXWp9") {
        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToNext();
            dp[i] = new DataPoint(cursor.getLong(13), cursor.getLong(11));
        }
        //}
        return dp;
    }
    private DataPoint[] getDataPoint3(){
        String[] columns = {"KEY_WINDSTIME","KEY_WINDSPEED"};
        Cursor cursor = graphDatabaseHelper.GetData("SELECT * FROM contacts WHERE name = 'Weather Asset'");
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
        Cursor cursor = graphDatabaseHelper.GetData("SELECT * FROM contacts WHERE name = 'Weather Asset'");
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
        Cursor cursor = graphDatabaseHelper.GetData("SELECT * FROM contacts WHERE name = 'Weather Asset'");
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
