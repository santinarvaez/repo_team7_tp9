package ar.edu.unju.fi.tp4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;
import ar.edu.unju.fi.tp4.model.Beneficio;
import ar.edu.unju.fi.tp4.model.Cliente;
import ar.edu.unju.fi.tp4.service.IBeneficioService;
import ch.qos.logback.classic.Logger;

@Controller
public class BeneficioController {

	@Autowired
	private Beneficio beneficio;
	
	@Autowired
	private Cliente cliente;
	
	@Autowired
	@Qualifier("beneficioMysql")
	private IBeneficioService beneficioService;
	
	@GetMapping("/beneficio/buscar")
	//LOGGER.info
	public String buscarBeneficio(@RequestParam(name = "id")Long id, Model model,@ModelAttribute(name="beneficio")Beneficio beneficio,@ModelAttribute(name = "cliente")Cliente cliente) {
		Optional <Beneficio> beneficioEncontrado = beneficioService.getBeneficioPorId(id);
		String mensaje = "";
		if(beneficioEncontrado != null) {
			beneficioService.agregarBeneficioEncontrado(beneficioEncontrado.get());
		}
		//
		else {
			mensaje = "Beneficio inexistente";
			model.addAttribute("mensaje",mensaje);
		}
		model.addAttribute("beneficiosEncontrados", beneficioService.obtenerBeneficiosEncontrados());
		model.addAttribute("beneficio", this.beneficio);
		return "nuevocliente";
	}
	
	@GetMapping("/beneficio/quitar/{id}")
	public ModelAndView quitarBeneficio(@PathVariable(value = "id")Long id) {
		//LOGGER.info();
		ModelAndView model = new ModelAndView("nuevocliente");
		beneficioService.quitarBeneficioLista(id);
		model.addObject("cliente", cliente);
		model.addObject("beneficio", beneficio);
		model.addObject("beneficiosEncontrados", beneficioService.obtenerBeneficiosEncontrados());
		return model;
	}
}