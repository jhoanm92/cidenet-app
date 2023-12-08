package com.cidenet.service.serviceImpl;

import com.cidenet.dto.CountryDTO;
import com.cidenet.model.CountryEntity;
import com.cidenet.repository.CountryRepository;
import com.cidenet.repository.GenericRepository;
import com.cidenet.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl extends CRUDimpl<CountryEntity, CountryDTO, Integer> implements CountryService {

    @Autowired
    private CountryRepository repository;

    @Override
    protected GenericRepository<CountryEntity, Integer> getRepository() {
        return repository;
    }
}
