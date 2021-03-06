package com.company.model.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    static final String filepath="E:\\repository\\ZTP\\ztpWorkspace\\Zadanie0.2\\test";

    Optional<T> get(long id);
    List<T> getAll();
    Optional<T> save(T t);
    Optional<T> update(T t);
    void delete(long id);
}
