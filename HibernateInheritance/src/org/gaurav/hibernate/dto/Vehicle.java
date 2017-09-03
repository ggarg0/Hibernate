package org.gaurav.hibernate.dto;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn (name="VEHICLE_TYPE", discriminatorType=DiscriminatorType.STRING)
//@DiscriminatorValue("CAR")
public class Vehicle {
	
	@Id @GeneratedValue
	private int VehicleId;
	private String VehicleName;
	
	public int getVehicleId() {
		return VehicleId;
	}
	public void setVehicleId(int vehicleId) {
		VehicleId = vehicleId;
	}
	public String getVehicleName() {
		return VehicleName;
	}
	public void setVehicleName(String vehicleName) {
		VehicleName = vehicleName;
	}

}
