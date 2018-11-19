package br.com.augusto.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.augusto.models.Empresas;
import br.com.augusto.models.Usuario;
import br.com.augusto.repository.UsuarioRepository;
import br.com.augusto.security.TokenAuthenticationService;

@RestController
@RequestMapping("/users")
//Access denied for user 'root	'@'localhost' (using password: YES)
public class UserController {
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@RequestMapping("/usuarios")
	@ResponseBody
	public Empresas getUsers(ServletRequest request) {
		String authentication = TokenAuthenticationService.getAuthenticatioTeste((HttpServletRequest) request);
		System.out.println(authentication);
		Usuario user = usuarioRepository.findByLogin(authentication);
		if(user != null) {
			return user.getEmpresas();
		}else {
			return null;
		}
		//return "{\"users\":[{\"name\":\"Lucas\", \"country\":\"Brazil\"}," +
		  //         "{\"name\":\"Jackie\",\"country\":\"China\"}]}";
	}

}
