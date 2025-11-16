package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.DAO.UserDAO;
import com.demo.entity.UserInformation;
import com.demo.exception.userException;
@Service
public class UserService {
	@Autowired
	UserDAO userDAO;
	public UserInformation userRegistrationData(UserInformation userInformation)
	{
		List<UserInformation> allUserDetails = userDAO.selectAllUserDetails();
		UserInformation user=new UserInformation();
		int count=0;
		for(UserInformation userInformation2:allUserDetails) {
			if(userInformation2.getUseremailid().equals(userInformation.getUseremailid()))
					{
				       count++;
					}
		}
		if(count>0)
		{
			throw new userException("EmailId is already Present");
		}
		else
		{
			user.setUseremailid(userInformation.getUseremailid());
		}
		int mobilecount=0;
		for (UserInformation userInformation2 : allUserDetails) {
			if(userInformation2.getUsermobilenumber()==userInformation.getUsermobilenumber()) {
				mobilecount++;
			}
			
		}
		if(mobilecount>0)
		{
			throw new userException("Mobile Number is already Present");
		}
		else
		{
			user.setUsermobilenumber(userInformation.getUsermobilenumber());
		}
		int passcount=0;
		for (UserInformation userInformation2 : allUserDetails) {
			if(userInformation2.getUserpassword().equals(userInformation.getUserpassword()))
			{
				passcount++;
			}
		}
		if(passcount>0)
		{
			throw new userException("Password is already Present");
		}
		else
		{
			user.setUserpassword(userInformation.getUserpassword());
		}
		user.setUseraddress(userInformation.getUseraddress());
		user.setUsergender(userInformation.getUsergender());
		user.setUsername(userInformation.getUsername());
		return userDAO.insertUserOnformationDetails(user);
	}
	
	public List<UserInformation> allUserDetails()
	{
		return userDAO.selectAllUserDetails();
	}
	public List<UserInformation> getUserDetailsByUsingName(String name)
	{
		return userDAO.selectUserByUserName(name);
	}
	public List<UserInformation> getUserByUsingGender(String gender)
	{
		return userDAO.selectUserByGender(gender);
	}
	public List<UserInformation> getUserByUsingNameOrEmailidOrGenderOrAddressOrPassword(String filteruser)
	{
		return userDAO.selectUserByUsingNameOrEmailidOrPasswordOrAddressOrGender(filteruser);
	}
	public boolean deleteUserByUsingEmaild(String emailid)
	{
		return userDAO.deleteUserByUsingEmailid(emailid);
	}
	public void updateUserDetails(UserInformation userInformation)
	{
		userDAO.updateUserByUsingEmailId(userInformation);
	}

}
