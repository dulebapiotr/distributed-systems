package com.rest.home;

import com.rest.home.model.AirQuality;
import com.rest.home.model.Forecast;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WeatherClient {
    private String key = "ee66eccbf58b16cd4d4a50a826bc3fa7";

    public WeatherClient(){}

    public Forecast getCityWeatherInfo(String city) throws ParseException {
        String jsonInfo = getJson(city);
        return parseJson(jsonInfo, city);
    }

    private String getJson(String city){
        Client client = ClientBuilder.newClient();
        URI baseURI = UriBuilder.fromUri("http://api.openweathermap.org/data/2.5/forecast?q="+city+"&appid="+key).build();
        WebTarget target = client.target(baseURI);
        return target.request().accept(MediaType.APPLICATION_JSON).get(String.class);
    }

    private Forecast parseJson(String json, String city) throws ParseException {
        Forecast result = new Forecast();
        result.setCity(city);

        JSONObject obj = new JSONObject(json);
        int cnt = obj
                .getInt("cnt");

        JSONArray arr = obj.getJSONArray("list");
        for(int i=0; i<arr.length();i++){
            JSONObject tmp_obj = (JSONObject)arr.get(i);
            int temp = tmp_obj.getJSONObject("main").getInt("temp");
            String date = tmp_obj.getString("dt_txt");
            Date date1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date);
            result.addData(date1,temp-272.00);
        }
        return result;
    }



}
