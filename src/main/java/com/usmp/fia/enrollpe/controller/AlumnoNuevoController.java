package com.usmp.fia.enrollpe.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.usmp.fia.enrollpe.models.entitys.AlumnoNuevo;

import com.usmp.fia.enrollpe.models.services.IAlumnoNuevoService;



@Controller
@SessionAttributes("solicitudes_alumnos")
public class AlumnoNuevoController {

	@Autowired
	private IAlumnoNuevoService alumnoNuevoService;
	
	@RequestMapping(value="/listarSolicitudes",method = RequestMethod.GET)
	public String lista(Model model) {
		model.addAttribute("titulo", "Listado de Solicitudes");
		model.addAttribute("alumnosNuevos", alumnoNuevoService.findAll());
		return "listarSolicitudes";
	}
	
	@RequestMapping(value="/confirmarSolicitud",method = RequestMethod.GET)
	public String confirmar(Model model) {
		model.addAttribute("titulo", "Solicitud enviada");
		model.addAttribute("alumnosNuevos", alumnoNuevoService.findAll());
		return "confirmacion";
	}
	
	
	@RequestMapping(value="/formSolicitud")
	public String crear(Map<String, Object> model) {
		
		AlumnoNuevo alumnoNuevo=new AlumnoNuevo();
		model.put("alumnoNuevo", alumnoNuevo);
		model.put("titulo", "Formulario del Alumno Nuevo");
		
		return "formSolicitud";
	}
	
	@RequestMapping(value="/formSolicitud",method = RequestMethod.POST)
	public String guardar(@Valid AlumnoNuevo alumnoNuevo, BindingResult result, Model model, SessionStatus status) {
		
		if(result.hasErrors()) {
		model.addAttribute("titulo", "formulario de alumno nuevo");	
		return "formSolicitud";
		}
		alumnoNuevoService.save(alumnoNuevo);
		status.setComplete();
		return "redirect:/confirmarSolicitud";
	}
	
	@RequestMapping(value="/formSolicitud/{id}")
	public String editar(@PathVariable(value="id")Long id,Map<String, Object>model) {
		
		AlumnoNuevo alumnoNuevo=null;
		
		if(id>0) {
			alumnoNuevo=alumnoNuevoService.findOne(id);
		}else {
			return "redirect:/listarSolicitudes";
		}
		model.put("alumnoNuevo",alumnoNuevo);
		model.put("titulo", "editar alumno");
		return "formSolicitud";
	}
	
	@GetMapping(value="/verDatos/{id}")
	public String ver(@PathVariable(value = "id") Long id,Map<String, Object> model, 
		RedirectAttributes flash) {
		AlumnoNuevo alumnoNuevo=alumnoNuevoService.findOne(id);
		
		if(alumnoNuevo==null) {
			flash.addFlashAttribute("error", "El alumno no existe en la base de datos");
			return "redirect:/listarSolicitudes";
		}
		model.put("alumnoNuevo", alumnoNuevo);
		model.put("titulo", "Detalle del Alumno: " + alumnoNuevo.getNomAluN());
		return "verDatos";
	}

	
	//-----------------------PAGINA PRINCIPAL
	
	@GetMapping({"/enrollpe","paginaPrincipal",""})
	public String PaginaP(Model model) {
		model.addAttribute("nomPagina", "ENROLLPE");
		model.addAttribute("titulo1", "BIENVENIDO A ENROLLPE");
		model.addAttribute("titulo2", "Con nosotros te será mucho más facil hacer tu trámite de matrícula.");
		model.addAttribute("pregunta", "¿Te gustaría empezar? Elige una de las opciones!");
		return"paginaPrincipal";
	}
	
	@GetMapping("/nosotros")
	public String Nosotros(Model model) {

		return"paginaNosotros";
	}
	
	
	
}
