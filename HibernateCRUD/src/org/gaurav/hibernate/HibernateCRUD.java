package org.gaurav.hibernate;


import java.util.ArrayList;
import java.util.List;

import org.gaurav.hibernate.dto.UserDetails;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class HibernateCRUD {

	public static void main(String[] args) {

	/*	int i=0;
		
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		for (i=0; i<10;i++)
		{
			UserDetails user= new UserDetails();
			user.setUserName("GAURAV "+ i);
			user.setJobDescription("Infosys");
			session.save(user);
			
		}
		
		UserDetails user = (UserDetails) session.get(UserDetails.class,5);
		System.out.println("User details : " + user.getUserName());
		//session.delete(user);
		user.setUserName("Gaurav Garg");
		//session.update(user);
		session.getTransaction().commit();
	
		session.close();
		*/
		
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		String UserId="3";
		String UserName="Gaurav Garg";
		
		/*Query query= session.createQuery("select UserName,JobDescription from UserDetails"
				+ " where UserId > ? and UserName = :username");
		query.setInteger(0,Integer.parseInt(UserId));
		query.setString("username",UserName);*/
	//	query.setFirstResult(5);
		//query.setMaxResults(4);
		
		//Query query=session.getNamedQuery("UserDetails.byId");
		//Query query=session.getNamedQuery("UserDetails.byName");
		//query.setInteger(0,2);
	//		query.setString("username", "Gaurav Garg");
		Criteria criteria = session.createCriteria(UserDetails.class);
		criteria.add(Restrictions.or(Restrictions.ilike("UserName", "%garg%"),
				Restrictions.between("UserId", 1, 3)));
		
	/*	criteria.add(Restrictions.ilike("UserName", "%aurav%"))
		.add(Restrictions.between("UserId", 2, 7));
		*/
		
		List<UserDetails> user = (List<UserDetails>) criteria.list();
		//List<UserDetails> user = (List<UserDetails>) query.list();
		/*List<Object[]> user = (List<Object[]>)query.list();
		 * 
		 * 
		
		session.getTransaction().commit();
		session.close();
		
		
		for(Object[] array : user) {
		    String firstName = (String) array[0];
		    String id = (String) array[1];
		    System.out.println(firstName + id);
		}*/
		
	for(UserDetails u : user)		
		System.out.println(u.getUserName()+u.getJobDescription()+u.getUserId());
		
	}

}
