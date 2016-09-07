package be.gfi.academy.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import be.gfi.academy.dao.AcademyDAO;
import be.gfi.academy.model.Message;

public class BaseAcademyServiceImpl implements AcademyService {

	@Autowired
	private AcademyDAO dao;

	protected void setAcademyDAO(AcademyDAO dao) {
		this.dao = dao;
	}

	@Override
	public String getGreeting() {
		final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return "Hello GIRLS! Server time is currently set at " + sdf.format(getNow());
	}

	protected Date getNow() {
		return new Date();
	}

	@Override
	public List<Message> listMessages(String token) {
		final List<Message> messages = dao.listMessages();
		final List<Message> result = new ArrayList<Message>();

		for (Message msg : messages) {
			if (token == null || msg.getMessage().indexOf(token) != -1) {
				result.add(msg);
			}
		}
		return result;
	}
}
