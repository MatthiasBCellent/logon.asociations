package de.cellent.test.assocation.boundary;

import java.util.List;
import java.util.Set;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import de.cellent.association.boundary.PersonService;
import de.cellent.association.entity.Address;
import de.cellent.association.entity.Department;
import de.cellent.association.entity.Job;
import de.cellent.association.entity.Person;

public class PersonServiceTest {

	private static InitialContext ctx;
	private static PersonService service;

	public static void main(String[] args) {
		PersonServiceTest.init();
		
		PersonServiceTest test = new PersonServiceTest();
//		test.testCreatePerson();
		test.testFindPersonById();
	}
	
	public void testCreatePerson() {
		Address a1 = new Address();
		Address a2 = new Address();
		
		Department d = new Department();
		
		Job j1 = new Job();
		j1.setDepartment(d);
		d.getJobs().add(j1);
		
		Job j2 = new Job();
		j2.setDepartment(d);
		d.getJobs().add(j2);
		
		Person p = new Person();
		p.getAddresses().add(a1);
		a1.setPerson(p);
		
		p.getAddresses().add(a2);
		a2.setPerson(p);
		
		p.getJobs().add(j1);
		j1.setPerson(p);
		
		p.getJobs().add(j2);
		j2.setPerson(p);
		
		service.createPerson(p);
	}
	
	public void testFindPersonById() {
		Person p = service.findPersonById(18l);
		System.out.println("Person ID: " + p.getId());
		
		// using List
//		List<Job> jobs = p.getJobs();
//		for (Job job : jobs) {
//			System.out.println("Job-ID : "+ job.getId());
//			System.out.println("Department-Id: " + job.getDepartment().getId());
//		}
//		
//		List<Address> addresses = p.getAddresses();
//		for (Address address : addresses) {
//			System.out.println("Address-ID: " + address.getId());
//			
//		}
		
		// using Set
		Set<Job> jobs = p.getJobs();
		for (Job job : jobs) {
			System.out.println("Job-ID : "+ job.getId());
			System.out.println("Department-Id: " + job.getDepartment().getId());
		}
		
		Set<Address> addresses = p.getAddresses();
		for (Address address : addresses) {
			System.out.println("Address-ID: " + address.getId());	
		}
	}
	
	public static void init() {
		try {
			ctx = new InitialContext();
			service = (PersonService) ctx.lookup("/association-0.0.1-SNAPSHOT/PersonServiceBean!de.cellent.association.boundary.PersonService");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
