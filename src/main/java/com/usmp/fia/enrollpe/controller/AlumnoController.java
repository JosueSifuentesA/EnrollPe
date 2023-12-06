package com.usmp.fia.enrollpe.controller;

import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import com.usmp.fia.enrollpe.models.entitys.Alumno;
import com.usmp.fia.enrollpe.models.services.IAlumnoService;

@Controller
@SessionAttributes("alumno")
public class AlumnoController {
	
	@Autowired
	private IAlumnoService alumnoService;
	
	@RequestMapping(value="/listar",method = RequestMethod.GET)
	public String lista(Model model) {
		model.addAttribute("titulo", "Listado de Alumnos");
		model.addAttribute("alumnos", alumnoService.findAll());
		return "listarAlumnos";
	}
	
	@RequestMapping(value="/form")
	public String crear(Map<String, Object> model) {
		
		Alumno alumno=new Alumno();
		model.put("alumno", alumno);
		model.put("titulo", "Formulario del Alumno");
		
		return "formAsignarAlumno";
	}
	
	@RequestMapping(value="/form",method = RequestMethod.POST)
	public String guardar(@Valid Alumno alumno, BindingResult result, Model model, SessionStatus status) {
		
		if(result.hasErrors()) {
		model.addAttribute("titulo", "formulario de alumno");	
		return "formAsignarAlumno";
		}
		alumnoService.save(alumno);
		status.setComplete();
		return "redirect:listar";
	}
	
	@RequestMapping(value="/form/{id}")
	public String editar(@PathVariable(value="id")Long id,Map<String, Object>model) {
		
		Alumno alumno=null;
		
		if(id>0) {
			alumno=alumnoService.findOne(id);
		}else {
			return "redirect:/listar";
		}
		model.put("alumno",alumno);
		model.put("titulo", "editar alumno");
		return "formAsignarAlumno";
	}
	
	@RequestMapping(value="/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id")Long id) {
		if(id>0) {
			alumnoService.delete(id);
		}
		return"redirect:/listar";
	}
	
	
}
