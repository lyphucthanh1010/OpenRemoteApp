package com.example.nt118n11mmcl_projectfinal.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Post {
    @SerializedName("access_token")
    @Expose
    public static String access_token;

    public static String getAccess_token() {
        access_token ="121";
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }



}
