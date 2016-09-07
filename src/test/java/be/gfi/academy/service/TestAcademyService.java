package be.gfi.academy.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import be.gfi.academy.dao.AcademyDAO;
import be.gfi.academy.model.Message;

/**
 * Test suite for {@link AcademyService}.
 * 
 * @author Gunther Verhemeldonck
 */
public class TestAcademyService {
	private BaseAcademyServiceImpl service;
	private AcademyDAO mockDao;

	@Before
	public void setup() {
		service = new BaseAcademyServiceImpl();
		mockDao = mock(AcademyDAO.class);
		service.setAcademyDAO(mockDao);

		fixture();
	}

	private void fixture() {
		final List<Message> messages = new ArrayList<Message>(2);
		messages.add(new Message(1, "Foo"));
		messages.add(new Message(2, "Bar"));
		when(mockDao.listMessages()).thenReturn(messages);
	}

	@Test
	public void filterMessages() {
		final List<Message> result = service.listMessages("ar");
		assertEquals(1, result.size());
		verify(mockDao).listMessages();
	}

	@Test
	public void allMessages() {
		final List<Message> result = service.listMessages(null);
		assertEquals(2, result.size());
		verify(mockDao).listMessages();
	}
}
