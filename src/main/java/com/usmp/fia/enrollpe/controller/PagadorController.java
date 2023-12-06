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

import com.usmp.fia.enrollpe.models.entitys.Pagador;
import com.usmp.fia.enrollpe.models.services.IPagadorService;
@Controller
@SessionAttributes("pagador")
public class PagadorController {

	@Autowired
	private IPagadorService pagadorService;
	
	@RequestMapping(value="/listarPagadores",method = RequestMethod.GET)
	public String lista(Model model) {
		model.addAttribute("titulo", "Listado de Pagadores");
		model.addAttribute("pagadores", pagadorService.findAll());
		return "listarPagos";
	}
	
	@RequestMapping(value="/confirmarPago",method = RequestMethod.GET)
	public String confirmarP(Model model) {
		model.addAttribute("titulo", "Pago confirmado");
		return "confirmacionPago";
	}
	
	@RequestMapping(value="/formPago")
	public String crear(Map<String, Object> model) {
		
		Pagador pagador=new Pagador();
		model.put("pagador", pagador);
		model.put("titulo", "Formulario del Pago");
		
		return "formPago";
	}
	
	@RequestMapping(value="/formPago",method = RequestMethod.POST)
	public String guardar(@Valid Pagador pagador, BindingResult result, Model model, SessionStatus status) {
		
		if(result.hasErrors()) {
		model.addAttribute("titulo", "formulario de pago");	
		return "formPago";
		}
		pagadorService.save(pagador);
		status.setComplete();
		return "redirect:confirmarPago";
	}
	
	@GetMapping(value="/ver/{id}")
	public String ver(@PathVariable(value = "id") Long id,Map<String, Object> model, 
						RedirectAttributes flash) {
		Pagador pagador= pagadorService.findOne(id);
		
		if(pagador==null) {
			flash.addFlashAttribute("error", "El pagador no existe en la base de datos");
			return "redirect:/listarPagadores";
		}
		model.put("pagador", pagador);
		model.put("titulo", "Detalle del Pagador: " + pagador.getCorreoAlumno());
		return "ver";
	}
	    
	
	
}
