package de.cellent.association.control;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import de.cellent.association.boundary.PersonService;
import de.cellent.association.entity.Person;

@Remote(PersonService.class)
@Stateless
public class PersonServiceBean implements PersonService {

	@PersistenceContext
	private EntityManager em;

	public Person createPerson(Person person) {
		this.em.persist(person);
		return person;
	}

	public Person findPersonById(long id) {
		TypedQuery<Person> query = em.createQuery("FROM Person AS p WHERE p.id =:id", Person.class);
		query.setParameter("id", id);
		Person p = query.getSingleResult();
		
		// the touch workaround
//		p.getJobs().get(0);
//		p.getAddresses().get(0);
		return p;
	}
}
