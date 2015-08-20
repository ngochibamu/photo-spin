package com.chibamu.photospin.configuration;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configurable
@ComponentScan (basePackages = {"com.chibamu.photospin.configuration"})
public class PhotoSpinConfiguration extends WebMvcConfigurerAdapter{
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry){		
		resourceHandlerRegistry.addResourceHandler("/resources/**").addResourceLocations("/resources/");		
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
		configurer.enable();
	}
	
	@Bean
	public InternalResourceViewResolver jspResourceResolver(){
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setViewClass(JstlView.class);
		internalResourceViewResolver.setPrefix("/WEB-INF/views/");
		internalResourceViewResolver.setSuffix(".jsp");
		return internalResourceViewResolver;
	}
	@Bean
	public CommonsMultipartResolver getMultipartResolver(){
		return new CommonsMultipartResolver();
	}
	
	@Bean(name = "messageSource")
	public ReloadableResourceBundleMessageSource getMessageSource(){
		ReloadableResourceBundleMessageSource reloadableResource = new ReloadableResourceBundleMessageSource();
		reloadableResource.setBasename("classpath:messages");
		reloadableResource.setDefaultEncoding("UTF-8");
		return reloadableResource;
	}
	
	
}
