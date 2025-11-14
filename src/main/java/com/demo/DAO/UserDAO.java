package com.demo.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.entity.DonorDetails;
import com.demo.entity.UserInformation;
import com.demo.repo.DonarRepository;
import com.demo.repo.UserRepository;
@Repository
public class UserDAO {
	@Autowired
	UserRepository userRepository;
	@Autowired
	DonarRepository donarRepository;
	
	public UserInformation insertUserOnformationDetails(UserInformation userInformation)
	{
		return userRepository.save(userInformation);
	}
	public List<UserInformation> selectAllUserDetails()
	{
		return userRepository.findAll();
	}
	public List<UserInformation> selectUserByUserName(String name)
	{
		return userRepository.getByUsername(name);//UserDAO
	}
	public List<UserInformation> selectUserByGender(String gender)
	{
		return userRepository.getByUsergender(gender);
		
	}
	public List<UserInformation> selectUserByUsingNameOrEmailidOrPasswordOrAddressOrGender(String filteruser)
	{
		return userRepository.readByUsernameOrUsergenderOrUseremailidOrUserpasswordOrUseraddress(filteruser);
	}
	public boolean deleteUserByUsingEmailid(String emailid)
	{
		Optional<UserInformation> byId = userRepository.findById(emailid);
		try {
			UserInformation userInformation = byId.get();
			userRepository.delete(userInformation);
			return true;
			
		} catch (Exception e) {
			return false;
		}	
	}
	public void updateUserByUsingEmailId(UserInformation information) 
	{
		Optional<UserInformation> byId = userRepository.findById(information.getUseremailid());
		UserInformation userInformation = byId.get();
		if(userInformation.getUseremailid().equals(information.getUseremailid()))
			userRepository.save(information);
	}
	public UserInformation validateUserLogin(UserInformation user) 
	{
		Optional<UserInformation> byId = userRepository.findById(user.getUseremailid());
		try 
		{
			UserInformation userInformation = byId.get();
			System.out.println("database------------->");
			System.out.println(userInformation);
			String useremail = userInformation.getUseremailid();
			boolean password = false;
			if(userInformation.getUserpassword().equals(user.getUserpassword()))
				password = true;
			if(useremail.equals(user.getUseremailid()) && password)
				return userInformation;
			else
				return null;
		} 
		catch (Exception e) 
		{
			return null;
		}
	}
	public DonorDetails insertDonorDetails(DonorDetails donorDetails) 
	{
		return donarRepository.save(donorDetails);
	}
	
	public List<DonorDetails> selectAllDonorDetails() 
	{
		return donarRepository.findAll();
	}
	
}
