package be.gfi.academy.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import be.gfi.academy.dao.AcademyDAO;

public class BaseAcademyServiceImpl implements AcademyService {

	@Autowired
	private AcademyDAO dao;

	@Override
	public String getGreeting() {
		final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return "Hello GUYS! Server time is currently set at " + sdf.format(getNow());
	}

	protected Date getNow() {
		return new Date();
	}

	@Override
	public List<String> listMessages() {
		return dao.listMessages();
	}
}
