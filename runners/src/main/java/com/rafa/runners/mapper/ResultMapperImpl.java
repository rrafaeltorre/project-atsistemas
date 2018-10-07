package com.rafa.runners.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.rafa.runners.dto.ResultDTO;
import com.rafa.runners.model.Result;
import com.rafa.runners.service.ResultService;

@Component
public class ResultMapperImpl implements ResultMapper {
	
	@Autowired
	ResultService resultService;
	
	@Override
	public Result mapToModel(ResultDTO dto) {
		Result result = new Result();
		result.setSeconds(dto.getSeconds());
		return result;
	}

	@Override
	public ResultDTO mapToDTO(Result model) {
		ResultDTO resultDTO = new ResultDTO();
		resultDTO.setIdResult(model.getIdResult());
		resultDTO.setIdRunner(model.getRunner().getIdRunner());
		resultDTO.setSeconds(model.getSeconds());
		return resultDTO;
	}

	@Override
	public List<ResultDTO> mapToDTO(List<Result> models) {
		return models.parallelStream().map(this::mapToDTO)
				.collect(Collectors.toList());
	}

}
