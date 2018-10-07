package com.rafa.runners.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafa.runners.model.Score;

public interface ScoreDAO extends JpaRepository<Score, Integer> {

}
