package org.squallbayu.app.myportal.dao;

import java.io.Serializable;

public interface GenericDao<T, I extends Serializable> {

    T read(I id);

    void saveOrUpdate(T t);

    void delete(T persistentObject);
}
