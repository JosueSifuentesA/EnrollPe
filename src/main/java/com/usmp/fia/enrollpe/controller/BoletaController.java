package com.usmp.fia.enrollpe.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.usmp.fia.enrollpe.models.entitys.Boleta;
import com.usmp.fia.enrollpe.models.entitys.Pagador;
import com.usmp.fia.enrollpe.models.services.IPagadorService;

@Controller
@RequestMapping("/boleta")
@SessionAttributes("boleta")
public class BoletaController {

	@Autowired
	private IPagadorService pagadorService;
	
	@GetMapping("/formPago/{pagadorId}")
	public String crear(@PathVariable(value="pagadorId") Long pagadorId,
						Map<String, Object> model,
						RedirectAttributes flash) {
		
		Pagador pagador= pagadorService.findOne(pagadorId);
		
		if(pagador==null) {
			
			flash.addAttribute("error", "El alumno no existe en la base de datos");
			return "redirect:/listarPagadores";
		}
		
		Boleta boleta =new Boleta();
		
		boleta.setPagador(pagador);
		model.put("boleta", boleta);
		model.put("titulo", "Crear Boleta");
		return "/boleta/formPago";
	}
}
