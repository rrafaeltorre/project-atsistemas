package com.rafa.runners.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rafa.runners.dto.RunnerDTO;
import com.rafa.runners.mapper.RunnerMapper;
import com.rafa.runners.model.Runner;
import com.rafa.runners.service.RunnerService;

@RestController
@RequestMapping(value = "/runner")
public class RunnerController {
	
	@Autowired
	RunnerService runnerService;
	
	@Autowired
	RunnerMapper runnerMapper;

	@GetMapping
	public List<RunnerDTO> getRunners(
			@RequestParam(defaultValue = "0", value = "page", required = false) Integer page,
			@RequestParam(defaultValue = "3", value = "size", required = false) Integer size){
		List<Runner> runners = runnerService.findAll(PageRequest.of(page, size));
		return runnerMapper.mapToDTO(runners);
	}
	
	@GetMapping(value = "/{idRunner}")
	public RunnerDTO getRunner(@PathVariable Integer idRunner) {
		Runner runner =  runnerService.findById(idRunner).get();
		return runnerMapper.mapToDTO(runner);
	}
	
	@PostMapping(value = "/{idClub}")
	public RunnerDTO create(@RequestBody RunnerDTO runnerDTO, @PathVariable Integer idClub) {
		Runner runner = runnerMapper.mapToModel(runnerDTO);
		runnerService.create(runner, idClub);
		return runnerMapper.mapToDTO(runner);	
	}
	
	@PutMapping(value = "/{idRunner}")
	public RunnerDTO update(@RequestBody RunnerDTO runnerDTO, @PathVariable Integer idRunner) {
		runnerDTO.setIdRunner(idRunner);
		Runner runner = runnerMapper.mapToModel(runnerDTO);
		runnerService.update(runner);
		return runnerMapper.mapToDTO(runner);
	}
	
	@DeleteMapping(value = "/{idRunner}")
	public void delete(@PathVariable Integer idRunner) {
		runnerService.delete(idRunner);
		
	}
}
