package br.com.augusto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
	@GetMapping("/template")
	public String template() {
		
		return "template";
	}
	@GetMapping("/detalhesViajem")
	public String detalhesViajem() {
		
		return "detalhesViajem";
	}
	@GetMapping("/historicoPagamentos")
	public String historicoPagamentos() {
		
		return "historicoPagamentos";
	}
}
