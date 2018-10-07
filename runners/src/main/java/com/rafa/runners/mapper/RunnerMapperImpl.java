package com.rafa.runners.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rafa.runners.dto.RunnerDTO;
import com.rafa.runners.model.Runner;
import com.rafa.runners.service.RunnerService;

@Component
public class RunnerMapperImpl implements RunnerMapper {

	@Autowired
	RunnerService runnerService;
	
	@Override
	public Runner mapToModel(RunnerDTO dto) {
		Runner runner =  new Runner();
		runner.setIdRunner(dto.getIdRunner());
		runner.setName(dto.getName());
		runner.setYear(dto.getYear());
		return runner;
	}

	@Override
	public RunnerDTO mapToDTO(Runner model) {
		RunnerDTO runnerDTO = new RunnerDTO();
		runnerDTO.setIdRunner(model.getIdRunner());
		runnerDTO.setName(model.getName());
		runnerDTO.setYear(model.getYear());
		return runnerDTO;
	}

	@Override
	public List<RunnerDTO> mapToDTO(List<Runner> models) {
		return models.parallelStream().map(this::mapToDTO)
				.collect(Collectors.toList());
	}

}
