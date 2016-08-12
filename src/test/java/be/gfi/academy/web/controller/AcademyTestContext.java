package be.gfi.academy.web.controller;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import be.gfi.academy.service.AcademyService;

@Profile("test")
@Configuration
public class AcademyTestContext {

	@Bean
	public AcademyService academyService() {
		return Mockito.mock(AcademyService.class);
	}
}
