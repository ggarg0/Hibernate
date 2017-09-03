package org.gaurav.hibernate.dto;

import java.util.Date;

import javax.persistence.AttributeOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

@Entity ()
@Table (name="USER_DETAILS")
public class UserDetails {

//@EmbeddedId   -- Used for creating primary key from embedded class variables
// 	               @Embedded and @Id cannot be used together 
//private LoginName userId;
	
@Id	@GeneratedValue (strategy=GenerationType.AUTO)
@Column (name="USER_ID")
private int UserId;

@Column (name="USER_NAME", nullable=false)
private String UserName;

@Temporal (TemporalType.DATE)
@Column (name="USER_JOINDATE")
private Date joinedDate;

//@Lob
//@Type (type="text")

@Embedded
@AttributeOverrides({
	@AttributeOverride(name="street", column=@Column(name="HOME_STREET")),
	@AttributeOverride(name="city", column=@Column(name="HOME_CITY")),
	@AttributeOverride(name="state", column=@Column(name="HOME_STATE")),
	@AttributeOverride(name="pincode", column=@Column(name="HOME_PINCODE"))
})
private Address homeAddress;

@Embedded
private Address officeAddress;

@Transient
private String description;


public Address getHomeAddress() {
	return homeAddress;
}
public void setHomeAddress(Address homeAddress) {
	this.homeAddress = homeAddress;
}

public Address getOfficeAddress() {
	return officeAddress;
}
public void setOfficeAddress(Address officeAddress) {
	this.officeAddress = officeAddress;
}
public Date getJoinedDate() {
	return joinedDate;
}
public void setJoinedDate(Date joinedDate) {
	this.joinedDate = joinedDate;
}

public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}

//@Id	
//@Column (name="USER_ID")
public int getUserId() {
	return UserId;
}
public void setUserId(int userId) {
	this.UserId = userId;
}

//@Column (name="USER_NAME")
public String getUserName() {
	return UserName;
}
public void setUserName(String userName) {
	this.UserName = userName;
} 
}
