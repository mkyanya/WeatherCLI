package org.example;
import org.example.models.LatLon;
import org.example.models.Weather;
import org.example.models.WeatherObject;
import org.example.services.WeatherService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        WeatherService service = new WeatherService();

        System.out.println("Welcome to my Weather App!");

        System.out.println("Enter your zip code: ");
        String zip = input.nextLine();

        LatLon response = service.getLatLon(zip);
//        System.out.println(response);

        WeatherObject weatherResponse = service.getWeather(response);
        System.out.println("Current weather in " + response.getName());
        System.out.println("Current Temp: " +weatherResponse.getMain().getTemp());
        System.out.println("Feels like: " + weatherResponse.getMain().getFeelsLike());
        System.out.println("Humidity: " + weatherResponse.getMain().getHumidity());

        Weather[] weatherArr = weatherResponse.getWeather();
        System.out.println("Today's weather is: " + weatherArr[0].getDescription());



    }
}