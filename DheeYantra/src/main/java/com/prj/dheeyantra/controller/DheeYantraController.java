package com.prj.dheeyantra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prj.dheeyantra.model.DheeYantra;
import com.prj.dheeyantra.service.DheeYantraService;

@RestController
@RequestMapping("/notes")
public class DheeYantraController {

	@Autowired
	DheeYantraService service;
	
	@PostMapping()
	public ResponseEntity<DheeYantra> addDheeYantra(@RequestBody DheeYantra dheeYantra){
		return new ResponseEntity<DheeYantra>(service.addDheeYantra(dheeYantra),HttpStatus.CREATED);
	}
	
	@GetMapping()
	public List<DheeYantra> getAllDheeYantra(){
		return service.getAllDheeYantra();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DheeYantra> getDheeYantraByID(@PathVariable("id") int id){
		return new ResponseEntity<DheeYantra>(service.getDheeYantraById(id),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteDheeYantraById(@PathVariable("id") int id){
		service.deleteDheeYantraById(id);
    	return new ResponseEntity<String>("deleted Suceesfully",HttpStatus.OK);
	}
}
