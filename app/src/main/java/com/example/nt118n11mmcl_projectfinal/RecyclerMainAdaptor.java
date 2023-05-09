package com.example.nt118n11mmcl_projectfinal;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;

import com.example.nt118n11mmcl_projectfinal.Model.UserCurrent;
import com.example.nt118n11mmcl_projectfinal.Model.attributes;
import com.example.nt118n11mmcl_projectfinal.Model.humidity;
import com.example.nt118n11mmcl_projectfinal.Model.temperature;
import com.example.nt118n11mmcl_projectfinal.Model.windSpeed;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecyclerMainAdaptor extends PagerAdapter {
    APIInterface apiInterface;
    private LayoutInflater layoutInflater;
    private Context context;
    public List<UserCurrent> listAsset = new ArrayList<>();
    public RecyclerMainAdaptor(List<UserCurrent> listAsset, Context context) {
        this.context = context;
        this.listAsset = listAsset;;

    }

    @Override
    public int getCount() {
            return listAsset.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = layoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.recyclerview_item_1, container, false);
        ImageView imageView;
        APIInterface apiInterface;
        apiInterface = APIClient.getClient().create(APIInterface.class);
        UserCurrent us = listAsset.get(position);
        TextView textView4, textView1, textView2 , textView3;
        textView1=view.findViewById(R.id.tvWeatherName);

        for(int  i= 0; i < listAsset.size(); i++)
        {
            if(listAsset.get(i).getName().contains("Weather Asset")) {
                textView1.setText(us.getName());

            }
        }
        container.addView(view, 0);
        return view;
    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
