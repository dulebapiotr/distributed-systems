package com.rest.home;

import com.rest.home.model.AirQuality;
import com.rest.home.model.Forecast;
import org.json.JSONObject;
import javax.print.attribute.standard.Media;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.awt.*;
import java.io.IOException;
import java.text.ParseException;

@Path("/cityInfo")
public class CityREST {

    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    FunFactClient fc = new FunFactClient();
    WeatherClient wc = new WeatherClient();
    AirQualityClient aqc = new AirQualityClient();

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces({MediaType.TEXT_HTML})
    public String getCity(@FormParam("city") String city) throws IOException, ParseException {


        String fact = fc.getFunFact(city);
        AirQuality aq = aqc.getCityInfo(city);
        Forecast fc = wc.getCityWeatherInfo(city);


        return "<html> " +
                    "<title>" + "Facts about "+city + "</title>"+
                "<body>" +
                    "<section>"+
                        "<h1>"+"Name '"+ city + "' has "+city.length()+" letters!"+"</h1>"+
                        "<p>"+fact+"<p>"+
                    "</section>"+

                     "<section>"+
                        "<h1>"+"Air condition in "+ city + ":"+"</h1>"+
                        "<p>"+"Measurement date: "+aq.getDate()+"<p>"+
                        "<p>"+"pm10[ug/m^3]: "+aq.getPm10()+"<p>"+
                        "<p>"+"pm2.5[ug/m^3]: "+aq.getPm25()+"<p>"+
                        "<p>"+"CO[ug/m^3]: "+aq.getC0()+"<p>"+
                    "</section>"+


                "<section>"+
                    "<h1>"+"Weather forecast for "+ city + " for next 5 days:"+"</h1>"+
                    "<p>"+fc.toString()+"<p>"+
                "</section>"+


                "</body>" +
                "</html> ";


    }
}
