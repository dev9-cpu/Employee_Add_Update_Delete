package com.addingEmploye.springboot.backend;

import com.addingEmploye.springboot.backend.repository.employeereprository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}

	@Autowired
	private employeereprository employeereprository;
	@Override
	public void run(String... args) throws Exception {
//		employemodel employe1 = new employemodel();
//		employe1.setFirstName("Devyansh");
//		employe1.setLastName("Abi");
//		employe1.setEmailId("abc@gmail.com");
//		employeereprository.save(employe1);
//
//		employemodel employe2 = new employemodel();
//		employe2.setFirstName("ansh");
//		employe2.setLastName("bi");
//		employe2.setEmailId("dbc@gmail.com");
//		employeereprository.save(employe2);
//
//		employemodel employe3 = new employemodel();
//		employe3.setFirstName("Subham");
//		employe3.setLastName("nice");
//		employe3.setEmailId("nice@gmail.com");
//		employeereprository.save(employe3);
//	}
	}
}
