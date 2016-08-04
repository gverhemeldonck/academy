package be.gfi.academy.service;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseAcademyServiceImpl implements AcademyService {

	@Override
	public String getGreeting() {
		final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return "Hello there! Server time is currently set at " + sdf.format(getNow());
	}

	protected Date getNow() {
		return new Date();
	}
}
