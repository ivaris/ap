package com.ivar.enterprise.ap.service;

import com.ivar.enterprise.ap.domain.Country;

import java.util.List;

public interface EntityService<T extends Object>  {
    List<T> getEntites();
    List<T> getEntitesByCustomFilter(CustomFilter filter);
    List<T> getEntitesByCustomFilters(List<CustomFilter> filters);
    T getEntityById(long id);
    T getEntityByCode(String code);
    T getEntityByName(String name);
}
