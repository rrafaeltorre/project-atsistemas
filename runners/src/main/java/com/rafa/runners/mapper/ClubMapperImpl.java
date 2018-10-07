package com.rafa.runners.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rafa.runners.dto.ClubDTO;
import com.rafa.runners.model.Club;
import com.rafa.runners.service.ClubService;

@Component
public class ClubMapperImpl implements ClubMapper {

	@Autowired
	ClubService clubService;
	
	@Override
	public Club mapToModel(ClubDTO dto) {
		Club club = new Club();
		club.setName(dto.getName());
		return club;
	}

	@Override
	public ClubDTO mapToDTO(Club model) {
		ClubDTO clubDTO = new ClubDTO();
		clubDTO.setIdClub(model.getId());
		clubDTO.setName(model.getName());
		return clubDTO;
	}

	@Override
	public List<ClubDTO> mapToDTO(List<Club> models) {
		return models.parallelStream().map(this::mapToDTO)
				.collect(Collectors.toList());
	}

}
