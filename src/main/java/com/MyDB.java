package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Component
public class MyDB {
    @Autowired
    private JdbcTemplate jdbcTemplate;
   // private List<Animal> animals = new ArrayList<Animal>();
    public MyDB()
    {
    }
    public void newAnimal(String name, int cost)
    {
        jdbcTemplate.batchUpdate("insert into animals(name, cost) values ('"+name+"', "+cost+")");
    }
    public void deleteAnimal(String name)
    {
        jdbcTemplate.batchUpdate("DELETE FROM animals WHERE name ='"+name+"'");
    }
    public List<Animal> getAllAnimals()
    {
        List<Animal> animals = new ArrayList<Animal>();
        jdbcTemplate.query("SELECT name, cost FROM animals", (rs, rowNum) -> new Animal(rs.getInt("cost"), rs.getString("name")))
                .forEach(animal-> animals.add(animal));
        return animals;
    }
}
