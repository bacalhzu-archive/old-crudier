package api.littlesekii.crudier.util;

import java.net.URI;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class Utils {
	
	public static URI getCreatedEntityURILocation(Object item) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{obj}")
			.buildAndExpand(item).toUri();
		
		return uri;
	}
}
