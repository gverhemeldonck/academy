package be.gfi.academy.web.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import be.gfi.academy.service.AcademyService;
import be.gfi.academy.web.configuration.AcademyWebAppConfiguration;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AcademyTestContext.class, AcademyWebAppConfiguration.class })
@WebAppConfiguration
public class TestHomeController {

	private MockMvc mockMvc;

	@Autowired
	private AcademyService mockService;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setUp() {
		// We have to reset our mock between tests to prevent leakage
		reset(mockService);

		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void listAll() throws Exception {

		when(mockService.listMessages()).thenReturn(Arrays.asList("Foo", "Bar"));

		mockMvc.perform(get("/hello")).andExpect(status().isOk()).andExpect(view().name("hello"))
				.andExpect(forwardedUrl("/WEB-INF/views/hello.jsp"))
				.andExpect(model().attribute("messages", hasSize(2)));

		verify(mockService, times(1)).listMessages();
	}
}
