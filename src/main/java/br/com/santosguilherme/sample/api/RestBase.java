package br.com.santosguilherme.sample.api;

import br.com.santosguilherme.sample.filters.AuthenticationFilter;

/**
 * 
 * @author santosguilherme
 *
 */
public abstract class RestBase {

	protected static final String API_URL = "/api";
	protected static final String PUBLIC_URL = "/public";
	
	public RestBase() {
		new AuthenticationFilter();
	}
}
