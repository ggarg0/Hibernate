package org.gaurav.hibernate.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@javax.persistence.SequenceGenerator(
	    name="SEQ_GEN",
	    sequenceName="my_sequence", initialValue=1000, allocationSize=1)

@Entity
public class Vehicle {
	@Id @GeneratedValue (strategy=GenerationType.SEQUENCE, generator="SEQ_GEN")
	private int vehicleId;
	private String vehicleName;
	
	
	/*@ManyToOne 2 table with user id in vehicle table
	 * @NotFound (action=NotFoundAction.IGNORE)
	@JoinColumn (name="User_id")*/
	//private UserCollections user;
	
/*	public UserCollections getUser() {
		return user;
	}
	public void setUser(UserCollections user) {
		this.user = user;
	} */ 
	/*
	@ManyToMany (mappedBy = "vehicle")
	private Collection<UserCollections> user=new ArrayList<UserCollections>();
	public Collection<UserCollections> getUser() {
		return user;
	}
	public void setUser(Collection<UserCollections> user) {
		this.user = user;
	}*/
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	
	
	
}
