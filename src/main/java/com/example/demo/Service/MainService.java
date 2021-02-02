package com.example.demo.Service;

import com.example.demo.Domain.Country;
import com.example.demo.Repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MainService implements CountryService{

    @Autowired
    private CountryRepository countryRepository;


    @Override
    public List<Country> findByCountryName(String countryName) {
        return countryRepository.findByCountry(countryName);
    }

    @Override
    public List<String> findCountryNameList() {
        List<String> countryNameList = new ArrayList<>();
        List<Country> countryList = countryRepository.findAll();

        for(int  i = 1; i < countryList.size(); i++){
            Country country = countryList.get(i-1);
            Country countryNext = countryList.get(i);
            if(!country.getCountry().equals(countryNext.getCountry())){
                countryNameList.add(country.getCountry());
            }
        }
        return countryNameList;
    }
}
