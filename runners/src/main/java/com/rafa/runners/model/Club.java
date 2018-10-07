package com.rafa.runners.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Club {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idClub;
	
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "club")
	private List<Runner> runners = new ArrayList<>();

	public void setId(Integer idClub) {
		this.idClub = idClub;
	}
	
	public Integer getId() {
		return this.idClub;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
