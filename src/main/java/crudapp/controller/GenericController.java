package crudapp.controller;

import java.util.List;

public interface GenericController<T, ID> {
    T create(T t);
    T read(ID id);
    List<T> readAll();
    void update(T t);
    void delete(ID id);
}