package com.rafa.runners.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafa.runners.dto.ClubDTO;
import com.rafa.runners.mapper.ClubMapper;
import com.rafa.runners.model.Club;
import com.rafa.runners.service.ClubService;

@RestController
@RequestMapping(value = "/club")
public class ClubController {
	
	@Autowired
	ClubService clubService;
	
	@Autowired
	ClubMapper clubMapper;
	
	@PostMapping
	public ClubDTO create(@RequestBody ClubDTO clubDTO) {
		Club club = clubMapper.mapToModel(clubDTO);
		clubService.create(club);
		return clubMapper.mapToDTO(club);
	}
}
