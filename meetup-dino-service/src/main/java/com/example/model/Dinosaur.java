package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("dinosaur")
@Scope("prototype")
@Entity
@Table(name="DINOSAUR")
public class Dinosaur {
	
	public Dinosaur(String name, String species) {
		super();
		this.name = name;
		this.species = species;
	}
	public Dinosaur() {
		super();
	}
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="dinoSequence")
	@SequenceGenerator(allocationSize=1,name="dinoSequence",sequenceName="SQ_DINO_PK")
	@Column(name="DINO_ID")
	private int id;
	@Column(name="DINO_NAME")
	private String name;
	@Column(name="DINO_SPECIES")
	private String species;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	@Override
	public String toString() {
		return "Dinosaur [id=" + id + ", name=" + name + ", species=" + species + "]";
	}

}
