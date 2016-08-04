package be.gfi.academy.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import be.gfi.academy.service.AcademyService;

@Controller
public class HomeController {

	private static final Logger _log = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private AcademyService service;

	@RequestMapping("/hello")
	public String greeting(Model model) {

		_log.info("Saying hello ...");

		model.addAttribute("message", service.getGreeting());
		return "hello";
	}

}
