package com.car.insurance.web.services;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.car.insurance.feign.domains.NomineesContactData;
import com.car.insurance.feign.domains.ResponseData;

@FeignClient("http://rest-web-service")
public interface FeignNomineesContactService {
	
	@RequestMapping(method = RequestMethod.GET, value = "/insurance/nomineescontact/data")
	List<NomineesContactData> fetchAllData();

	@RequestMapping(method = RequestMethod.POST, value = "/insurance/nomineescontact/save")
	void saveData(NomineesContactData nomineesContactData);
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/insurance/nomineescontact/delete/{id}", consumes = "application/json")
	ResponseData delete(@PathVariable("id") Long id);

}
