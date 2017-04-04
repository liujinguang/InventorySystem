package com.jliu.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.jliu.model.Customer;

public class CustomerDao extends AbstractorDao {
	/** 
	 * check if the customer name exists
	 * @param fullName
	 * @return boolean
	 */
	public boolean isCustomerPresent(String fullName) {
		Session session = getSession();
		Transaction tx = null;
		
		List<Customer> list = session.createCriteria(Customer.class).add(Restrictions.eq("name", fullName)).list();
		
		return list.isEmpty() ? false : true;
	}
	
	/**
	 * Get customer by full name
	 * @param fullName
	 * @return Customer found
	 */
	public Customer getByName(String fullName) {
		Session session = getSession();
		Transaction tx = null;
		
		List<Customer> list = session.createCriteria(Customer.class).add(Restrictions.eq("name", fullName)).list();
		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
	}
	
	public void deleteByName(String fullName){
		
	}
	
}
