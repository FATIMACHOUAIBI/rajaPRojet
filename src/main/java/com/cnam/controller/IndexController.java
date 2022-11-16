package com.cnam.controller;



import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cnam.demo.model.Utilisateur;
import com.cnam.demo.repository.UtilisateurRepository;



@Controller
public class IndexController {
	//creation instance unique de UtilisateurRepository
	@Autowired
	UtilisateurRepository utilisateurRepository;
/**
 * Cette methode permet de capter un GET de la page
 * http://localhost:9000/index
 * 
 * @param name
 * @param utilisateur
 * @param model
 * @return le nom de page html index
 */
@GetMapping("/")
public String home(Model model) {
	model.addAttribute("msg_accueil", String.format("Bienvenue sur notre site"));
	return "index";
}
@GetMapping("/index")
public String index(Model model) {
	model.addAttribute("msg_accueil", String.format("Bienvenue sur notre site"));
	Utilisateur unUtilisateur= new Utilisateur();
	unUtilisateur.setCgu(true);
	unUtilisateur.setDateNaissance(new Date());
	unUtilisateur.setNom("Bouhadoun");
	unUtilisateur.setPrenom("Kamel");
	unUtilisateur.setEmail("Kamel.bouhadoun+2@gmail.com");
	utilisateurRepository.save(unUtilisateur);
	return "index";
	//utilisateurRepository.save(unUtilisateur);
}
}
