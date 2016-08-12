package be.gfi.academy.web.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import be.gfi.academy.dao.AcademyDAO;
import be.gfi.academy.dao.BaseAcademyDAOImpl;
import be.gfi.academy.service.AcademyService;
import be.gfi.academy.service.BaseAcademyServiceImpl;

@Configuration
@Profile(value = { "production" })
public class AcademyAppConfiguration {

	@Bean
	public AcademyService academyService() {
		return new BaseAcademyServiceImpl();
	}

	@Bean
	public AcademyDAO academyDAO() {
		return new BaseAcademyDAOImpl();
	}
}
