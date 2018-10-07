package com.rafa.runners.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rafa.runners.model.Racing;
import com.rafa.runners.model.Result;
import com.rafa.runners.model.Runner;
import com.rafa.runners.dao.ResultDAO;

@Service
public class ResutServiceImpl implements ResultService {
	
	@Autowired
	ResultDAO dao;
	
	@Autowired
	RacingService racingService;
	
	@Autowired
	RunnerService runnerService;
	
	@Override
	public Result create(Result result, Integer idRacing, Integer idRunner) {
		Racing racing = racingService.findById(idRacing).get();
		Runner runner = runnerService.findById(idRunner).get();
		result.setRacing(racing);
		result.setRunner(runner);
		return dao.save(result);
	}

	@Override
	public Optional<Result> findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public List<Result> findAll(Pageable pagination) {
		return dao.findAll(pagination).getContent();
	}

}
