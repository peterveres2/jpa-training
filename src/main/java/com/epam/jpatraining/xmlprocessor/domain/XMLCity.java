package com.epam.jpatraining.xmlprocessor.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "city")
public class XMLCity {

	private String id;
	private String name;
	private String color;
	
	
	private List<XMLPathCommand> pathCommands;
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
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	@XmlElement(name = "command")
	public List<XMLPathCommand> getPathCommands() {
		return pathCommands;
	}
	public void setPathCommands(List<XMLPathCommand> pathCommands) {
		this.pathCommands = pathCommands;
	}
	
	
	
}
