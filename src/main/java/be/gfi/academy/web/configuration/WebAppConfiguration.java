package be.gfi.academy.web.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import be.gfi.academy.service.AcademyService;
import be.gfi.academy.service.BaseAcademyServiceImpl;

/**
 * Web Application configuration.
 * 
 * @author Gunther Verhemeldonck
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "be.gfi.academy.web")
@PropertySource("classpath:application.properties")
public class WebAppConfiguration extends WebMvcConfigurerAdapter {

	@Value("${driverClassName}")
	private String driverClassName;

	@Value("${databaseUrl}")
	private String databaseUrl;

	@Value("${databaseUsername}")
	private String databaseUsername;

	@Value("${databasePassword}")
	private String databasePassword;

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("home");
		registry.addViewController("/home").setViewName("home");
		registry.addViewController("/hello").setViewName("hello");
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/403").setViewName("403");
	}

	@Bean
	public AcademyService academyService() {
		return new BaseAcademyServiceImpl();
	}

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(driverClassName);
		ds.setUrl(databaseUrl);
		ds.setUsername(databaseUsername);
		ds.setPassword(databasePassword);
		return ds;
	}
}