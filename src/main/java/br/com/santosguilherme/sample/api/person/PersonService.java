package br.com.santosguilherme.sample.api.person;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import br.com.santosguilherme.sample.api.RestBase;
import br.com.santosguilherme.sample.model.Person;
import spark.Spark;

/**
 * 
 * @author santosguilherme
 *
 */
public class PersonService extends RestBase {

	public static final String PERSON_PATH = "/person";
	public static final String PUBLIC_PERSON_PATH = PUBLIC_URL + PERSON_PATH;
	public static final String API_PERSON_PATH = API_URL + PERSON_PATH;

	public PersonService() {
		this.create();
		this.update();

		this.searchById();
		this.searchByName();
		this.searchAll();

		this.delete();
	}

	private void create(){
		post(PUBLIC_PERSON_PATH, "application/json", (request, response) -> {
			return new Gson().fromJson(request.body(), Person.class);
		}, new Gson()::toJson);
	}

	private void update(){
		put(API_PERSON_PATH, "application/json", (request, response) -> {
			return new Gson().fromJson(request.body(), Person.class);
		}, new Gson()::toJson);
	}

	private void searchById() {
		get(API_PERSON_PATH + "/:id", (request, response) -> {
			return new Person(request.params(":id"), "Guilherme Santos");
		}, new Gson()::toJson);
	}

	private void searchByName() {
		get(API_PERSON_PATH + "/name/:name", (request, response) -> {
			Person person = new Person();
			person.setName(request.params(":name"));
			return person;
		}, new Gson()::toJson);
	}
	
	private void searchAll() {
		get(API_PERSON_PATH, (request, response) -> {
			List<Person> persons = new ArrayList<>(3);
			
			persons.add(new Person("Guilherme"));
			persons.add(new Person("Santos"));
			persons.add(new Person("Guilherme Santos"));
			
			return persons;
		}, new Gson()::toJson);
	}

	private void delete(){
		Spark.delete(API_PERSON_PATH + "/:id", (request, response) -> {
			return "Person with id '" + request.params(":id") + "' deleted";
		});
	}
}