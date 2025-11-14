package com.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class UserInformation {
	private String username;
	@Id
	private String useremailid;
	@Column(unique=true,nullable=false)
	private String userpassword; 
	@Column(unique=true,nullable=false)
	private long usermobilenumber;
	private String useraddress;
	private String usergender;

}
