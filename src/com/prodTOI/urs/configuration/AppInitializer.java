package com.prodTOI.urs.configuration;

import javax.servlet.Filter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {

		return new Class[] { AppConfig.class, HibernateConfig.class };
	}

	@Override
	protected String[] getServletMappings() {

		return new String[] { "/" };
	}
	
	@Override
    protected Filter[] getServletFilters() {
     Filter [] singleton = { new CORSFilter()};
     return singleton;
    }

}
