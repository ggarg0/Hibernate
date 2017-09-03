package org.gaurav.hibernate.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.AttributeOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;



@Entity ()
@Table (name="USER_DATA")
public class UserCollections {
	
	@Id	@GeneratedValue (strategy=GenerationType.AUTO)
	private int UserId;
	private String UserName;
	
	/*//@OneToOne (create a vehicle Id column in User table, 2 tables - user and vehicle) 
	@JoinColumn(name="Vehicle_id")
	private Vehicle vehicle;*/
	
	//@OneToMany (mappedBy="user") // USer, vechicle and User_vehicle table
	/*@JoinTable(name="User_Vehicle", joinColumns=@JoinColumn(name="User_Id"), 
	inverseJoinColumns=@JoinColumn(name="Vehicle_Id"))*/
	
	/*@ManyToMany //(3 tables using mapped by)
	private Collection<Vehicle> vehicle= new ArrayList<Vehicle>();
	*/
	
	
	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name="User_Address", joinColumns=@JoinColumn(name="USER_ID"))
	@GenericGenerator(name="hilo-gen",strategy="hilo")
	@CollectionId(columns = { @Column(name="Address_ID") }, 
	generator = "hilo-gen", type = @Type(type = "long"))
	private List<Address> listOfAddress=new ArrayList();
	
	public List<Address> getListOfAddress() {
		return listOfAddress;
	}

	public void setListOfAddress(List<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;
	} 

	/*public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	@OneToMany (cascade=CascadeType.PERSIST) // USer, vechicle and User_vehicle table
	private Collection<Vehicle> vehicle=new ArrayList<Vehicle>();
	
	public Collection<Vehicle> getVehicle() {
		return vehicle;
	}

	public void setVehicle(Collection<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}*/

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		this.UserId = userId;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		this.UserName = userName;
	}


}
