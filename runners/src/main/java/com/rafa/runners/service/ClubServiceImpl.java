package com.rafa.runners.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rafa.runners.model.Club;
import com.rafa.runners.dao.ClubDAO;

@Service
public class ClubServiceImpl implements ClubService {
	
	@Autowired
	ClubDAO dao;

	@Override
	public Club create(Club club) {
		return dao.save(club);
	}

	@Override
	public Optional<Club> findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public List<String> findClubByIdRacing(Integer IdRacing) {
		return dao.getClubByIdRacing(IdRacing);
	}

}
