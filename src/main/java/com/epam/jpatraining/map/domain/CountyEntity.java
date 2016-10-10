package com.epam.jpatraining.map.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "county")
public class CountyEntity {


	@Id
	private String id;
	
	@Column(nullable = false)	
	private String name;
	
	@Column(nullable = false)
	private String seat;
	
	@Column(nullable = false)
	private String color;
	
	@Column(nullable = false)
	private int population;
	
	@Column(nullable = false)
	private int size;

	@OneToMany(cascade = CascadeType.PERSIST)
	private List<PathCommandEntity> pathCommands;
	
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

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public List<PathCommandEntity> getPathCommands() {
		return pathCommands;
	}

	public void setPathCommands(List<PathCommandEntity> pathCommands) {
		this.pathCommands = pathCommands;
	}
	
	
	
	
}