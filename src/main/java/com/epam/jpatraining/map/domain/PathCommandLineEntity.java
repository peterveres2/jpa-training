package com.epam.jpatraining.map.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@DiscriminatorValue("L")
@Entity(name = "pathCommandLine")
public class PathCommandLineEntity extends PathCommandEntity {

	public boolean relative;

	public boolean isRelative() {
		return relative;
	}

	public void setRelative(boolean relative) {
		this.relative = relative;
	}

	@Override
	public String toString() {
		return (relative ? "l" : "L") + " " + getPositionX() + " " + getPositionY();
	}
	
	
}
