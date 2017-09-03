package org.gaurav.hibernate;

import org.gaurav.hibernate.dto.FourWheeler;
import org.gaurav.hibernate.dto.TwoWheeler;
import org.gaurav.hibernate.dto.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateInheritanceTest {

	public static void main(String[] args) {

		Vehicle vehicle=new Vehicle();
		
		TwoWheeler bike=new TwoWheeler();
		FourWheeler car=new FourWheeler();
				
		vehicle.setVehicleName("CAR");
		
		bike.setVehicleName("HONDA");
		bike.setSteeringHandle("Honda Steering handle");
		
		car.setVehicleName("BMW");
		car.setSteeringwheel("BMW Steering Handle");
			
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(vehicle);
		session.save(bike);
		session.save(car);
		session.getTransaction().commit();
		session.close();
		
		

	}

}
