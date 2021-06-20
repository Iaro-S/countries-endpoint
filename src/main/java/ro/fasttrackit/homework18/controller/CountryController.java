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

    @GetMapping()
    public List<Countries> getAllCountries() {
        return countryService.getAllCountries();
    }

    @GetMapping("names")
    public List<String> getAllCountriesNames() {
        return countryService.getAllCountriesNames();
    }

    @GetMapping("/{countryId}/capital")
    public Optional<String> getCapitalForCountry(@PathVariable int countryId) {
        return countryService.getCapitalForCountry(countryId);
    }

    @GetMapping("{countryId}/population")
    public Optional<Long> getPopulationForCountry(@PathVariable int countryId) {
        return countryService.getPopulationForCountry(countryId);
    }

    @GetMapping("/{continent}/countries")
    public List<Countries> getContinentCountries(@PathVariable String continent) {
        return countryService.getContinentCountries(continent);
    }

    @GetMapping("{countryId}/neighbours")
    public List<List<String>> getCountryNeighbours(@PathVariable int countryId) {
        return countryService.getCountryNeighbours(countryId);
    }

    @GetMapping("/continents/{continent}/countries")
    public List<Countries> getCountryLargerPopulation(@PathVariable String continent,
                                                      @RequestParam Long minPopulation) {
        return countryService.getCountryLargerPopulation(continent, minPopulation);
    }

    @GetMapping("/country")
    public List<Countries> getCountryNeighbours(@RequestParam String includeNeighbour,
                                                @RequestParam String excludeNeighbour) {
        return countryService.getCountryNeighbours(includeNeighbour, excludeNeighbour);
    }

    @GetMapping("/population/{country}")
    public Map<String, Long> mapCountryToPopulation(@PathVariable String country) {
        return countryService.mapCountryToPopulation(country);
    }

    @GetMapping("/continent/countries")
    public Map<String, List<Countries>> mapContinentToCountries() {
        return countryService.mapContinentToCountries();
    }
}
