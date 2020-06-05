package com.lambdaschool.countrysearch;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value={"/age"})
public class CountryAgeController
{
    // http://localhost:2019/age/age/{25}
    @GetMapping(value = "/age/{age}",
    produces = {"application/json"})
    public ResponseEntity<?> getMedianAge(@PathVariable int age) {
        List<Country> rtnCos = CountrySearchApplication.ourCountryList.findCountries(c -> (int) c.getMedianAge() >= age);
        return new ResponseEntity<>(rtnCos, HttpStatus.OK);
    }

    // http://localhost:2019/age/min
    @GetMapping(value = "/min",
    produces = {"application/json"})
    public ResponseEntity<?> getYoungest() {
        Country rtnCo = CountrySearchApplication.ourCountryList.findYoungest();
        return new ResponseEntity<>(rtnCo, HttpStatus.OK);
    }

    // http://localhost:2019/age/max
    @GetMapping(value = "/max",
    produces = {"application/json"})
    public ResponseEntity<?> getOldest() {
        Country rtnCo = CountrySearchApplication.ourCountryList.findOldest();
        return new ResponseEntity<>(rtnCo, HttpStatus.OK);
    }
}
