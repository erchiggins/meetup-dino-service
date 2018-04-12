package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Dinosaur;
import com.example.repository.DinoDao;

@Service 
public class DinoService {
	
	@Autowired 
	private DinoDao dinoDao;
	
	public List<Dinosaur> getAllDinos(){
		return dinoDao.findAll();
	}
	
	public void addDino(Dinosaur dino){
		dinoDao.save(dino);
	}
}