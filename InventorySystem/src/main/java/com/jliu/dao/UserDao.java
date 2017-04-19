package com.jliu.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.jliu.model.User;

public class UserDao extends AbstractorDao {
	public boolean isUserExist(String loginName) {
		Session session = getSession();

		List<User> list = session.createCriteria(User.class).add(Restrictions.eq("loginName", loginName)).list();
		
		return list.isEmpty() ? false : true;
	}
	
	public boolean isUserValid(String loginName, String password) {
		Session session = getSession();
		
		Criteria crit = session.createCriteria(User.class);
		crit.add(Restrictions.and(Restrictions.eq("loginName", loginName), Restrictions.eq("password", password)));
		List<User> list = crit.list();
		
		
		return list.isEmpty() ? false : true;
	}
}
