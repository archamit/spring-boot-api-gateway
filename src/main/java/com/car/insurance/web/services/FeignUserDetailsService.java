package com.car.insurance.web.services;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.car.insurance.feign.domains.ResponseData;
import com.car.insurance.feign.domains.UserDetailsData;

@FeignClient("http://rest-web-service")
public interface FeignUserDetailsService {

	@RequestMapping(method = RequestMethod.GET, value = "/insurance/userdetails/data")
	List<UserDetailsData> fetchAllData();

	@RequestMapping(method = RequestMethod.POST, value = "/insurance/userdetails/save")
	void saveData(UserDetailsData userDetailsData);
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/insurance/userdetails/delete/{id}", consumes = "application/json")
	ResponseData delete(@PathVariable("id") Long id);
}
