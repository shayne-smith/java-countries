package com.lambdaschool.countrysearch;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    // http://localhost:2019/names/start/{letter}
    @GetMapping(value = "/start/{letter}",
    produces = {"application/json"})
    public ResponseEntity<?> getCountriesByLetter(@PathVariable char letter) {
        List<Country> rtnCos = CountrySearchApplication.ourCountryList.findCountries(c -> c.getName().toUpperCase().charAt(0)==Character.toUpperCase(letter));
        rtnCos.sort((c1, c2) -> (c1.getName().compareToIgnoreCase(c2.getName())));
        return new ResponseEntity<>(rtnCos, HttpStatus.OK);
    }

    // http://localhost:2019/names/size/20
    @GetMapping(value = "/size/{length}",
    produces = {"application/json"})
    public ResponseEntity<?> getCountriesByNameLength(@PathVariable int length) {
        List<Country> rtnCos = CountrySearchApplication.ourCountryList.findCountries(c -> c.getName().length()>=20);
        rtnCos.sort((c1, c2) -> (c1.getName().compareToIgnoreCase((c2.getName()))));
        return new ResponseEntity<>(rtnCos, HttpStatus.OK);
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

