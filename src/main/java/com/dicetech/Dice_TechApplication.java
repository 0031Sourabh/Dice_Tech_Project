package com.dicetech;

import com.dicetech.api.entity.User;
import com.dicetech.api.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class Dice_TechApplication {
	
    @Autowired
    private UserRepository repository;
    

    @PostConstruct
    public void initUsers() {
        List<User> users = Stream.of(
                new User(101, "dice", "pass", "dicetech@gmail.com")
        ).collect(Collectors.toList());
        repository.saveAll(users);
    }
    
   

    public static void main(String[] args) {
        SpringApplication.run(Dice_TechApplication.class, args);
    }

}
