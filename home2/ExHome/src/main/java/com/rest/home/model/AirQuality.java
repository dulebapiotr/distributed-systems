package com.rest.home.model;

import java.util.Date;

public class AirQuality {

    private String city;
    private Date date;
    private int pm10;
    private int pm25;
    private int co;

    public AirQuality(){}

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPm10() {
        return pm10;
    }

    public void setPm10(int pm10) {
        this.pm10 = pm10;
    }

    public int getPm25() {
        return pm25;
    }

    public void setPm25(int pm25) {
        this.pm25 = pm25;
    }

    public int getC0() {
        return co;
    }

    public void setC0(int co) {
        this.co = co;
    }

    public String toString(){
        String res = "";
        res+=("Air for "+this.city+"\n");
        res+=( "Measure time:"+this.date+"\n");
        res+=("pm10:  "+this.pm10+"\n");
        res+=("pm2.5: "+this.pm25+"\n");
        res+=("co: "+this.co+"\n");

        return res;
    }
}
