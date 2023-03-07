package com.xnaraassessment.currencyconversionservice.utils;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class MapperUtility {

    public static <R, E> E convertRequestToEntity(R request, E entity) {
        ModelMapper modelMapper = new ModelMapper();
        return (E) modelMapper.map(request, entity.getClass());
    }
}
