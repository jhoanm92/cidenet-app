package com.cidenet.service.serviceImpl;

import com.cidenet.mapper.GenericMapper;
import com.cidenet.repository.GenericRepository;
import com.cidenet.service.CRUD;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public abstract class CRUDimpl<T, DTO, ID> implements CRUD<DTO, ID> {

    @Autowired
    protected abstract GenericRepository<T, ID> getRepository();

    @Autowired
    private GenericMapper<DTO, T> mapper;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public DTO register(DTO dto) throws Exception {
        return mapper.getDto(getRepository().save(mapper.getEntity(dto)));
    }

    @Override
    public DTO update(DTO dto) throws Exception {
        return mapper.getDto(getRepository().save(mapper.getEntity(dto)));
    }

    @Override
    public List<DTO> getAll() throws Exception {
        return mapper.getDtos(getRepository().findAll());
    }

    @Override
    public DTO getById(ID id) throws Exception {
        Optional<T> optional = getRepository().findById(id);
        if(optional.isEmpty()){
            return null;
        }
        return mapper.getDto(optional.get());
    }

    @Override
    public void delete(ID id) throws Exception {
       getRepository().deleteById(id);
    }
}
