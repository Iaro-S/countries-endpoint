package ro.fasttrackit.homework18.service;

import org.springframework.stereotype.Component;
import ro.fasttrackit.homework18.model.Countries;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class CountryReader {

    List<Countries> readCountriesFromFile() throws Exception {
        List<Countries> countries = new ArrayList<>();
        BufferedReader fileReader = new BufferedReader(new FileReader("files/countries"));
        int id = 1;
        String line;
        while ((line = fileReader.readLine()) != null) {
            countries.add(getCountries(id++, line));
        }
        return countries;
    }

    private static Countries getCountries(int id, String countryInfo) {
        String[] countryData = countryInfo.split("\\|");
        List<String> neighbours = new ArrayList<>();
        if (countryData.length > 5) {
            neighbours = getNeighbours(countryData[5]);
        }
        return new Countries(id,
                countryData[0],
                countryData[1],
                Long.parseLong(countryData[2]),
                Long.parseLong(countryData[3]),
                countryData[4],
                neighbours);
    }

    private static List<String> getNeighbours(String neighbours) {

        return Arrays.asList(neighbours.split("~"));
    }
}
