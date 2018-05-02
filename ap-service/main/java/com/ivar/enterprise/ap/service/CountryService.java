package com.ivar.enterprise.ap.service;

import com.ivar.enterprise.ap.domain.Country;

import java.util.List;

public interface CountryService {
    List<Country> getCountries();
    Country getCountryById(long id);
    Country getCountryByCode(String code);
    Country getCountryByName(String name);
}
