package org.squallbayu.app.myportal.dao.impl;

import java.io.Serializable;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.squallbayu.app.myportal.dao.GenericDao;

public class GenericDaoImpl<T,I extends Serializable> extends HibernateDaoSupport implements GenericDao<T, I>{

	private Class<T> type;
	
	public GenericDaoImpl(Class<T> type) {
        this.type = type;
    }

	@Override
	public T read(I i) {
		getHibernateTemplate().get(type, i);
		return null;
	}

	@Override
	public void saveOrUpdate(T t) {
		 getHibernateTemplate().saveOrUpdate(t);
	}

	@Override
	public void delete(T t) {
		getHibernateTemplate().delete(t);
		
	}

}
