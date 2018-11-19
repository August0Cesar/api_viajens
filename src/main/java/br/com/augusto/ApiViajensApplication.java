package br.com.augusto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories("br.com.augusto.repository")
public class ApiViajensApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		System.out.println(new BCryptPasswordEncoder().encode("254513"));
		SpringApplication.run(ApiViajensApplication.class, args);
	}
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	
}
