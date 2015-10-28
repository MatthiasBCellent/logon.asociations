package de.cellent.association.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Department implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id;
	
	@OneToMany(mappedBy = "department")
	private List<Job> jobs = new ArrayList<Job>();
	

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}
}
