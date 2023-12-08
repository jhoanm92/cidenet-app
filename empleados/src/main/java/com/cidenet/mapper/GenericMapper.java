package com.cidenet.mapper;

import java.util.List;

public interface GenericMapper<DTO, T> {

    DTO getDto(T entity);
    List<DTO> getDtos(List<T> entities);
    T getEntity(DTO dto);
}
