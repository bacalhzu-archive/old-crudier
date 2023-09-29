package api.littlesekii.crudier.util;

import java.net.URI;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class Utils {
	
	public static boolean notBlank(String str) { return str.trim() != ""; }
	
	public static boolean notNull(Object obj) {	return obj != null;	}
	
	public static boolean notValid(Object obj) { 
		return 
			!notBlank(String.valueOf(obj)) 
			|| !notNull(obj);
	}
	
	public static URI getCreatedEntityURILocation(Object item) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{obj}")
			.buildAndExpand(item).toUri();
		
		return uri;
	}
}
