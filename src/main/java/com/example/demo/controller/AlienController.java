package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.example.demo.dao.AlienRepo;
import com.example.demo.model.Alien;



@RestController

public class AlienController {
	
	@Autowired
	AlienRepo repo;

	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	
	// @PostMapping(path="/alien",consumes = {"application/json"})
	@PostMapping("/alien")
		public Alien addAlien(@RequestBody Alien alien) {
			repo.save(alien);
			return alien;
		}
	
	// @RequestMapping("/getAlien")
	// 	public ModelAndView getAlien(@RequestParam int aid){
	// 		ModelAndView mv =new ModelAndView("showAlien.jsp");
	// 		Alien alien =repo.findById(aid).orElse(new Alien()) ;
	// 		mv.addObject(alien);
	// 		System.out.println(repo.findByTech("java"));
	// 		return mv;
	// 	}


	
	@GetMapping("/aliens")
	
	public List<Alien> getAllAliens(){
		return repo.findAll();
	}

	@GetMapping(path="/alien/{aid}")
	
	public Optional<Alien> getAlien(@PathVariable("aid") int aid){
		return repo.findById(aid);
	}

	@DeleteMapping("/alien/{aid}")
	public String deleteAlien(@PathVariable int aid){
		Alien a = repo.getOne(aid);
		repo.delete(a);
		return "deleted";
	}

	@PutMapping(path = "/alien",consumes = {"application/json"})
	public Alien SaveOrUpdateAlien(@RequestBody Alien alien){
		repo.save(alien);
		return alien;
	}

}
