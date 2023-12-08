package com.cidenet.mapper;

import com.cidenet.dto.CountryDTO;
import com.cidenet.model.CountryEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryMapper implements GenericMapper<CountryDTO, CountryEntity> {

    @Autowired
    private ModelMapper mapper;

    @Override
    public CountryDTO getDto(CountryEntity entity) {
        return mapper.map(entity, CountryDTO.class);
    }

    @Override
    public List<CountryDTO> getDtos(List<CountryEntity> entities) {
        return entities.stream().map(x -> mapper.map(x, CountryDTO.class)).collect(Collectors.toList());
    }

    @Override
    public CountryEntity getEntity(CountryDTO countryDTO) {
        return mapper.map(countryDTO, CountryEntity.class);
    }
}
