package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements ApplicationRunner {
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		User user1= new User();
		user1.setName("Mehdi");
		User user2= new User();
		user2.setName("Khosro khar dar");
		User user3= new User();
		user3.setName("yasanmin");

		userRepository.save(user1);
		userRepository.save(user2);
		userRepository.save(user3);

		for (User user : userRepository.findAll()) {
			System.out.println(user.getName() + " is saved!");
		}
	}
}
