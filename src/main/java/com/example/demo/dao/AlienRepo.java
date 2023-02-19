package com.example.demo.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Alien;
import java.util.List;



public interface AlienRepo extends JpaRepository <Alien,Integer>
{
    
    List<Alien> findByTech(String tech);
}
