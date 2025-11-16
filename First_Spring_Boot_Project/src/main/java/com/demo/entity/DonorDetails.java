package com.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class DonorDetails 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int donorid;
	private String donorname;
	@Column(unique = true, nullable = false)
	private long donormobilenumber;
	private String donoremailid;
	private String donoraddress;
	private String donorgender;
	@Column(nullable = false)
	private int donorage;
	@Column(nullable = false)
	private String bonorbloodgroup;
}