package com.rafa.runners.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Result {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idResult;
	
	private Integer seconds;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Runner runner;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Racing racing;
	
	public void setIdResult(Integer idResult) {
		this.idResult = idResult;
	}
	
	public Integer getIdResult() {
		return this.idResult;
	}
	
	public void setRacing(Racing racing) {
		this.racing = racing;
	}
	
	public Racing getRacing() {
		return this.racing;
	}
	
	public void setRunner(Runner runner) {
		this.runner = runner;
	}
	public Runner getRunner() {
		return this.runner;
	}
	
	public Integer getSeconds() {
		return seconds;
	}

	public void setSeconds(Integer seconds) {
		this.seconds = seconds;
	}
}