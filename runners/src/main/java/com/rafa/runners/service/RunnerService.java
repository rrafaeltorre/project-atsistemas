package com.rafa.runners.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import com.rafa.runners.model.Runner;

public interface RunnerService {
	
	Runner create(Runner runner, Integer idClub);
	
	Optional <Runner> findById(Integer id);
	
	void update(Runner runnerToUpdate);

	void delete(Integer idRunner);
	
	List<Runner> findAll(Pageable of);
	
	List<String> getRunners(Integer y1, Integer y2, Integer IdRacing);
}
