

package com.telugu.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.telugu.demo.dao.AlienRepo;
import com.telugu.demo.model.Alien;

@ RestController
public class AlienController {
	@Autowired
	AlienRepo repo;
	
     @RequestMapping("/")
	public String home()
	{
		return "home.jsp";
	}
     
    @DeleteMapping("/alien/{aid}")
    
    public  String deleteAlien(@PathVariable int aid)
    {
    	Alien a= repo.getOne(aid);
    	repo.delete(a);
    	return "deleted";
     
    }
     @PostMapping("/alien")
    public Alien addAlien(Alien alien)
     {
    	 repo.save(alien);
    	 return alien;
     }
                   
     @GetMapping("/alien")
     public List<Alien> getAlien() {
    	 return repo.findAll();
     }
     @PutMapping("/alien")
     public Alien  saveOrupdateAlien(Alien alien)
      {
     	 repo.save(alien);
     	 return alien;
     
      }
     
     @RequestMapping("/alien/{aid}")
     @ResponseBody
     public Optional<Alien> getAlien(@PathVariable("aid") int aid) {
    	 return repo.findById(aid);
     }
     
     
     
}
