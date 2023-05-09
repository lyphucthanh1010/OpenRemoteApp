package com.example.nt118n11mmcl_projectfinal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.List;

public class DataGraphAdapter extends BaseAdapter {
    private List<DataGraph> DataGraphList;
    public DataGraphAdapter(List<DataGraph> contactList) {
        this.DataGraphList = contactList;
    }
    public void updateData() {
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return this.DataGraphList.size();
    }
    @Override
    public Object getItem(int position) {
        return null;
    }
    Calendar calendar = Calendar.getInstance();
    String CurrentDate = DateFormat.getDateInstance().format(calendar.getTime());
    @Override
    public long getItemId(int position) {
        return 0;
    }
        private class ViewHolder {
            private TextView tvContact, tvContact2, tvContact3, tvContact4, tvContact5, tvContact6, tvContact7,tvContact8, tvContact17, tvContact9, tvContact10, tvContact11, tvContact12, tvContact13, tvContact16, tvContact14, tvContact15;
        }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tvContact = (TextView) convertView.findViewById(R.id.tvnumber2);
            viewHolder.tvContact2 = (TextView) convertView.findViewById(R.id.tvname);
            viewHolder.tvContact3 = (TextView) convertView.findViewById(R.id.tvtype);
            viewHolder.tvContact4 = (TextView) convertView.findViewById(R.id.tvtem);
            viewHolder.tvContact5 = (TextView) convertView.findViewById(R.id.tvtemtime);
            viewHolder.tvContact6 = (TextView) convertView.findViewById(R.id.tvhumi);
            viewHolder.tvContact7 = (TextView) convertView.findViewById(R.id.tvhumitime);
            viewHolder.tvContact8 = (TextView) convertView.findViewById(R.id.tvwinds);
            viewHolder.tvContact9 = (TextView) convertView.findViewById(R.id.tvwindstime);
            viewHolder.tvContact10 = (TextView) convertView.findViewById(R.id.tvmax);
            viewHolder.tvContact11 = (TextView) convertView.findViewById(R.id.tvmin);
            viewHolder.tvContact12 = (TextView) convertView.findViewById(R.id.tvsea);
            viewHolder.tvContact13 = (TextView) convertView.findViewById(R.id.tvground);
            viewHolder.tvContact14 = (TextView) convertView.findViewById(R.id.tvwinddi);
            viewHolder.tvContact15 = (TextView) convertView.findViewById(R.id.tvwindditime);
            viewHolder.tvContact16 = (TextView) convertView.findViewById(R.id.tvpressure);
            viewHolder.tvContact17 = (TextView) convertView.findViewById(R.id.tvtime2);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        DataGraph dataGraph = this.DataGraphList.get(position);
        viewHolder.tvContact.setText(""+dataGraph.getIddtb());
        viewHolder.tvContact2.setText("Name: " +dataGraph.getName());
        viewHolder.tvContact3.setText("Asset ID: "+ dataGraph.getId());
        viewHolder.tvContact4.setText("Temperature: "+ dataGraph.getTemper());
        viewHolder.tvContact5.setText( "Temperature's Timestamp: "+ dataGraph.getTimetemper());
        viewHolder.tvContact6.setText("\n Humidity: "+ dataGraph.getHumid());
        viewHolder.tvContact7.setText("Humidity's Timestamp: "+ dataGraph.getTimehumid());
        viewHolder.tvContact8.setText("\n Windspeed: "+dataGraph.getWindspeed());
        viewHolder.tvContact9.setText("Windspeed's Timestamp: "+dataGraph.getTimewindspeed().longValue());
        viewHolder.tvContact10.setText("\n Max temperature: "+ dataGraph.getTemp_max());
        viewHolder.tvContact11.setText("\n Min temperature: " + dataGraph.getTemp_min());
        viewHolder.tvContact12.setText("\n Sea level: " + dataGraph.getSea_level());
        viewHolder.tvContact13.setText("\n Ground level: "+ dataGraph.getGrnd_level());
        viewHolder.tvContact14.setText("\n Wind Direction: " + dataGraph.getWinddirection());
        viewHolder.tvContact15.setText("Wind Direction's Timestamp: " + dataGraph.getWindditime());
        viewHolder.tvContact16.setText("\n Pressure: " + dataGraph.getPressure());
        viewHolder.tvContact17.setText("Another Timestamp: " + dataGraph.getTime2());
        //viewHolder.tvContact.setText(dataGraph.getId()+ dataGraph.getName());
        return convertView;
    }
}
