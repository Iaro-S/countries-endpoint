package ro.fasttrackit.homework18.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.homework18.model.Countries;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class CountryService {
    private final List<Countries> countries = new ArrayList<>();

    public CountryService(CountryReader reader) throws Exception {
        countries.addAll(reader.readCountriesFromFile());
    }

    public List<Countries> getAllCountries() {
        return countries;
    }

    public List<String> getAllCountriesNames() {
        return countries.stream()
                .map(Countries::getName)
                .collect(toList());
    }

    public Optional<String> getCapitalForCountry(int countryId) {
        return countries.stream()
                .filter(countries -> countries.getId() == countryId)
                .map(Countries::getCapital)
                .findFirst();
    }

    public Optional<Long> getPopulationForCountry(int countryId) {
        return countries.stream()
                .filter(countries -> countries.getId() == countryId)
                .map(Countries::getPopulation)
                .findFirst();
    }

    public List<Countries> getContinentCountries(String continent) {
        return countries.stream()
                .filter(countries -> countries.getContinent().equalsIgnoreCase(continent))
                .collect(toList());
    }

    public List<List<String>> getCountryNeighbours(int countryId) {
        return countries.stream()
                .filter(countries -> countries.getId() == countryId)
                .map(countries -> countries.getNeighbours())
                .collect(toList());
    }
}
