package com.usmp.fia.enrollpe.controller;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;
import com.usmp.fia.enrollpe.models.entitys.Login;
import com.usmp.fia.enrollpe.models.services.LoginService;


@Controller
public class LoginController {
    
	@Autowired
	private LoginService userService;
	
    // Logueo de admin
	@GetMapping("/ingresarAdmin")
    public ModelAndView login() {
		ModelAndView mav = new ModelAndView("ingresarAdministrador");
		mav.addObject("user", new Login());
		return mav;
	}
	
	@GetMapping("/administrador")
	public String paginaPrincipalAdmin() {
		
		return "paginaPrincipalAdministrador";
	}

	@PostMapping("/ingresarAdmin")
	public String login(@Valid @ModelAttribute("user") Login user, BindingResult result,Model model) {

		Login oauthUser = userService.login(user.getUsername(), user.getPassword());

		
		if (result.hasErrors()) {
			System.out.print("Existieron errores en el login");
			return "redirect:/ingresarAdmin";
		}
		
		System.out.print(oauthUser);
		if (Objects.nonNull(oauthUser)){
			return "redirect:/administrador";

		}else {
			return "redirect:/ingresarAdmin";
		}
		
		
	}

	@RequestMapping(value = { "/logout" }, method = RequestMethod.POST)
	public String logoutDo(HttpServletRequest request, HttpServletResponse response) {

		return "redirect:/ingresarAdmin";
	}
	
	//logeo de alumno
	
	@GetMapping("/ingresarAlumno")
    public ModelAndView loginAlumno() {
		ModelAndView mavA = new ModelAndView("frmRegistrarAlumno");
		mavA.addObject("user", new Login());
		return mavA;
	}
	
	@GetMapping("/paginaAlumno")
	public String paginaPrincipalAlumno() {
		
		return "paginaPrincipalAlum";
	}
	
	@PostMapping("/ingresarAlumno")
	public String loginA(@Valid @ModelAttribute("user") Login user, BindingResult result,Model model) {

		Login oauthUser = userService.login(user.getUsername(), user.getPassword());

		
		if (result.hasErrors()) {
			System.out.print("Existieron errores en el login");
			return "redirect:/ingresarAlumno";
		}
		
		System.out.print(oauthUser);
		if (Objects.nonNull(oauthUser)){
			return "redirect:/paginaAlumno";

		}else {
			return "redirect:/ingresarAlumno";
		}
	
	}
	
	@RequestMapping(value = { "/logoutA" }, method = RequestMethod.POST)
	public String logoutDoA(HttpServletRequest request, HttpServletResponse response) {

		return "redirect:/ingresarAlumno";
	}
}
