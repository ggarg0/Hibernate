package org.gaurav.hibernate.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

	public static void main(String[] a)
	{
		UserDetails obj=new UserDetails();
				
		//obj.setUserId(1003);
		obj.setUserName("MARK");
		obj.setOfficeAddress(new Address("5600 HQ DRIVE","PLANO","TEXAS","75024"));
		obj.setHomeAddress(new Address("8025 OHIO DRIVE","PLANO","TEXAS","75024"));
		obj.setJoinedDate(new Date());
		obj.setDescription("Java Hibernate");
		
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(obj);
		session.getTransaction().commit();
		session.close();
		
		obj=null;
		// Used to Retrieve data from DB
		session=sessionFactory.openSession();
		session.beginTransaction();
		obj = (UserDetails) session.get(UserDetails.class, 1);
		System.out.println("User Name : " + obj.getUserName() + obj.getHomeAddress().getState());
		
		
		// Used for Collections
		UserCollections objColl= new UserCollections();
		UserCollections objColl1= new UserCollections();
		
		Address add1=new Address();
		add1.setStreet("8025 OHIO DRIVE");
		add1.setCity("PLANO");
		add1.setState("TEXAS");
		add1.setPincode("75024");
		
		Address add2=new Address();
		add2.setStreet("5600 HQ DRIVE");
		add2.setCity("PLANO");
		add2.setState("TEXAS");
		add2.setPincode("75024");
		
		objColl.setUserName("GAURAV");
		objColl.getListOfAddress().add(add1);
		objColl.getListOfAddress().add(add2);
		
		objColl1.setUserName("GARG");
		objColl1.getListOfAddress().add(add1);
		objColl1.getListOfAddress().add(add2);
		
	
	//	session.beginTransaction();
		session.save(objColl);
		session.save(objColl1);
		session.getTransaction().commit();
		session.close();
		
		objColl=null;
		// Used to Retrieve data from DB
		session=sessionFactory.openSession();
		session.beginTransaction();
		objColl = (UserCollections) session.get(UserCollections.class, 2);
		session.close();
		System.out.println("User Name : " + objColl.getListOfAddress().get(0).getCity());
		
		
		//Used for mappings
		
	/*	UserCollections user= new UserCollections();
				
		Vehicle vehicle=new Vehicle();
		Vehicle vehicle1=new Vehicle();
		
		user.setUserName("GAURAV");
		vehicle.setVehicleName("CAR");
		vehicle1.setVehicleName("JEEP");
		
		user.getVehicle().add(vehicle);
		user.getVehicle().add(vehicle1);
		
		//vehicle.setUser(user);
		//vehicle1.setUser(user);
		
	//	vehicle.getUser().add(user);
		//vehicle1.getUser().add(user);
		
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.persist(user);
		//session.save(vehicle);
		//session.save(vehicle1);
		session.getTransaction().commit();
		session.close();
		*/
	}
}
