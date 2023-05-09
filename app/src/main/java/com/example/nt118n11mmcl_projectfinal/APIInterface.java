package com.example.nt118n11mmcl_projectfinal;
import com.example.nt118n11mmcl_projectfinal.Model.Asset;
import com.example.nt118n11mmcl_projectfinal.Model.Map;
import com.example.nt118n11mmcl_projectfinal.Model.Post;
import com.example.nt118n11mmcl_projectfinal.Model.UserCurrent;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIInterface {
    @GET("api/master/asset/user/current")
    Call<List<UserCurrent>> getUsCurrent();
    @GET("api/master/asset/user/current")
    Call<List<UserCurrent>> getUsCurrent1(@Query("id") String id, @Query("id") String id2, @Query("id") String id3);
    @GET("api/master/asset/{assetID}")
    Call<Asset> getAsset(@Path("assetID") String assetID);
    @GET("api/master/map")
    Call<Map> getMap();
    @GET("auth/realms/master/protocol/openid-connect/token")
    Call<Post> postPost();
}
