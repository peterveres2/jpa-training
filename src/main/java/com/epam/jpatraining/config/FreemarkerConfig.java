package com.epam.jpatraining.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FreemarkerConfig {

	@Bean
	public freemarker.template.Configuration freemarkerConfiguration() {
		freemarker.template.Configuration configuration = new freemarker.template.Configuration();
		configuration.setClassForTemplateLoading(this.getClass(), "/template");
		return configuration;

	}
}
