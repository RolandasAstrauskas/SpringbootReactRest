package com.example.demo.Service;

import com.example.demo.Domain.Country;

import java.util.List;

public interface CountryService {

    List<Country> findByCountryName(String country);

    List<String> findCountryNameList();
}
