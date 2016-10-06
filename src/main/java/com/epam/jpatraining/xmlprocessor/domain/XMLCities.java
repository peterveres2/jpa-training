package com.epam.jpatraining.xmlprocessor.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "cities")
public class XMLCities {

    private List<XMLCity> cities = null;

    @XmlElement(name = "city")
	public List<XMLCity> getCities() {
		return cities;
	}


	public void setCities(List<XMLCity> cities) {
		this.cities = cities;
	}

	
}
