package com.rafa.runners.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rafa.runners.dao.RacingDAO;
import com.rafa.runners.model.Racing;


@Service
public class RacingServiceImpl implements RacingService {
	
	@Autowired
	RacingDAO dao;
	
	@Autowired
	ClubService clubService;
	
	@Autowired
	RacingService racingService;
	
	@Autowired
	RunnerService runnerService;
	
	@Override
	public Racing create(Racing racing) {
		return dao.save(racing);
	}

	@Override
	public Optional<Racing> findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public List<Integer> getScore(Integer IdRacing) {
		return dao.findScoreByIdRacing(IdRacing);
	}
	
	@Override
	public void getClasificationClub(Integer IdRacing) {
	
		List<String> Clubs = clubService.findClubByIdRacing(IdRacing);
		List<Integer> Score = racingService.getScore(IdRacing);	
		
		PrintFileClubs(Clubs, Score);
	}


	@Override
	public void getClasificationRunners(Integer year, Integer IdRacing) {
		
		Integer year1 = 0;
		Integer year2 = 0;

		switch (year) {
		case 20:
			year1 = 1989;
			year2 = 1998;
			break;
		case 30:
			year1 = 1979;
			year2 = 1988;
			break;
		case 40:
			year1 = 1969;
			year2 = 1978;
		}
	
		List<String> runners =  runnerService.getRunners(year1, year2,IdRacing);	
		PrintFileRunners(runners, year);
		
	}
	
	public void PrintFileClubs(List<String> clubs, List<Integer> score) {

		try {
			File file = new File("/Clasificacion.txt");
			FileOutputStream fos;
			fos = new FileOutputStream(file);
			PrintWriter pw = new PrintWriter(fos);
			
			pw.println("   CLUB / PUNTUACIÓN");
			for (int i = 0; i < clubs.size(); i++) {
				pw.print(" "+clubs.get(i)+":"+score.get(i)+ " \n");
			}
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public void PrintFileRunners(List<String> runners, Integer year) {

		try {
			File file = new File("/CorredoresClasif.txt");
			FileOutputStream fos;
			fos = new FileOutputStream(file);
			PrintWriter pw = new PrintWriter(fos);
			
			pw.println("CLASIFICACIÓN MASTER"+year);
			for (int i = 0; i < runners.size(); i++) {
				pw.print(" "+(i+1)+"º "+runners.get(i)+ "\n");
			}
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
