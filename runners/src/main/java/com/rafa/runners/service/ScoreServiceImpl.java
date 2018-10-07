package com.rafa.runners.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import com.rafa.runners.dao.ScoreDAO;
import com.rafa.runners.model.Score;

public class ScoreServiceImpl implements ScoreService {
	
	@Autowired
	ScoreDAO dao;
	
	@Override
	public Optional<Score> findById(Integer id) {
		return dao.findById(id);
	}

}
