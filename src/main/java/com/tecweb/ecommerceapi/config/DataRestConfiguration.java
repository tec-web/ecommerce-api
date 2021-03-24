package com.tecweb.ecommerceapi.config;

import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@Configuration
public class DataRestConfiguration implements RepositoryRestConfigurer {
	private EntityManager entityManager;
	
	@Value("${allowed.origins}")
	private String[] allowedOrigins;

	public DataRestConfiguration(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		exposeIds(config);
		config.getCorsRegistry().addMapping(config.getBasePath() + "/**").allowedOrigins(allowedOrigins);
	}

	private void exposeIds(RepositoryRestConfiguration config) {
		config.exposeIdsFor(entityManager.getMetamodel().getEntities().stream()
				.map(e -> e.getJavaType())
				.collect(Collectors.toList())
				.toArray(new Class[0]));		
	}
}
