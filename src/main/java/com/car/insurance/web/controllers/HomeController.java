/**
 * 
 */
package com.car.insurance.web.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.car.insurance.web.utils.AppConstants;

/**
 * @author
 *
 */
@Controller
//@RequestMapping("/client")
public class HomeController {

	
	@GetMapping("/user-details")
	public String userDetails(HttpServletRequest request) {
		return AppConstants.USERS_DETAILS;
	}
	
	@GetMapping("/car-insurance")
	public String loadPage(HttpServletRequest request) {
		return AppConstants.INDEX;

	}
	
	@GetMapping("/car-insurance-data")
	public String carInsurance(HttpServletRequest request) {
		return AppConstants.CAR_INSURANCE;

	}
	
	@GetMapping("/emergency-contact")
	public String emergencyContact(HttpServletRequest request) {
		return AppConstants.EMERGENCY_CONTACTS;

	}
	
	@GetMapping("/nominees-contact")
	public String nomineesContact(HttpServletRequest request) {
		return AppConstants.NOMINEES_CONTACTS;

	}
}
