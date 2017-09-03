package org.gaurav.hibernate.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery (name="UserDetails.byId",query="select UserName,JobDescription from UserDetails where UserId=?")
@NamedNativeQuery (name="UserDetails.byName", 
			query="select * from USER_CRUD where USER_NAME = :username"
			, resultClass=UserDetails.class)
@org.hibernate.annotations.Entity(selectBeforeUpdate=true)
@Table (name="USER_CRUD")
public class UserDetails {

	@Id	@GeneratedValue (strategy=GenerationType.AUTO)
	@Column (name="USER_ID")
	private int UserId;

	@Column (name="USER_NAME", nullable=false)
	private String UserName;

	@Column (name="USER_JOB", nullable=false)
	private String JobDescription;

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getJobDescription() {
		return JobDescription;
	}

	public void setJobDescription(String jobDescription) {
		JobDescription = jobDescription;
	}

}
