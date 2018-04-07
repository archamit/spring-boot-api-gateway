/**
 * 
 */
package com.car.insurance.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.car.insurance.web.utils.AppConstants;

/**
 * @author jitender
 *
 */
@Controller
//@RequestMapping("/client")
public class LoginController {
	
	/**
	 * @return
	 */		
//	@GetMapping("/dashboard")
//	public String fetchCompanyProfile(HttpServletRequest request) {
//		return AppConstants.FORM_WINDOW;
//	}
	
	@GetMapping("/")
    public String home() {
		return AppConstants.LOGIN;
	}
	
	@GetMapping("/login-error")
	public String loginError(Model model) {
		model.addAttribute("loginError", true);
		return AppConstants.LOGIN;
	}
	
	@GetMapping("/login")
    public String index() {
/*		System.out.println("Getting UsernamePasswordAuthenticationToken from SecurityContextHolder");
        UsernamePasswordAuthenticationToken authentication =
                (UsernamePasswordAuthenticationToken)
                        SecurityContextHolder.getContext().getAuthentication();

        System.out.println("Getting principal from UsernamePasswordAuthenticationToken");
        LdapUserDetailsImpl principal = (LdapUserDetailsImpl) authentication.getPrincipal();

        System.out.println("authentication: " + authentication);
        System.out.println("authentication authorities: " + authentication.getAuthorities());
        System.out.println("principal: " + principal);*/
        return AppConstants.LOGIN;
    }
}
