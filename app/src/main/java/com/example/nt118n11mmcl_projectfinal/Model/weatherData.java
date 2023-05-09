package com.example.nt118n11mmcl_projectfinal.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class weatherData {
    @SerializedName("value")
    @Expose
    public Object value;

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @SerializedName("timestamp")
    @Expose
    public Long timestamp;
}
