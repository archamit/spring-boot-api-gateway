package com.car.insurance.web.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.car.insurance.feign.domains.EmergencyContactData;
import com.car.insurance.feign.domains.ResponseData;
import com.car.insurance.web.services.FeignEmergencyContactService;


@RestController
@RequestMapping("/client")
public class EmergencyContactController {

	@Autowired
	private FeignEmergencyContactService feignEmergencyContactService;
	
	/**
	 * @return
	 */		
	@GetMapping("/get-emergencycontact-data")
	public ResponseEntity<?> fetchCompanyProfile(HttpServletRequest request) {
		return new ResponseEntity<List<EmergencyContactData>>(feignEmergencyContactService.fetchAllData(), HttpStatus.OK);

	}
	
	/**
	 * @return
	 */		
	@DeleteMapping("/delete-emergencycontact/{id}")
	public ResponseEntity<?> deleteRecord(HttpServletRequest request, @PathVariable Long id) {		
		return new ResponseEntity<ResponseData>(feignEmergencyContactService.delete(id), HttpStatus.OK);

	}
	
	/**
	 * @return
	 */		
	@PostMapping("/save-emergencycontact")
	public void saveData(@RequestBody EmergencyContactData emergencyContactData) {		
		feignEmergencyContactService.saveData(emergencyContactData);
		//return new ResponseEntity<List<CarInsuranceData>>(feignClientService.fetchAllData(), HttpStatus.OK);

	}
	
	
}
