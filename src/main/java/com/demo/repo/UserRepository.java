package com.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.entity.UserInformation;
@Repository
public interface UserRepository  extends JpaRepository<UserInformation, String>{
	List<UserInformation>getByUsername(String name);//userDAO
	List<UserInformation>getByUsergender(String gender);//userDAO
	@Query("select user from UserInformation user where user.username=?1or user.usergender=?1or user.useremailid=?1or user.userpassword=?1or user.useraddress=?1")
	List<UserInformation>readByUsernameOrUsergenderOrUseremailidOrUserpasswordOrUseraddress(String filteruser);
}
