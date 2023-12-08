package com.cidenet.mapper;

import com.cidenet.dto.EmployeeDTO;
import com.cidenet.model.EmployeeEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeMapper implements GenericMapper<EmployeeDTO, EmployeeEntity> {

    @Autowired
    private ModelMapper mapper;

    @Override
    public EmployeeDTO getDto(EmployeeEntity entity) {
        return mapper.map(entity, EmployeeDTO.class);
    }

    @Override
    public List<EmployeeDTO> getDtos(List<EmployeeEntity> entities) {
        return entities.stream().map(x -> mapper.map(x, EmployeeDTO.class)).collect(Collectors.toList());
    }

    @Override
    public EmployeeEntity getEntity(EmployeeDTO dto) {
        return mapper.map(dto, EmployeeEntity.class);
    }

    public Page<EmployeeDTO> getPageDtos(Page<EmployeeEntity> entities) {
        return new PageImpl<>(entities.stream().map(x -> mapper.map(x, EmployeeDTO.class)).collect(Collectors.toList()),
                entities.getPageable(),
                entities.getTotalElements());
    }
}
