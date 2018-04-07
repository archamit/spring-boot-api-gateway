package com.car.insurance.web.services;

import java.util.List;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.car.insurance.feign.domains.EmergencyContactData;
import com.car.insurance.feign.domains.ResponseData;
@FeignClient("http://rest-web-service")
public interface FeignEmergencyContactService {

	@RequestMapping(method = RequestMethod.GET, value = "/insurance/emergencycontact/data")
	List<EmergencyContactData> fetchAllData();

	@RequestMapping(method = RequestMethod.POST, value = "/insurance/emergencycontact/save")
	void saveData(EmergencyContactData emergencyContactData);
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/insurance/emergencycontact/delete/{id}", consumes = "application/json")
	ResponseData delete(@PathVariable("id") Long id);
}
