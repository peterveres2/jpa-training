package com.epam.jpatraining.map.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.epam.jpatraining.common.SVGPathCommandType;

@Entity(name = "pathCommand")
public class PathCommandEntity {

	@Id
	@GeneratedValue
	private long id;
	
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private SVGPathCommandType type;
	
	@Column(nullable = false)
	private BigDecimal positionX;
	
	@Column(nullable = false)
	private BigDecimal positionY;

	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public SVGPathCommandType getType() {
		return type;
	}
	public void setType(SVGPathCommandType type) {
		this.type = type;
	}
	public BigDecimal getPositionX() {
		return positionX;
	}
	public void setPositionX(BigDecimal positionX) {
		this.positionX = positionX;
	}
	public BigDecimal getPositionY() {
		return positionY;
	}
	public void setPositionY(BigDecimal positionY) {
		this.positionY = positionY;
	}
	
	
	
}
