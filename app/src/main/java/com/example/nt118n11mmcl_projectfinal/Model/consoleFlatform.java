package com.example.nt118n11mmcl_projectfinal.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



public class consoleFlatform {
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @SerializedName("value")
    @Expose
    public String value;
}
