package com.telugu.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.telugu.demo.model.Alien;

public interface AlienRepo  extends JpaRepository<Alien, Integer>{

}
