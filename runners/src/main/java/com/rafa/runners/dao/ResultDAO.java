package com.rafa.runners.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rafa.runners.model.Result;

@Repository
public interface ResultDAO extends JpaRepository<Result, Integer> {
	
	Page<Result> findAll(Pageable pageable);
	
}