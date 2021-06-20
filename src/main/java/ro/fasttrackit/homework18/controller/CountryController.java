package ro.fasttrackit.homework18.controller;

import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.homework18.model.Countries;
import ro.fasttrackit.homework18.service.CountryService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("countries")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    //localhost:8080/countries/countries/
    @GetMapping("countries")
    public List<Countries> getAllCountries() {
        return countryService.getAllCountries();
    }

    //localhost:8080/countries/names
    @GetMapping("names")
    public List<String> getAllCountriesNames() {
        return countryService.getAllCountriesNames();
    }

    //localhost:8080//countries/174/capital
    @GetMapping("/{countryId}/capital")
    public Optional<String> getCapitalForCountry(@PathVariable int countryId) {
        return countryService.getCapitalForCountry(countryId);
    }

    //localhost:8080//countries/174/population
    @GetMapping("{countryId}/population")
    public Optional<Long> getPopulationForCountry(@PathVariable int countryId) {
        return countryService.getPopulationForCountry(countryId);
    }

    //localhost:8080/countries/africa/countries
    @GetMapping("/{continent}/countries")
    public List<Countries> getContinentCountries(@PathVariable String continent) {
        return countryService.getContinentCountries(continent);
    }

    //localhost:8080//countries/174/neighbours
    @GetMapping("{countryId}/neighbours")
    public Optional<List<String>> getCountryNeighbours(@PathVariable int countryId) {
        return countryService.getCountryNeighbours(countryId);
    }

    //localhost:8080/countries/continents/asia/countries?minPopulation=50000000
    @GetMapping("/continents/{continent}/countries")
    public List<Countries> getCountryLargerPopulation(@PathVariable String continent,
                                                      @RequestParam Long minPopulation) {
        return countryService.getCountryLargerPopulation(continent, minPopulation);
    }

    //localhost:8080/countries/country?includeNeighbour=fra&excludeNeighbour=esp
    @GetMapping("/country")
    public List<Countries> getCountryNeighbours(@RequestParam String includeNeighbour,
                                                @RequestParam String excludeNeighbour) {
        return countryService.getCountryNeighbours(includeNeighbour, excludeNeighbour);
    }

    //localhost:8080/countries/population
    @GetMapping("/population")
    public Map<String, Long> mapCountryToPopulation() {
        return countryService.mapCountryToPopulation();
    }

    //localhost:8080/countries/continent/countries
    @GetMapping("/continent/countries")
    public Map<String, List<Countries>> mapContinentToCountries() {
        return countryService.mapContinentToCountries();
    }
}
