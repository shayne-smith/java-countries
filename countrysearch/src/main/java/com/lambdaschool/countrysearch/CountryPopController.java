package com.lambdaschool.countrysearch;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value={"/population"})
public class CountryPopController
{
    // http://localhost:2019/population/size/1000000000
    @GetMapping(value = "/size/{people}",
    produces = {"application/json"})
    public ResponseEntity<?> getCountriesByPopulation(@PathVariable int people) {
        List<Country> rtnCos = CountrySearchApplication.ourCountryList.findCountries(c -> (int)c.getPopulation() >= 1000000000);
        return new ResponseEntity<>(rtnCos, HttpStatus.OK);
    }

    // http://localhost:2019/population/min
    @GetMapping(value = "/min",
    produces = {"application/json"})
    public ResponseEntity<?> getSmallestCountry() {
        Country rtnCo = CountrySearchApplication.ourCountryList.findSmallestCountry();
        return new ResponseEntity<>(rtnCo, HttpStatus.OK);
    }

    // http://localhost:2019/population/max
    @GetMapping(value = "/max",
        produces = {"application/json"})
    public ResponseEntity<?> getLargestCountry() {
        Country rtnCo = CountrySearchApplication.ourCountryList.findLargestCountry();
        return new ResponseEntity<>(rtnCo, HttpStatus.OK);
    }
}
