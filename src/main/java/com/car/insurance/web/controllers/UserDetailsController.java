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

import com.car.insurance.feign.domains.ResponseData;
import com.car.insurance.feign.domains.UserDetailsData;
import com.car.insurance.web.services.FeignUserDetailsService;
import com.car.insurance.web.utils.LdapUtils;

/**
 * @author
 *
 */
@RestController
@RequestMapping("/client")
public class UserDetailsController {
	
	
	@Autowired
	private FeignUserDetailsService feignUserDetailsService;
	LdapUtils ldapUtils= new LdapUtils();

	/**
	 * @return
	 */		
	@GetMapping("/get-userdetails-data")
	public ResponseEntity<?> fetchCompanyProfile(HttpServletRequest request) {
		return new ResponseEntity<List<UserDetailsData>>(feignUserDetailsService.fetchAllData(), HttpStatus.OK);

	}
	/**
	 * @return
	 */		
	@DeleteMapping("/delete-userdetails/{id}")
	public ResponseEntity<?> deleteRecord(HttpServletRequest request, @PathVariable Long id) {		
		return new ResponseEntity<ResponseData>(feignUserDetailsService.delete(id), HttpStatus.OK);

	}
	
	/**
	 * @return
	 */		
	@PostMapping("/save-userdetails")
	public void saveData(@RequestBody UserDetailsData userDetailsData) {		
		feignUserDetailsService.saveData(userDetailsData);

	}
	
}
