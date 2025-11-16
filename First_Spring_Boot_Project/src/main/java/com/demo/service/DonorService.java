package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.demo.DAO.UserDAO;
import com.demo.entity.DonorDetails;
import com.demo.entity.UserInformation;

@Service
public class DonorService 
{
	@Autowired
	UserDAO userDAO;
	public UserInformation validateUserLogin(UserInformation userInformation) 
	{
		return userDAO.validateUserLogin(userInformation);
	}
	
	public DonorDetails insertDonorDetails(UserInformation user, int age, String bloodgroup) 
	{
		DonorDetails donorDetails = new DonorDetails();
		donorDetails.setBonorbloodgroup(bloodgroup);
		donorDetails.setDonoraddress(user.getUseraddress());
		donorDetails.setDonorage(age);
		donorDetails.setDonorgender(user.getUsergender());
		donorDetails.setDonoremailid(user.getUseremailid());
		donorDetails.setDonormobilenumber(user.getUsermobilenumber());
		donorDetails.setDonorname(user.getUsername());
		DonorDetails donor = userDAO.insertDonorDetails(donorDetails);
		return donor;
	}
	
	public List<DonorDetails> getAllDonorDetails() 
	{
		 return userDAO.selectAllDonorDetails();
	}
}
