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

import com.car.insurance.feign.domains.NomineesContactData;
import com.car.insurance.feign.domains.ResponseData;
import com.car.insurance.web.services.FeignNomineesContactService;

@RestController
@RequestMapping("/client")
public class NomineesContactController {
	
	@Autowired
	private FeignNomineesContactService feignNomineesContactService;

	
	/**
	 * @return
	 */		
	@GetMapping("/get-nominees-data")
	public ResponseEntity<?> fetchCompanyProfile(HttpServletRequest request) {
		return new ResponseEntity<List<NomineesContactData>>(feignNomineesContactService.fetchAllData(), HttpStatus.OK);

	}
	/**
	 * @return
	 */		
	@DeleteMapping("/delete-nomineesdata/{id}")
	public ResponseEntity<?> deleteRecord(HttpServletRequest request, @PathVariable Long id) {		
		return new ResponseEntity<ResponseData>(feignNomineesContactService.delete(id), HttpStatus.OK);

	}
	
	/**
	 * @return
	 */		
	@PostMapping("/save-nominees")
	public void saveData(@RequestBody NomineesContactData nomineesContactData) {		
		feignNomineesContactService.saveData(nomineesContactData);

	}
}
