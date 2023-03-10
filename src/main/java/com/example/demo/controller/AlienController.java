package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

import com.example.demo.dao.AlienRepo;
import com.example.demo.model.Alien;



@Controller

public class AlienController {
	
	@Autowired
	AlienRepo repo;

	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@ResponseBody
	@RequestMapping("/addAlien")
		public String addAlien(Alien alien) {
			repo.save(alien);
			return "Succesfully Added";
		}
	
	@RequestMapping("/getAlien")
		public ModelAndView getAlien(@RequestParam int aid){
			ModelAndView mv =new ModelAndView("showAlien.jsp");
			Alien alien =repo.findById(aid).orElse(new Alien()) ;
			mv.addObject(alien);
			System.out.println(repo.findByTech("java"));
			return mv;
		}


}
	