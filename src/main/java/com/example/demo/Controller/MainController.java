package com.example.demo.Controller;


import com.example.demo.Domain.Country;
import com.example.demo.Service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class MainController {

    @Autowired
    private MainService mainService;


    @GetMapping("/all/{country}")
    public List<Country> findByName(@PathParam("country") String country){
        return mainService.findByCountryName(country);
    }

    @GetMapping("/allCountry")
    public List<String> findCountryName(){
        return mainService.findCountryNameList();
    }

}
