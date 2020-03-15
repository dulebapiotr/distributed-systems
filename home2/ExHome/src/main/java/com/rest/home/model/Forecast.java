package com.rest.home.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Forecast {
    private String city;
    private List<Date> date = new ArrayList<>();
    private List<Double> avg_temp = new ArrayList<>();

    public Forecast(){}

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Date> getDate() {
        return date;
    }

    public void setDate(List<Date> date) {
        this.date = date;
    }

    public List<Double> getAvg_temp() {
        return avg_temp;
    }

    public void setAvg_temp(List<Double> avg_temp) {
        this.avg_temp = avg_temp;
    }

    public void addData(Date date, Double temp){
        this.date.add(date);
        this.avg_temp.add(temp);
    }

    public String toString(){
        String res="";
        for(int i=0;i<date.size();i++){
            res+="<p>"+date.get(i)+" temp: "+avg_temp.get(i)+"<p>";
        }

        return res;
    }


}
