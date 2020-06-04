package com.lambdaschool.countrysearch;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value={"/names"})
public class CountryNamesController {

    // http://localhost:2019/names/all
    @GetMapping(value = "/all",
    produces = {"application/json"})
    public ResponseEntity<?> getAllCountries() {
        CountrySearchApplication.ourCountryList.countryList.sort((c1, c2) -> (c1.getName().compareToIgnoreCase(c2.getName())));
        return new ResponseEntity<>(CountrySearchApplication.ourCountryList.countryList,
            HttpStatus.OK);
    }
}

    /* The following URLs should return the requested data given the parameters

 /names/all - return the names of all the countries alphabetically

 /names/start/{letter} - return the countries alphabetically that begin with the given letter

 /names/size/{number} - return the countries alphabetically that have a name equal to or longer than the given length

 /population/size/{people} - return the countries that have a population equal to or greater than the given population

 /population/min - return the country with the smallest population

 /population/max - return the country with the largest population

 /age/age/{age} - return the countries that have a median age equal to or greater than the given age

 /age/min - return the country with the smallest median age

 /age/max - return the country the the greatest median age */

