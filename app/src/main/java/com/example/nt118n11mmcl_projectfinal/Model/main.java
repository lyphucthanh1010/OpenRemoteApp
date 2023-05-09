package com.example.nt118n11mmcl_projectfinal.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class main {

    @SerializedName("pressure")
    @Expose
    public Long pressure;
    @SerializedName("temp_max")
    @Expose
    public Double temp_max;
    @SerializedName("temp_min")
    @Expose
    public Double temp_min;

    public Long getPressure() {
        return pressure;
    }

    public void setPressure(Long pressure) {
        this.pressure = pressure;
    }

    public Double getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(Double temp_max) {
        this.temp_max = temp_max;
    }

    public Double getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(Double temp_min) {
        this.temp_min = temp_min;
    }

    public Long getSea_level() {
        return sea_level;
    }

    public void setSea_level(Long sea_level) {
        this.sea_level = sea_level;
    }

    public Long getGrnd_level() {
        return grnd_level;
    }

    public void setGrnd_level(Long grnd_level) {
        this.grnd_level = grnd_level;
    }

    @SerializedName("sea_level")
    //Atmospheric pressure on the sea level
    @Expose
    public Long sea_level;
    @SerializedName("grnd_level")
    //Atmospheric pressure on the ground level
    @Expose
    public Long grnd_level;
}
