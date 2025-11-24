package com.game.data;

import com.game.model.Country;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvData implements CountryData {
    private String filePath;

    public CsvData(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Country> loadCountries() throws Exception {
        List<Country> countries = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                int rank = Integer.parseInt(parts[0]);
                String name = parts[1];
                double points = Double.parseDouble(parts[2]);
                String confederation = parts[3];

                Country country = new Country(rank, name, points, confederation);
                countries.add(country);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Error reading CSV file");
            throw e;
        }
        return countries;
    }
}
