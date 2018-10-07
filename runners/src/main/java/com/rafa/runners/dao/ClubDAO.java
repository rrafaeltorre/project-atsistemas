package com.rafa.runners.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.rafa.runners.model.Club;

@Repository
public interface ClubDAO extends JpaRepository<Club, Integer> {
	
	@Query(value="select club.name from club \n" + 
			"inner join runner on id_club = club_id_club \n" + 
			"inner join result on id_runner = runner_id_runner \n" + 
			"inner join racing on result.racing_id_racing = id_racing\n" + 
			"where result.racing_id_racing = 8 \n" + 
			"order by seconds\n" + 
			"limit 10;", nativeQuery=true)
	List<String> getClubByIdRacing(Integer IdRacing);

}