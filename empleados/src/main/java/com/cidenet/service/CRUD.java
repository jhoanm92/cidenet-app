package com.cidenet.service;

import java.util.List;

public interface CRUD<T, ID> {
    T register(T t) throws Exception;
    T update(T t) throws Exception;
    List<T> getAll() throws Exception;
    T getById(ID id) throws Exception;
    void delete(ID id) throws Exception;
}
