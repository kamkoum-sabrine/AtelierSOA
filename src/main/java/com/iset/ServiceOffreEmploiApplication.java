package com.iset;

import com.iset.dao.OffreRepository;
import com.iset.entities.Offre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServiceOffreEmploiApplication implements CommandLineRunner {
	@Autowired
	OffreRepository offreRepository;

	public static void main(String[] args) {
		SpringApplication.run(ServiceOffreEmploiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		offreRepository.save(new Offre("Web Design", "informatique", "AXA", 2, "France"));
		offreRepository.save(new Offre("Developpeur", "informatique", "Talys", 3, "Tunisie"));
		offreRepository.save(new Offre("Architecte", "informatique", "SIS", 2, "Allemagne"));

	}
}