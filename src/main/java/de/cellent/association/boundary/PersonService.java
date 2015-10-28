package de.cellent.association.boundary;

import javax.ejb.Remote;

import de.cellent.association.entity.Person;

@Remote
public interface PersonService {

	public Person createPerson(Person person);
	public Person findPersonById(long id);
}
