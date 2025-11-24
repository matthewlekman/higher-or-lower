package com.game.data;

import com.game.model.Country;
import java.util.List;

public interface CountryData {
    List<Country> loadCountries() throws Exception;
}
