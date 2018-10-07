package com.rafa.runners.service;

import java.util.List;
import java.util.Optional;

import com.rafa.runners.model.Racing;

public interface RacingService  {
	
	Racing create(Racing racing);
	
	Optional <Racing> findById(Integer id);
	
	List<Integer> getScore(Integer IdRacing);
	
	void getClasificationClub(Integer IdRacing);
	
	void getClasificationRunners(Integer year, Integer IdRacing);
}
