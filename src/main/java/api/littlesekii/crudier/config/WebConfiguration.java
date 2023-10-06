package api.littlesekii.crudier.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

	private String port = "5173";
	
	@Override
	public void addCorsMappings(CorsRegistry cors) {
		cors.addMapping("/**").allowedOrigins("http://localhost:" + port)
			.allowedMethods("GET", "POST", "PUT", "DELETE");
	}
}
