package com.rafa.runners.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Runner {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idRunner;
	
	private String name;
	private Integer year;
	
	@ManyToOne
	private Club club;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "runner")
	private List<Result> results = new ArrayList<>();
	
	
	public void setClub(Club club) {
		this.club = club;
	}
	
	public Club getClub() {
		return this.club;
	}
	
	public void setIdRunner(Integer idRunner) {
		this.idRunner = idRunner;
	}
	
	public Integer getIdRunner() {
		return this.idRunner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}	
}
