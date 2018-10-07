package com.rafa.runners.model;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Racing {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idRacing;
	
	private String name;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "racing")
	private List<Result> results = new ArrayList<>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "racing")
	private List<Score> scores = new ArrayList<>();

	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Date getDate() {
		return this.date;
	}
	
	public void setIdRacing(Integer idRacing){
		this.idRacing = idRacing;
	}
	
	public Integer getIdRacing() {
		return this.idRacing;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String DateToString(Date date) {
		Format formatter = new SimpleDateFormat("yyyy/MM/dd");
		String dateString = formatter.format(date);
		return dateString;
	}
	
	public Date StringToDate(String dateString) {
		try {
			date = new SimpleDateFormat("yyyy/MM/dd").parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		return date;
		
	}
}