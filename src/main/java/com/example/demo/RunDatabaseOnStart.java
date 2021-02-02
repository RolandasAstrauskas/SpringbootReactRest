package com.example.demo;

import com.example.demo.Domain.Country;
import com.example.demo.Repository.CountryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class RunDatabaseOnStart implements  CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(RunDatabaseOnStart.class);
    private final static String URL = "https://opendata.ecdc.europa.eu/covid19/nationalcasedeath/json/";


    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void run(String... args) throws Exception {

        Country[] countries = restTemplate.getForObject(URL, Country[].class);

        System.out.println("Data retrieved");

        List<Country> countryList = Arrays.asList(countries);

        for (int i = 0; i < countryList.size(); i++) {
            Country country = countryList.get(i);

            for (int k = i + 1; k < countryList.size(); k++) {
                Country country1 = countryList.get(k);
                if (country.getCountry().equals(country1.getCountry()) & country.getYear_week().equals(country1.getYear_week()) &
                        country.getIndicator().equals("cases")) {

                    Country country2 = new Country();
                    country2.setCountry(country.getCountry());
                    country2.setYear_week(country.getYear_week());
                    country2.setIndicatorCase(country1.getWeekly_count());
                    country2.setIndicatorDeath(country.getWeekly_count());
                    countryRepository.save(country2);
                }
            }
            System.out.println("Database loading.." + i);
        }
        System.out.println("!--------Covid-19 database loaded----------!");
    }

}



