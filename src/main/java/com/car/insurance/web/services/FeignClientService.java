package com.car.insurance.web.services;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.car.insurance.feign.domains.CarInsuranceData;
import com.car.insurance.feign.domains.ResponseData;

@FeignClient("http://rest-web-service")
public interface FeignClientService {
	
	@RequestMapping(method = RequestMethod.GET, value = "/insurance/car/data")
	List<CarInsuranceData> fetchAllData();

	@RequestMapping(method = RequestMethod.POST, value = "/insurance/car/save")
	void saveData(CarInsuranceData carInsuranceData);
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/insurance/car/delete/{id}", consumes = "application/json")
	ResponseData delete(@PathVariable("id") Long id);
}