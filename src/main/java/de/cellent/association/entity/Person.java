package de.cellent.association.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * 
drop table address ;
drop table Department ;
drop table job ;
drop table Person ;

 * @author mbohnen
 *
 */
@Entity
public class Person implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@Fetch(FetchMode.SUBSELECT)
//	private List<Address> addresses = new ArrayList<Address>();
	private Set<Address> addresses = new HashSet<Address>();

	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@Fetch(FetchMode.SUBSELECT)
//	private List<Job> jobs = new ArrayList<Job>();
	private Set<Job> jobs = new HashSet<Job>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	public Set<Job> getJobs() {
		return jobs;
	}

	public void setJobs(Set<Job> jobs) {
		this.jobs = jobs;
	}

	

}
