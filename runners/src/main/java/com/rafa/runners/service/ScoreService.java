package com.rafa.runners.service;

import java.util.Optional;
import com.rafa.runners.model.Score;

public interface ScoreService {

	Optional <Score> findById(Integer id);

}
