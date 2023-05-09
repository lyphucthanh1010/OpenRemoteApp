package com.example.nt118n11mmcl_projectfinal;

import java.util.LongSummaryStatistics;


public class DataGraph {
    public String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIddtb() {
        return iddtb;
    }

    public void setIddtb(int iddtb) {
        this.iddtb = iddtb;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int iddtb;
    public String name;
    public Double temper;
    public Long timetemper;
    public Integer humid;

    public Double getTemper() {
        return temper;
    }

    public void setTemper(Double temper) {
        this.temper = temper;
    }

    public Long getTimetemper() {
        return timetemper;
    }

    public void setTimetemper(Long timetemper) {
        this.timetemper = timetemper;
    }

    public Integer getHumid() {
        return humid;
    }

    public void setHumid(Integer humid) {
        this.humid = humid;
    }

    public Long getTimehumid() {
        return timehumid;
    }

    public void setTimehumid(Long timehumid) {
        this.timehumid = timehumid;
    }

    public Long getTimewindspeed() {
        return timewindspeed;
    }

    public void setTimewindspeed(Long timewindspeed) {
        this.timewindspeed = timewindspeed;
    }

    public Double getWindspeed() {
        return windspeed;
    }

    public void setWindspeed(Double windspeed) {
        this.windspeed = windspeed;
    }
    public Double temp_max;

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

    public Long getTime2() {
        return time2;
    }

    public void setTime2(Long time2) {
        this.time2 = time2;
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

    public Double temp_min;
    public Long time2;
    public Long sea_level;
    public Long grnd_level;



    public Long timehumid;
    public Long timewindspeed;
    public Double windspeed;

    public Long getWinddirection() {
        return winddirection;
    }

    public void setWinddirection(Long winddirection) {
        this.winddirection = winddirection;
    }

    public Long getWindditime() {
        return windditime;
    }

    public void setWindditime(Long windditime) {
        this.windditime = windditime;
    }

    public Long getPressure() {
        return pressure;
    }

    public void setPressure(Long pressure) {
        this.pressure = pressure;
    }

    public Long winddirection;
    public Long windditime;
    public Long pressure;

    public DataGraph(){
    }
    public DataGraph(int iddtb){this.iddtb = iddtb;}
    public DataGraph(String id, String name, Double temper, Long timetemper, Integer humid, Long timehumid, Double windspeed, Long timewindspeed, Double temp_max, Double temp_min, Long sea_level, Long grnd_level, Long time2, Long winddirection, Long windditime, Long pressure, String content){
        this.id= id;
        this.name = name;
        this.temper = temper;
        this.timetemper = timetemper;
        this.humid = humid;
        this.timehumid = timehumid;
        this.windspeed = windspeed;
        this.timewindspeed = timewindspeed;
        this.temp_max = temp_max;
        this.temp_min = temp_min;
        this.sea_level = sea_level;
        this.grnd_level = grnd_level;
        this.time2= time2;
        this.winddirection = winddirection;
        this.windditime = windditime;
        this.pressure= pressure;
    }
    public DataGraph(int iddtb, String id, String name, Double temper, Long timetemper, Integer humid, Long timehumid, Double windspeed , Long timewindspeed, Double temp_max, Double temp_min, Long sea_level, Long grnd_level, Long time2, Long winddirection, Long windditime, Long pressure){
        this.iddtb = iddtb;
        this.id= id;
        this.name = name;
        this.temper = temper;
        this.timetemper = timetemper;
        this.humid = humid;
        this.timehumid = timehumid;
        this.windspeed = windspeed;
        this.timewindspeed = timewindspeed;
        this.temp_max = temp_max;
        this.temp_min = temp_min;
        this.sea_level = sea_level;
        this.grnd_level = grnd_level;
        this.time2= time2;
        this.winddirection = winddirection;
        this.windditime = windditime;
        this.pressure= pressure;
    }
}
