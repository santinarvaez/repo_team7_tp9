package ar.edu.unju.fi.tp4.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp4.model.Cuenta;
import ar.edu.unju.fi.tp4.service.IClienteService;
import ar.edu.unju.fi.tp4.service.ICuentaService;

@Controller
public class CuentaController {

	@Autowired
	private Cuenta cuenta;
	
	@Autowired
	@Qualifier("cuentaMysql")
	private ICuentaService cuentaService;
	
	@Autowired
	@Qualifier("clienteMysql")
	private IClienteService clienteService;
	
	@GetMapping("/cuenta/nueva")
	public String getCuentaNuevaPage(Model model) {
		model.addAttribute(cuenta);
		return "cuentaform";
	}
	
	@PostMapping("/cuenta/guardar")
	public ModelAndView guardarCuentaPage(@Valid @ModelAttribute("cuenta") Cuenta cuenta,BindingResult resultadoValidacion) {
		//ModelAndView model = new ModelAndView("lista-cuentas");
		ModelAndView modelView;
		if(resultadoValidacion.hasErrors()==true) {
			modelView = new ModelAndView("cuentaform");
			return modelView;
		}else {
			modelView = new ModelAndView("lista-cuentas");
			cuentaService.guardarCuenta(cuenta);
			modelView.addObject("cuentas", cuentaService.getCuentas());
			return modelView;
		}
	}
	
	@GetMapping("/cuenta/listado")
	public ModelAndView getListadoCuentaPage() {
		ModelAndView model = new ModelAndView("lista-cuentas");
		model.addObject("cuentas", cuentaService.getCuentas());
		return model;
	}
}
