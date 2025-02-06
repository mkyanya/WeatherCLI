package org.example.services;

import org.example.models.LatLon;
import org.example.models.WeatherObject;
import org.springframework.web.client.RestTemplate;

public class WeatherService {
    private RestTemplate template = new RestTemplate();

    private final String API_URL= "http://api.openweathermap.org";

    private final String API_KEY = "3faaa78508fe131303a47fa1f58e218b";

    public LatLon getLatLon(String zipcode ){
        String url = API_URL + "/geo/1.0/zip?zip=" + zipcode + "&appid=" + API_KEY;

         LatLon response;
        response = template.getForObject(url, LatLon.class);
        return response;

    }

    public WeatherObject getWeather (LatLon latLon){
        String url = " https://api.openweathermap.org" +
                "/data/2.5/weather?lat=" + latLon.getLat() +
                "&lon= " + latLon.getLon() +
                "&appid= " + API_KEY + "&units=imperial";


        WeatherObject response =
                template.getForObject(url, WeatherObject.class);
        return response;


    }




}
