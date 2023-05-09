package com.example.nt118n11mmcl_projectfinal;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nt118n11mmcl_projectfinal.Model.UserCurrent;
import com.example.nt118n11mmcl_projectfinal.MyInterface.IClickItemListener;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityListAsset extends AppCompatActivity {
    APIInterface apiInterface;
    RecyclerView recyclerview;
    private SearchView searchView;
    private Context context;
    AssetListAdaptor assetListAdaptor;
    private List<UserCurrent> ListAsset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assetlist);
        recyclerview = (RecyclerView) findViewById(R.id.RV);
        apiInterface = APIClient.getClient().create(APIInterface.class);
//        recyclerview.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        assetListAdaptor = new AssetListAdaptor(ListAsset, new IClickItemListener() {
            @Override
            public void onClickItemUser(UserCurrent userCurrent) {
                onClickGoToDetail(userCurrent);
            }
        });
        recyclerview.setAdapter(assetListAdaptor);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) findViewById(R.id.list2);
        searchView.clearFocus();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);
        ListAsset = new ArrayList<>();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                assetListAdaptor.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                assetListAdaptor.getFilter().filter(newText);
                return false;
            }
        });
        getdata();
        ImageView img = findViewById(R.id.backpic);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                ActivityListAsset.super.onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(!searchView.isIconified()){
            searchView.setIconified(true);
            return;
        }
        super.onBackPressed();
    }
    private void getdata(){
        //List<UserCurrent> ListAsset = new ArrayList<>();
        Call<List<UserCurrent>> call = apiInterface.getUsCurrent();
        call.enqueue(new Callback<List<UserCurrent>>() {
            @Override
            public void onResponse(Call<List<UserCurrent>> call, Response<List<UserCurrent>> response) {
                ListAsset = response.body();
                assetListAdaptor = new AssetListAdaptor(ListAsset, new IClickItemListener() {
                    @Override
                    public void onClickItemUser(UserCurrent userCurrent) {
                        if(userCurrent.getType().contains("ThingAsset"))
                        {
                            onClickGoToDetail(userCurrent);
                        }
                        else if(userCurrent.getType().contains("MQTTAgent"))
                        {
                            onClickGoToDetail2(userCurrent);
                        }
                        else if(userCurrent.getType().contains("SimulatorAgent"))
                        {
                            onClickGoToDetail3(userCurrent);
                        }
                        else if(userCurrent.getType().contains("ConsoleAsset"))
                        {
                            onClickGoToDetail4(userCurrent);
                        }
                        else if(userCurrent.getType().contains("GroupAsset"))
                        {
                            onClickGoToDetail5(userCurrent);
                        }
                        else if(userCurrent.getType().contains("HTTPAgent"))
                        {
                            onClickGotoDetail6(userCurrent);
                        }
                        else if(userCurrent.getType().contains("WeatherAsset"))
                        {
                            if(userCurrent.getName().equals("Weather Asset"))
                            {
                                startActivity(new Intent(ActivityListAsset.this, ActivityWeatherData.class));
                            }
                            else if (userCurrent.getName().equals("Weather Asset 2"))
                            {
                                startActivity(new Intent(ActivityListAsset.this, ActivityWeatherData2.class));
                            }
                            else
                            {
                                startActivity(new Intent(ActivityListAsset.this, ActivityWeatherData3.class));
                            }
                        }
                    }
                });
                recyclerview.setAdapter(assetListAdaptor);

            }
            @Override
            public void onFailure(Call<List<UserCurrent>> call, Throwable t) {

            }
        });
    }

    private void onClickGotoDetail6(UserCurrent userCurrent) {
        try {
            Intent intent = new Intent(this, DetailHTTPActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("Asset", userCurrent);
            intent.putExtras(bundle);
            startActivity(intent);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private void onClickGoToDetail5(UserCurrent userCurrent) {
        try {
            Intent intent = new Intent(this, DetailGroupActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("Asset", userCurrent);
            intent.putExtras(bundle);
            startActivity(intent);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private void onClickGoToDetail4(UserCurrent userCurrent) {
        try {
            Intent intent = new Intent(this, DetailConsoleActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("Asset", userCurrent);
            intent.putExtras(bundle);
            startActivity(intent);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    private void onClickGoToDetail3(UserCurrent userCurrent) {
        try {
            Intent intent = new Intent(this, DetailSimuActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("Asset", userCurrent);
            intent.putExtras(bundle);
            startActivity(intent);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    private void onClickGoToDetail(UserCurrent userCurrent) {
        try {
            Intent intent = new Intent(this, DetailThingActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("Asset", userCurrent);
            intent.putExtras(bundle);
            startActivity(intent);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    private void onClickGoToDetail2(UserCurrent userCurrent) {
        try {
            Intent intent = new Intent(this, DetailMQTTActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("Asset", userCurrent);
            intent.putExtras(bundle);
            startActivity(intent);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
