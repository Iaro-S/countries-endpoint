package ro.fasttrackit.homework18.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.fasttrackit.homework18.model.Countries;
import ro.fasttrackit.homework18.service.CountryService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("countries")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping()
    public List<Countries> getAllCountries() {
        return countryService.getAllCountries();
    }

    @GetMapping("names")
    public List<String> getAllCountriesNames() {
        return countryService.getAllCountriesNames();
    }

    @GetMapping("{countryId}/capital")
    public String getCapitalForCountry(@PathVariable int countryId) {
        return countryService.getCapitalForCountry(countryId).orElse("Id not found, try another one.");
    }

    @GetMapping("{countryId}/population")
    public Optional<Long> getPopulationForCountry(@PathVariable int countryId) {
        return countryService.getPopulationForCountry(countryId);
    }

    @GetMapping("{continent}/countries")
    public List<Countries> getContinentCountries(@PathVariable String continent) {
        return countryService.getContinentCountries(continent);
    }

    @GetMapping("{countryId}/neighbours")
    public List<List<String>> getCountryNeighbours(@PathVariable int countryId) {
        return countryService.getCountryNeighbours(countryId);
    }
}
