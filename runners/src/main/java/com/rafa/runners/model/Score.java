package com.rafa.runners.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Score {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idScore;
	
	private Integer position;
	private Integer score;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Racing racing;
}
