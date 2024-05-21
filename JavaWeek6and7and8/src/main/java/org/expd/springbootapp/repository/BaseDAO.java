package org.expd.springbootapp.repository;

import java.util.List;

public interface BaseDAO<T> {

    public T insert(T object);

    public void update(T object);

    public void delete(int id);

    public T get(int id);

    public List<T> getAll();

    void clearDatabase();
    void initDatabase();

}
