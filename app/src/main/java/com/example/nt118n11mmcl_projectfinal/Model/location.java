package com.example.nt118n11mmcl_projectfinal.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class location {
    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @SerializedName("value")
    @Expose
    public Object value;
}
