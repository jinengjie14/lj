package com.yiwxine.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseDao<T> {
	protected final Logger log = LoggerFactory.getLogger(getClass());

	@PersistenceContext
	private EntityManager entityManager;
		
	public Session getSession(){
		return entityManager.unwrap(Session.class);
	}	

	public List<T> findAllByCriteria(final DetachedCriteria detachedCriteria) {
		Criteria criteria = detachedCriteria.getExecutableCriteria(getSession());
		return criteria.list();
	}

	public List<T> findAllByCriteria(Session session, final DetachedCriteria detachedCriteria) {
		Criteria criteria = detachedCriteria.getExecutableCriteria(session);
		return criteria.list();
	}
}
