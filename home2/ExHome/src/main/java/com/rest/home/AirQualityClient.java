package com.rest.home;
import com.rest.home.model.AirQuality;
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


public class AirQualityClient {
    private String key = "6bbd99175a16de2b333b7d48294e088ed53b2412";

    public AirQualityClient(){}

    public AirQuality getCityInfo(String city) throws ParseException {
        String jsonInfo = getJson(city);
        return parseJson(jsonInfo, city);
    }

    private String getJson(String city){
        Client client = ClientBuilder.newClient();
        URI baseURI = UriBuilder.fromUri("https://api.waqi.info/feed/"+city+"/?token="+key).build();
        WebTarget target = client.target(baseURI);
        return target.request().accept(MediaType.APPLICATION_JSON).get(String.class);
    }

    public AirQuality parseJson(String json, String city) throws ParseException {

        JSONObject obj = new JSONObject(json);
        int pm10 = obj
                .getJSONObject("data")
                .getJSONObject("iaqi")
                .getJSONObject("pm10")
                .getInt("v");
        int pm25 = obj
                .getJSONObject("data")
                .getJSONObject("iaqi")
                .getJSONObject("pm25")
                .getInt("v");
        int co = obj
                .getJSONObject("data")
                .getJSONObject("iaqi")
                .getJSONObject("co")
                .getInt("v");
        String date = obj
                .getJSONObject("data")
                .getJSONObject("time")
                .getString("s");

        Date date1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date);
        AirQuality result = new AirQuality();
        result.setCity(city);
        result.setPm10(pm10);
        result.setPm25(pm25);
        result.setC0(co);
        result.setDate(date1);
        return result;
    }



}
