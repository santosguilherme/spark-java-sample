package br.com.santosguilherme.sample.model;

import java.io.Serializable;
import java.util.UUID;

public class Person implements Serializable {

	private static final long serialVersionUID = 8677513625829768571L;

	private String id;
	private String name;

	public Person() {
		this("");
	}
	
	public Person(String name) {
		this(UUID.randomUUID().toString(), name);
	}
	
	public Person(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
