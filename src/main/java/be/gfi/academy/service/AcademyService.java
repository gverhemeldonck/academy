package be.gfi.academy.service;

import java.util.List;

import be.gfi.academy.model.Message;

public interface AcademyService {

	String getGreeting();

	/**
	 * List and optionally filters messages.
	 * 
	 * @param token
	 *            <code>null</code> or a {@link String} token.
	 * @return non-null list of {@link Message} instances
	 */
	List<Message> listMessages(String token);

}
