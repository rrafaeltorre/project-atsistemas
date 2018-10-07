package com.rafa.runners.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.rafa.runners.model.Racing;

@Repository
public interface RacingDAO extends JpaRepository<Racing, Integer> {
	
	@Query(value = "SELECT score.score FROM score where score.racing_id_racing = ?1", nativeQuery=true)
	List<Integer> findScoreByIdRacing(Integer IdRacing);
}