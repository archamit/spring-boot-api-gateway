package com.car.insurance.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.car.insurance.web.utils.AppConstants;

/**
 * @author Jitender
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.car.insurance.web")
public class WebContext extends WebMvcConfigurerAdapter {
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {

	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		if (!registry.hasMappingForPattern(AppConstants.RESOURCE_HANDLER)) {
			registry.addResourceHandler(AppConstants.RESOURCE_HANDLER)
					.addResourceLocations(AppConstants.RESOURCE_LOCATION);
		}

	}
}