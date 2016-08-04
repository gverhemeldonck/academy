package be.gfi.academy.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings("unchecked")
public class BaseAcademyDAOImpl implements AcademyDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<String> listMessages() {
		Query query = entityManager.createQuery("from Message");
		return query.getResultList();
	}
}