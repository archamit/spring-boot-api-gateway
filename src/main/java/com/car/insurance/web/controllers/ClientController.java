/**
 * 
 */
package com.car.insurance.web.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.car.insurance.feign.domains.CarInsuranceData;
import com.car.insurance.feign.domains.ResponseData;
import com.car.insurance.web.services.FeignClientService;
import com.car.insurance.web.utils.CallDetailsUtils;


/**
 * @author
 *
 */
@RestController
@RequestMapping("/client")
public class ClientController {
	
	
	@Autowired
	private FeignClientService feignClientService;
	CallDetailsUtils callDetailsUtils= new CallDetailsUtils();
	
	/**
	 * @return
	 */		
	@GetMapping("/service-data")
	public ResponseEntity<?> fetchCompanyProfile(HttpServletRequest request) {
		return new ResponseEntity<List<CarInsuranceData>>(feignClientService.fetchAllData(), HttpStatus.OK);

	}
	/**
	 * @return
	 */		
	@DeleteMapping("/delete-servicedata/{id}")
	public ResponseEntity<?> deleteRecord(HttpServletRequest request, @PathVariable Long id) {		
		return new ResponseEntity<ResponseData>(feignClientService.delete(id), HttpStatus.OK);

	}
	/**
	 * @return
	 */		
	@PostMapping("/save")
	public void saveData(@RequestBody CarInsuranceData carInsuranceData) {		
		feignClientService.saveData(carInsuranceData);
		//return new ResponseEntity<List<CarInsuranceData>>(feignClientService.fetchAllData(), HttpStatus.OK);

	}
	
	
}
