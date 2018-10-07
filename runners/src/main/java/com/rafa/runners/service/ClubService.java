package com.rafa.runners.service;

import java.util.List;
import java.util.Optional;
import com.rafa.runners.model.Club;

public interface ClubService {
	
	Club create (Club club);
	
	Optional <Club> findById(Integer id);
	
	List <String> findClubByIdRacing(Integer IdRacing);
}
