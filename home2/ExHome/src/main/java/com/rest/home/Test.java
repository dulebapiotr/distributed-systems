package com.rest.home;

import java.text.ParseException;

public class Test {
    public static void main(String[] args) throws ParseException {
        AirQualityClient test = new AirQualityClient();
        System.out.println(test.getCityInfo("Cracow").toString());

        WeatherClient test1 = new WeatherClient();
        System.out.println(test1.getCityWeatherInfo("Kraków"));

        FunFactClient test2 = new FunFactClient();
        System.out.println(test2.getFunFact("XDEFDEvfdevg"));

    }


}