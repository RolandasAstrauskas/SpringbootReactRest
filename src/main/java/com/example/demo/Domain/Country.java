package com.example.demo.Domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
@JsonIgnoreProperties
public class Country {

    @Id
    @GeneratedValue
    private int index;

    private String country;
    private String indicator;
    private int indicatorCase;
    private int indicatorDeath;
    private int weekly_count;
    private String year_week;

    public Country() {
    }

    public Country(int index, String country, String indicator, int indicatorCase, int indicatorDeath, String year_week) {
        this.index = index;
        this.country = country;
        this.indicator = indicator;
        this.indicatorCase = indicatorCase;
        this.indicatorDeath = indicatorDeath;
        this.year_week = year_week;
    }

    public int getIndex() {
        return index;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIndicator() {
        return indicator;
    }

    public void setIndicator(String indicator) {
        this.indicator = indicator;
    }

    public int getWeekly_count() {
        return weekly_count;
    }

    public void setWeekly_count(int weekly_count) {
        this.weekly_count = weekly_count;
    }

    public int getIndicatorCase() {
        return indicatorCase;
    }

    public void setIndicatorCase(int indicatorCase) {
        this.indicatorCase = indicatorCase;
    }

    public int getIndicatorDeath() {
        return indicatorDeath;
    }

    public void setIndicatorDeath(int indicatorDeath) {
        this.indicatorDeath = indicatorDeath;
    }

    public String getYear_week() {
        return year_week;
    }

    public void setYear_week(String year_week) {
        this.year_week = year_week;
    }
}
