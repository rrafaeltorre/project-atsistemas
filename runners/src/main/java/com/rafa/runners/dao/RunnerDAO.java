package com.rafa.runners.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.rafa.runners.model.Runner;

@Repository
public interface RunnerDAO extends JpaRepository<Runner, Integer> {
	
	Page<Runner> findAll(Pageable pageable);
	
	@Query(value = "select runner.name from runner \n" + 
			"inner join result on id_runner = runner_id_runner \n" + 
			"inner join racing on result.racing_id_racing = id_racing\n" + 
			"where result.racing_id_racing = ?3 \n" + 
			"and runner.year between ?1 and ?2\n" + 
			"order by seconds\n" + 
			"limit 10;", nativeQuery=true)
	List <String> findByYearBetween(Integer year1, Integer year2, Integer IdRacing);
}