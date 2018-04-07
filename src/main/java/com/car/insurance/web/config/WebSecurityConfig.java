
package com.car.insurance.web.config;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.encoding.LdapShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.ldap.DefaultSpringSecurityContextSource;

@Configuration
@PropertySource({ "classpath:ldap.properties" })
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private Environment env;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable();
		http.authorizeRequests().antMatchers("/client").hasAnyRole("MANAGERS", "DEVELOPERS")
				.antMatchers(HttpMethod.OPTIONS, "/**").permitAll().antMatchers(HttpMethod.GET, "/**").permitAll()
				.antMatchers(HttpMethod.POST, "/**").permitAll().antMatchers(HttpMethod.PUT, "/**").permitAll()
				.antMatchers(HttpMethod.DELETE, "/**").permitAll().anyRequest().fullyAuthenticated().and().formLogin()
				.loginPage("/").failureUrl("/login-error").defaultSuccessUrl("/car-insurance#!/car-insurance-data").usernameParameter("username")
				.passwordParameter("password").and().logout().logoutSuccessUrl("/").and().sessionManagement()
				.invalidSessionUrl("/").sessionAuthenticationErrorUrl("/");

	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.ldapAuthentication().userDnPatterns("uid={0},ou=people").userSearchBase("ou=people")
				.userSearchFilter("uid={0}").groupSearchBase("ou=groups").groupSearchFilter("uniqueMember={0}")
				.contextSource(contextSource()).passwordCompare().passwordEncoder(new LdapShaPasswordEncoder())
				.passwordAttribute("userPassword");
	}

	@Bean
	public DefaultSpringSecurityContextSource contextSource() {
		return new DefaultSpringSecurityContextSource(Collections.singletonList(env.getProperty("ldap.url")),
				"dc=memorynotfound,dc=com");
	}

}