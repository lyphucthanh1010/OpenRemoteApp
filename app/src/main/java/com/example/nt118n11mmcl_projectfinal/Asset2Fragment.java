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

public class Asset2Fragment extends Fragment {
    GraphDatabaseHelper graphDatabaseHelper;
    SQLiteDatabase sqLiteDatabase;
    DataGraph dataGraph;
    SimpleDateFormat sdf = new SimpleDateFormat("dd ");
    DataGraphAdapter dataGraphAdapter;
    private Context context;
    GraphView graph4;

    GraphView graph5; GraphView graph6;
    GraphView graph16; GraphView graph17;
    GraphView graph18;
    GraphView graph19;GraphView graph20;
    GraphView graph21;
    LineGraphSeries<DataPoint> series4 = new LineGraphSeries<>(new DataPoint[0]);
    LineGraphSeries<DataPoint> series5 = new LineGraphSeries<>(new DataPoint[0]);
    LineGraphSeries<DataPoint> series6 = new LineGraphSeries<>(new DataPoint[0]);
    LineGraphSeries<DataPoint> series16 = new LineGraphSeries<>(new DataPoint[0]);
    LineGraphSeries<DataPoint> series17 = new LineGraphSeries<>(new DataPoint[0]);
    LineGraphSeries<DataPoint> series18 = new LineGraphSeries<>(new DataPoint[0]);
    LineGraphSeries<DataPoint> series19 = new LineGraphSeries<>(new DataPoint[0]);
    LineGraphSeries<DataPoint> series20 = new LineGraphSeries<>(new DataPoint[0]);
    LineGraphSeries<DataPoint> series21 = new LineGraphSeries<>(new DataPoint[0]);
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.asset2_fragment, container, false);
        this.context = getContext();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        graph21 = (GraphView) view.findViewById(R.id.graphgrnd2);
        graphDatabaseHelper = new GraphDatabaseHelper(context);
        sqLiteDatabase = graphDatabaseHelper.getWritableDatabase();
        series21.resetData(getDataPoint21());
        graph21.addSeries(series21);
        series21.setTitle("Ground level");
        series21.setThickness(8);
        graph21.getViewport().setXAxisBoundsManual(true);
        graph21.getViewport().setYAxisBoundsManual(true);
        graph21.getViewport().scrollToEnd();
        graph21.getViewport().setScalable(true);
        graph21.getViewport().setScalableY(true);
        graph21.getLegendRenderer().setVisible(true);
        graph21.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
        graph21.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
            public String formatLabel(double value, boolean x){
                if (x)
                {
                    return sdf.format(new Date((long)value));
                }else{
                    return super.formatLabel(value, x);
                }
            }
        });
        GridLabelRenderer gridLabel = graph21.getGridLabelRenderer();
        gridLabel.setHorizontalAxisTitle("Time");
        gridLabel.setHorizontalAxisTitleTextSize(30);
        gridLabel.setVerticalAxisTitle("Ground level");
        ImageView img = view.findViewById(R.id.backpic);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
        graph20 = (GraphView)  view.findViewById(R.id.graphsea2);
        graphDatabaseHelper = new GraphDatabaseHelper(context);
        sqLiteDatabase = graphDatabaseHelper.getWritableDatabase();
        series20.resetData(getDataPoint20());
        graph20.addSeries(series20);
        series20.setTitle("Sea level");
        series20.setThickness(8);
        graph20.getViewport().setXAxisBoundsManual(true);
        graph20.getViewport().setYAxisBoundsManual(true);
        graph20.getViewport().scrollToEnd();
        graph20.getViewport().setScalable(true);
        graph20.getViewport().setScalableY(true);
        graph20.getLegendRenderer().setVisible(true);
        graph20.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
        graph20.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
            public String formatLabel(double value, boolean x){
                if (x)
                {
                    return sdf.format(new Date((long)value));
                }else{
                    return super.formatLabel(value, x);
                }
            }
        });
        GridLabelRenderer gridLabel2 = graph20.getGridLabelRenderer();
        gridLabel2.setHorizontalAxisTitle("Time");
        gridLabel2.setHorizontalAxisTitleTextSize(30);
        gridLabel2.setVerticalAxisTitle("Sea level");

        graph19 = (GraphView)  view.findViewById(R.id.graphmin2);
        graphDatabaseHelper = new GraphDatabaseHelper(context);
        sqLiteDatabase = graphDatabaseHelper.getWritableDatabase();
        series19.resetData(getDataPoint19());
        graph19.addSeries(series19);
        series19.setTitle("Min temperature");
        series19.setThickness(8);
        graph19.getViewport().setXAxisBoundsManual(true);
        graph19.getViewport().setYAxisBoundsManual(true);
        graph19.getViewport().scrollToEnd();
        graph19.getViewport().setScalable(true);
        graph19.getViewport().setScalableY(true);
        graph19.getLegendRenderer().setVisible(true);
        graph19.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
        graph19.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
            public String formatLabel(double value, boolean x){
                if (x)
                {
                    return sdf.format(new Date((long)value));
                }else{
                    return super.formatLabel(value, x);
                }
            }
        });
        GridLabelRenderer gridLabel3 = graph19.getGridLabelRenderer();
        gridLabel3.setHorizontalAxisTitle("Time");
        gridLabel3.setHorizontalAxisTitleTextSize(30);
        gridLabel3.setVerticalAxisTitle("Min temperature (Celsius)");

        graph18 = (GraphView)  view.findViewById(R.id.graphmax2);
        graphDatabaseHelper = new GraphDatabaseHelper(context);
        sqLiteDatabase = graphDatabaseHelper.getWritableDatabase();
        series18.resetData(getDataPoint18());
        graph18.addSeries(series18);
        series18.setTitle("Max temperature");
        series18.setThickness(8);
        graph18.getViewport().setXAxisBoundsManual(true);
        graph18.getViewport().setYAxisBoundsManual(true);
        graph18.getViewport().scrollToEnd();
        graph18.getViewport().setScalable(true);
        graph18.getViewport().setScalableY(true);
        graph18.getLegendRenderer().setVisible(true);
        graph18.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
        graph18.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
            public String formatLabel(double value, boolean x){
                if (x)
                {
                    return sdf.format(new Date((long)value));
                }else{
                    return super.formatLabel(value, x);
                }
            }
        });
        GridLabelRenderer gridLabel4 = graph18.getGridLabelRenderer();
        gridLabel4.setHorizontalAxisTitle("Time");
        gridLabel4.setHorizontalAxisTitleTextSize(30);
        gridLabel4.setVerticalAxisTitle("Max temperature (Celsius)");

        graph17 = (GraphView)  view.findViewById(R.id.graphpressure2);
        graphDatabaseHelper = new GraphDatabaseHelper(context);
        sqLiteDatabase = graphDatabaseHelper.getWritableDatabase();
        series17.resetData(getDataPoint17());
        graph17.addSeries(series17);
        series17.setTitle("Pressure");
        series17.setThickness(8);
        graph17.getViewport().setXAxisBoundsManual(true);
        graph17.getViewport().setYAxisBoundsManual(true);
        graph17.getViewport().scrollToEnd();
        graph17.getViewport().setScalable(true);
        graph17.getViewport().setScalableY(true);
        graph17.getLegendRenderer().setVisible(true);
        graph17.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
        graph17.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
            public String formatLabel(double value, boolean x){
                if (x)
                {
                    return sdf.format(new Date((long)value));
                }else{
                    return super.formatLabel(value, x);
                }
            }
        });
        GridLabelRenderer gridLabel5 = graph17.getGridLabelRenderer();
        gridLabel5.setHorizontalAxisTitle("Time");
        gridLabel5.setHorizontalAxisTitleTextSize(30);
        gridLabel5.setVerticalAxisTitle("Pressure");

        graph16 = (GraphView)  view.findViewById(R.id.graphwinddirection2);
        graphDatabaseHelper = new GraphDatabaseHelper(context);
        sqLiteDatabase = graphDatabaseHelper.getWritableDatabase();
        series16.resetData(getDataPoint16());
        graph16.addSeries(series16);
        series16.setTitle("Wind direction");
        series16.setThickness(8);
        graph16.getViewport().setXAxisBoundsManual(true);
        graph16.getViewport().setYAxisBoundsManual(true);
        graph16.getViewport().scrollToEnd();
        graph16.getViewport().setScalable(true);
        graph16.getViewport().setScalableY(true);
        graph16.getLegendRenderer().setVisible(true);
        graph16.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
        graph16.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
            public String formatLabel(double value, boolean x){
                if (x)
                {
                    return sdf.format(new Date((long)value));
                }else{
                    return super.formatLabel(value, x);
                }
            }
        });
        GridLabelRenderer gridLabel6 = graph16.getGridLabelRenderer();
        gridLabel6.setHorizontalAxisTitle("Time");
        gridLabel6.setHorizontalAxisTitleTextSize(30);
        gridLabel6.setVerticalAxisTitle("Wind direction");

        graph6 = (GraphView) view.findViewById(R.id.graphwindspeed2);
        graphDatabaseHelper = new GraphDatabaseHelper(context);
        sqLiteDatabase = graphDatabaseHelper.getWritableDatabase();
        series6.resetData(getDataPoint6());
        graph6.addSeries(series6);
        series6.setTitle("Windspeed");
        series6.setThickness(8);
        graph6.getViewport().setXAxisBoundsManual(true);
        graph6.getViewport().setYAxisBoundsManual(true);
        graph6.getViewport().scrollToEnd();
        graph6.getViewport().setScalable(true);
        graph6.getViewport().setScalableY(true);
        graph6.getLegendRenderer().setVisible(true);
        graph6.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
        graph6.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
            public String formatLabel(double value, boolean x){
                if (x)
                {
                    return sdf.format(new Date((long)value));
                }else{
                    return super.formatLabel(value, x);
                }
            }
        });
        GridLabelRenderer gridLabel7 = graph6.getGridLabelRenderer();
        gridLabel7.setHorizontalAxisTitle("Time");
        gridLabel7.setHorizontalAxisTitleTextSize(30);
        gridLabel7.setVerticalAxisTitle("Wind speed (km/h)");

        graph4 = (GraphView) view.findViewById(R.id.graphtemper2);
        graphDatabaseHelper = new GraphDatabaseHelper(context);
        sqLiteDatabase = graphDatabaseHelper.getWritableDatabase();
        series4.resetData(getDataPoint4());
        graph4.addSeries(series4);
        series4.setTitle("Temperature");
        series4.setThickness(8);
        graph4.getViewport().setXAxisBoundsManual(true);
        graph4.getViewport().setYAxisBoundsManual(true);
        graph4.getViewport().scrollToEnd();
        graph4.getViewport().setScalable(true);
        graph4.getViewport().setScalableY(true);
        graph4.getLegendRenderer().setVisible(true);
        graph4.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
        graph4.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
            public String formatLabel(double value, boolean x){
                if (x)
                {
                    return sdf.format(new Date((long)value));
                }else{
                    return super.formatLabel(value, x);
                }
            }
        });
        GridLabelRenderer gridLabel8 = graph4.getGridLabelRenderer();
        gridLabel8.setHorizontalAxisTitle("Time");
        gridLabel8.setHorizontalAxisTitleTextSize(30);
        gridLabel8.setVerticalAxisTitle("Temperature (Celsius)");
        gridLabel8.setVerticalAxisTitleTextSize(30);

        graph5 = (GraphView) view.findViewById(R.id.graphhumidity2);
        graphDatabaseHelper = new GraphDatabaseHelper(context);
        sqLiteDatabase = graphDatabaseHelper.getWritableDatabase();
        series5.resetData(getDataPoint5());
        graph5.addSeries(series5);
        series5.setTitle("Humidity");
        graph5.getViewport().setXAxisBoundsManual(true);
        graph5.getViewport().setYAxisBoundsManual(true);
        graph5.getViewport().scrollToEnd();
        graph5.getViewport().setScalable(true);
        graph5.getViewport().setScalableY(true);
        series5.setThickness(8);
        graph5.getLegendRenderer().setVisible(true);
        graph5.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
        graph5.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
            public String formatLabel(double value, boolean x){
                if (x)
                {
                    return sdf.format(new Date((long)value));
                }else{
                    return super.formatLabel(value, x);
                }
            }
        });
        GridLabelRenderer gridLabel9 = graph5.getGridLabelRenderer();
        gridLabel9.setHorizontalAxisTitle("Time");
        gridLabel9.setHorizontalAxisTitleTextSize(30);
        gridLabel9.setVerticalAxisTitle("Humidity (%)");
        gridLabel9.setVerticalAxisTitleTextSize(30);
    }
    private DataPoint[] getDataPoint4(){
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
    private DataPoint[] getDataPoint6(){
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
    private DataPoint[] getDataPoint5(){
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
    private DataPoint[] getDataPoint16() {
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
    private DataPoint[] getDataPoint17() {
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
    private DataPoint[] getDataPoint18() {
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
    private DataPoint[] getDataPoint19() {
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
    private DataPoint[] getDataPoint20() {
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

    private DataPoint[] getDataPoint21() {
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
}
