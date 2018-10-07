package com.rafa.runners.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rafa.runners.model.Club;
import com.rafa.runners.model.Runner;
import com.rafa.runners.dao.RunnerDAO;

@Service
public class RunnerServiceImpl implements RunnerService {
	
	@Autowired
	RunnerDAO dao;
	
	@Autowired
	ClubService clubService;

	@Override
	public List<Runner> findAll(Pageable pagination) {
		return dao.findAll(pagination).getContent();
	}
	
	@Override
	public Runner create(Runner runner, Integer idClub) {
		Club club = clubService.findById(idClub).get();
		runner.setClub(club);
		return dao.save(runner);
	}

	@Override
	public Optional<Runner> findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public void update(Runner runnerToUpdate) {
		dao.saveAndFlush(runnerToUpdate);
	}

	@Override
	public void delete(Integer idRunner) {
		dao.deleteById(idRunner);
	}

	@Override
	public List<String> getRunners(Integer y1, Integer y2, Integer IdRacing) {
		return dao.findByYearBetween(y1, y2, IdRacing);
	}

	
	
	
}
