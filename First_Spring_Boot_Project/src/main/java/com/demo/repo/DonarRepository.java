package com.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.DonorDetails;

public interface DonarRepository extends JpaRepository<DonorDetails,Integer>
{
	
}
