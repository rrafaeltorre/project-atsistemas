package com.rafa.runners.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rafa.runners.dto.ResultDTO;
import com.rafa.runners.mapper.ResultMapper;
import com.rafa.runners.model.Result;
import com.rafa.runners.service.ResultService;

@RestController
@RequestMapping(value = "/result")
public class ResultController {
	
	@Autowired
	ResultService resultService;
	
	@Autowired
	ResultMapper resultMapper;
	
	@GetMapping
	public List <ResultDTO> getResults(
			@RequestParam(defaultValue = "0", value = "page", required = false) Integer page,
			@RequestParam(defaultValue = "3", value = "size", required = false) Integer size){
		List <Result> results = resultService.findAll(PageRequest.of(page,size));
		return resultMapper.mapToDTO(results);
	}
	
	@GetMapping(value = "/{idResult}")
	public ResultDTO getResult(@PathVariable Integer idResult) {
		Result result = resultService.findById(idResult).get();
		return resultMapper.mapToDTO(result);
	}
	
	@PostMapping(value = "/{idRacing}")
	public ResultDTO create(@RequestBody ResultDTO resultDTO, @PathVariable Integer idRacing) {
		Result result = resultMapper.mapToModel(resultDTO);
		resultService.create(result, idRacing,  resultDTO.getIdRunner());
		return resultMapper.mapToDTO(result);
	}
	
}
