package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.DAO.UserDAO;
import com.demo.entity.DonorDetails;
import com.demo.entity.UserInformation;
import com.demo.service.DonorService;
import com.demo.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class TestController {
	@Autowired
	UserService userService;
	@Autowired
	DonorService donorService;
	@RequestMapping("/registrationpage")
	public String registrationPage() {
		return "UserRegistrationPage";
	} 
	@RequestMapping("/registration")
	public String userResgistration(UserInformation userInformation,Model model)
	{
		System.out.println(userInformation);
		
	    userService.userRegistrationData(userInformation);
		
		return "redirect:/getAllusers";
	}
	@RequestMapping("/getAllusers")
	public String getAllUserDetails(Model model)
	{
		List<UserInformation> allUserDetails = userService.allUserDetails();
		model.addAttribute("alluserdetails",allUserDetails);
		return "DisplayAllUserDetails";
		
		}
	//@ResponseBody
	@RequestMapping("/sortbyname")
	public String getUserInfo(@RequestParam("username")String name,Model model)
	{
		List<UserInformation> byUsingName = userService.getUserDetailsByUsingName(name);
		model.addAttribute("alluserdetails",byUsingName);
		return "DisplayAllUserDetails";
	}
	//@ResponseBody
	@RequestMapping("/sortbygender")
	public String getGenderInfo(@RequestParam("usergender")String gender,Model model)
	{
		List<UserInformation> byUsingGender = userService.getUserByUsingGender(gender);
		model.addAttribute("alluserdetails",byUsingGender);
		return "DisplayAllUserDetails";
	}

	@RequestMapping("/filteruser")
	public String filterUserDetails(@RequestParam("nameorgenderoremailidorpasswordoraddress") String filteruser,Model model)
	{
		List<UserInformation> data = userService.getUserByUsingNameOrEmailidOrGenderOrAddressOrPassword(filteruser);
		model.addAttribute("alluserdetails",data);
		return "DisplayAllUserDetails";
	}
	@RequestMapping("deleteuser")
	public String deleteUserDetails(@RequestParam("useremailid")String emailid)
	{
		if(userService.deleteUserByUsingEmaild(emailid))
		{
			return "redirect:/getAllusers";
		
		}
		else
		{
			return "redirect:/getAllusers";
		}
	}
	@RequestMapping("/UpdateDetails")
	public String updateUserDetails(String username,String useremailid,long usermobilenumber,String userpassword,String usergender,String useraddress,Model model)
	{
		model.addAttribute("username", username);
		model.addAttribute("useremailid", useremailid);
		model.addAttribute("usermobilenumber", usermobilenumber);
		model.addAttribute("userpassword", userpassword);
		model.addAttribute("usergender", usergender);
		model.addAttribute("useraddress", useraddress);
		return "UpdateDetails";	
	}
	@RequestMapping("/update")
	public String updateuser(UserInformation userInformation)
	{
		userService.updateUserDetails(userInformation);
		return "redirect:/getAllusers";
	}
	
	@RequestMapping("/validateuserloginPage")
	public String loginPage(Model model) 
	{
		return "UserLogin";
	}
	
	
	@RequestMapping("/validateuserlogin")
	public String userLogin(UserInformation userInformation, Model model,HttpServletRequest request) 
	{
		UserInformation DatabaseUserDetails = donorService.validateUserLogin(userInformation);
		if(DatabaseUserDetails != null)
		{
			request.getSession().setAttribute("databaseUserDetails", DatabaseUserDetails);
			model.addAttribute("databaseUserDetails", DatabaseUserDetails);
			System.out.println("userLogin------->");
			System.out.println(DatabaseUserDetails);
			return "DonateOrNeedBlood";
		}
		else
		{
//			model.addAttribute("msg", "Invalid Login Details");
			return "redirect:/validateuserloginPage";
		}
	}
	
	@RequestMapping("/donateBlood")
	public String donateBlood(String DonateBlood, Model model, HttpServletRequest request) 
	{
		UserInformation userInformation = (UserInformation)request.getSession().getAttribute("databaseUserDetails");
		model.addAttribute("databaseUserDetails", userInformation);
		return "ReadyToDonatePage";
	}
	
	@RequestMapping("/needBlood")
	public String needBlood(Model model)
	{
		List<DonorDetails> allDonorDetails = donorService.getAllDonorDetails();
		model.addAttribute("allDonorDetails", allDonorDetails);
		return "AllDonarDetailsPage";
	}
	
	@ResponseBody
	@RequestMapping("/blooddonordetails")
	public String bloodDonorDetails(UserInformation userInformation, int userage, String userbloodgroup) 
	{
		donorService.insertDonorDetails(userInformation, userage, userbloodgroup);
		System.out.println(userInformation);
		System.out.println(userage);
		System.out.println(userbloodgroup);
		return "Thankyou For Saving Life";
	}
}
