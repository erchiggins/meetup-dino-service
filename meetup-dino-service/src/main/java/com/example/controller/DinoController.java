package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Dinosaur;
import com.example.model.Message;
import com.example.service.DinoService;

@RestController
@CrossOrigin
public class DinoController {
	
	@Autowired 
	private DinoService ds;
	
	@GetMapping("/all")
	public ResponseEntity<List<Dinosaur>> getAllDinosaures() {
		return new ResponseEntity<>(ds.getAllDinos(), HttpStatus.OK);
	}
	
	@PostMapping("/addDino")
	public ResponseEntity<Message> addDinosaur(@RequestBody Dinosaur dino) {

		ResponseEntity<Message> resp = null;
		try {
			ds.addDino(dino);
			resp = new ResponseEntity<>(new Message("DINO CREATED SUCCESSFULLY"), HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<>(new Message("FAILED TO CREATE DINO"), HttpStatus.BAD_REQUEST);
		}
		return resp;

	}
	
	@GetMapping("/test")
	public String getZuulTestMessage(){
		return "hello from T-REX SERVICE!";
	}

}
