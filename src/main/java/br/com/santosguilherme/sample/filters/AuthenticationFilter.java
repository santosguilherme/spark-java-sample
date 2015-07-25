package br.com.santosguilherme.sample.filters;

import static spark.Spark.before;
//import static spark.Spark.halt;

/**
 * 
 * @author santosguilherme
 *
 */
public class AuthenticationFilter {

	public AuthenticationFilter() {
		before("/api/*", (request, response) -> {
			// ... check if authenticated
			//halt(401, "401 - Unauthorized");
		});
	}
}
