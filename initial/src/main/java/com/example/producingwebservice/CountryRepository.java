package com.example.producingwebservice;

import io.spring.guides.gs_producing_web_service.Country;
import io.spring.guides.gs_producing_web_service.Currency;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

@Component
public class CountryRepository {

    private final Map<String, Country> countriesMap;

    public CountryRepository() {
        this.countriesMap = new HashMap<>();
    }

    @PostConstruct
    public void initData() {
        Country spain = new Country();

        spain.setName("Spain");
        spain.setCapital("Madrid");
        spain.setCurrency(Currency.EUR);
        spain.setPopulation(46704314);

        countriesMap.put(spain.getName(), spain);

        Country poland = new Country();
        poland.setName("Poland");
        poland.setCapital("Warsaw");
        poland.setCurrency(Currency.PLN);
        poland.setPopulation(38186860);

        countriesMap.put(poland.getName(), poland);

        Country uk = new Country();
        uk.setName("United Kingdom");
        uk.setCapital("London");
        uk.setCurrency(Currency.GBP);
        uk.setPopulation(63705000);

        countriesMap.put(uk.getName(), uk);

    }

    public Country findCountryByName(String countryName) {
        Assert.notNull(countryName, "The country's name must not be null");
        return countriesMap.get(countryName);
    }
}
