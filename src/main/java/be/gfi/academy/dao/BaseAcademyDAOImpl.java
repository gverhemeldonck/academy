package be.gfi.academy.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import be.gfi.academy.model.Message;

@Repository
@SuppressWarnings("unchecked")
public class BaseAcademyDAOImpl implements AcademyDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Message> listMessages() {
		Query query = entityManager.createQuery("from Message");
		return query.getResultList();
	}
}