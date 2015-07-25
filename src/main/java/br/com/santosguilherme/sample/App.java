package br.com.santosguilherme.sample;

import static spark.SparkBase.port;
import static spark.SparkBase.threadPool;

import br.com.santosguilherme.sample.api.PersonService;;

public class App {

	private final int maxThreads = 8;
	private final int port = 8080;
	
	public App() {
		port(this.port);
		threadPool(this.maxThreads);
	}
	
	public static void main(String[] args) {
		new App();
			
		new PersonService();
	}
}
