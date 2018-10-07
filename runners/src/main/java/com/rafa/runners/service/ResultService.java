package com.rafa.runners.service;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Pageable;
import com.rafa.runners.model.Result;


public interface ResultService {

	Result create(Result result, Integer idRacing, Integer idRunners);
	
	Optional <Result> findById(Integer id);
	
	List<Result> findAll(Pageable of);

}
