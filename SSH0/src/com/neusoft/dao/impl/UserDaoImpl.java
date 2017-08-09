package com.neusoft.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;





import com.neusoft.bean.User;
import com.neusoft.dao.UserDao;

public class UserDaoImpl implements UserDao{
    private SessionFactory sessionFactory;
    
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	
	@Override
	public User loginUser(User user) {
		
//		List<User> list = (List<User>)this.getHibernateTemplate()
//		.find("from User where username=? and password=?", user.getUsername(),user.getPassword());
		
//		String sql = "from User where username=? and password=?";
//		String sql = "from User";
//		String sql = " from User where username= "+user.getUsername()+" and password=" +user.getPassword() ;
 		String sql = " from User where username= '"+user.getUsername()+"' and password='" +user.getPassword()+ "' ";
		
		Query query = sessionFactory.getCurrentSession().createQuery(sql);
//		query.setString(1, user.getUsername());
//		query.setString(2, user.getPassword()); 
		//query.uniqueResult();
		
		List<User> list = (List<User>)query.list();
		//System.out.println(list.get(0).getUsername()); 
		if(list!=null && list.size()!=0){
			User u = list.get(0);
			return u;
		}
	     return null;
	}

}
