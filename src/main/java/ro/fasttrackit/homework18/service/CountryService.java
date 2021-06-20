package ro.fasttrackit.homework18.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.homework18.model.Countries;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

import static java.util.stream.Collectors.*;

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
                .map(Countries::getNeighbours)
                .collect(toList());
    }

    public List<Countries> getCountryLargerPopulation(String continent, Long minPopulation) {
        return countries.stream()
                .filter(countries -> countries.getContinent().equalsIgnoreCase(continent))
                .filter(countries -> countries.getPopulation() >= minPopulation)
                .collect(toList());
    }

    public List<Countries> getCountryNeighbours(String includeNeighbour, String excludeNeighbour) {
        return countries.stream()
                .filter(countries -> countries.getNeighbours().contains(includeNeighbour.toUpperCase()))
                .filter(Predicate.not(countries -> countries.getNeighbours().contains(excludeNeighbour.toUpperCase())))
                .collect(toList());
    }

    public Map<String, Long> mapCountryToPopulation() {
        return countries.stream()
                .collect(toMap(Countries::getName, Countries::getPopulation));
    }

    public Map<String, List<Countries>> mapContinentToCountries() {
        return countries.stream()
                .collect(groupingBy(Countries::getContinent));
    }
}
