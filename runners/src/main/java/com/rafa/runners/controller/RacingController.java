package com.rafa.runners.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rafa.runners.dto.RacingDTO;
import com.rafa.runners.mapper.RacingMapper;
import com.rafa.runners.model.Racing;
import com.rafa.runners.service.RacingService;

@RestController
@RequestMapping(value = "/racing")
public class RacingController {

	@Autowired
	RacingService racingService;
	
	@Autowired
	RacingMapper racingMapper;
	
	@PostMapping
	public RacingDTO create(@RequestBody RacingDTO racingDTO) {
		Racing racing = racingMapper.mapToModel(racingDTO);
		racingService.create(racing);
		return racingMapper.mapToDTO(racing);
	}
	
	@GetMapping
	public void GetClasification(@RequestParam(value = "IdRacing", required = false) Integer IdRacing) {
		racingService.getClasificationClub(IdRacing);
	}
	
	@GetMapping(value = "/runner/{IdRacing}")
	public void GetClasificationRunner(@PathVariable Integer IdRacing,@RequestParam(value = "year", required = false) Integer year) {
		racingService.getClasificationRunners(year, IdRacing);
	}
	
}
