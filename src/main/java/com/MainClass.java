package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Collections;

@SpringBootApplication
public class MainClass implements CommandLineRunner {
//public class MainClass {
    public static void main(String[] args) {
        SpringApplication.run(MainClass.class);
    }
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS animals(name VARCHAR(255), cost INTEGER)  ");
     //   jdbcTemplate.batchUpdate("insert into animals values ('Name',100)");
    }
}
