package com.rafa.runners.mapper;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rafa.runners.dto.RacingDTO;
import com.rafa.runners.model.Racing;
import com.rafa.runners.service.RacingService;

@Component
public class RacingMapperImpl implements RacingMapper {
	
	@Autowired
	RacingService racingService;
	
	@Override
	public Racing mapToModel(RacingDTO dto) {
		Racing racing = new Racing();
		racing.setIdRacing(dto.getIdRacing());
		racing.setName(dto.getName());
		racing.setDate(racing.StringToDate(dto.getDate()));
		return racing;
	}

	@Override
	public RacingDTO mapToDTO(Racing model) {
		RacingDTO racingDTO = new RacingDTO();
		racingDTO.setIdRacing(model.getIdRacing());
		racingDTO.setName(model.getName());
		racingDTO.setDate(model.DateToString(model.getDate()));
		return racingDTO;
	}

	@Override
	public List<RacingDTO> mapToDTO(List<Racing> models) {
		return models.parallelStream().map(this::mapToDTO)
				.collect(Collectors.toList());
	}

}
