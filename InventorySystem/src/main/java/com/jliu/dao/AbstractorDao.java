package com.jliu.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class AbstractorDao {
	private static SessionFactory sessionFactory ;
	
	static {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	
	public Session getSession() {
		return sessionFactory.openSession();
	}
	
	public StatelessSession getStatelessSession() {
		return sessionFactory.openStatelessSession();
	}
	
	public Object get(Long id, Class clazz) {
		Session session = getSession();
		Transaction tx = null;
		Object obj = null;
		
		try {
			tx = session.beginTransaction();
			
			obj = session.get(clazz, id);
			
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
				
				throw e;
			}
		} finally {
			session.close();
		}
		return obj;
	}
	
	public void saveOrUpdate(Object obj) {
		Session session = getSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(obj);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			
			throw e;
		} finally {
			session.close();
		}
	}
	
	public void delete(Object obj) {
		Session session = getSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.delete(obj);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public List findAll(Class clazz) {
		Session session = getSession();
		Transaction tx = null;
		List list = null;
		
		try {
			tx = session.beginTransaction();
			list = session.createQuery("FROM "+clazz.getSimpleName()).list();
			
			tx.commit();
			
			return list;
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			
			throw e;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
