package api.littlesekii.crudier.resources.app.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AppController {
	
	@Value("${api.name}")
	private String name;
	
	@Value("${api.version}")
	private String version;
	
	@GetMapping
	public String apiStatus() {
		return "🟢 Crudier API is currently running.";
	}
	
	@GetMapping("/api")
	public String apiDetails() {
		return String.format("%s %s", name, version);
	}
	
	@GetMapping("/api/name")
	public String apiName() {
		return name;
	}
	
	@GetMapping("/api/version")
	public String apiVersion() {
		return version;
	}
}
