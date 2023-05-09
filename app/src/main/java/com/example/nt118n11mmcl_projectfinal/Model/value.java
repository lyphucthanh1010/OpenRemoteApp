package com.example.nt118n11mmcl_projectfinal.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class value {
    public Float[] getCoordinate() {
        return coordinates;
    }
    public void setCoordinate(Float[] coordinate) {
        this.coordinates = coordinate;
    }
    @SerializedName("coordinates")
    @Expose
    public Float[] coordinates;

    public Object getMain() {
        return main;
    }

    public void setMain(Object main) {
        this.main = main;
    }

    @SerializedName("main")
    @Expose
    public Object main;
}
