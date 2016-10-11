package com.epam.jpatraining.map.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Entity
@EntityListeners(AuditListener.class)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "command_type")
public abstract class PathCommandEntity implements Auditable {

	@Id
	@GeneratedValue
	private long id;
	
	
//	@Enumerated(EnumType.STRING)
//	@Column(nullable = false)
//	private SVGPathCommandType type;
	
	@Column(nullable = false)
	private BigDecimal positionX;
	
	@Column(nullable = false)
	private BigDecimal positionY;

	@Embedded
	private Audit audit = new Audit();
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
//	public SVGPathCommandType getType() {
//		return type;
//	}
//	public void setType(SVGPathCommandType type) {
//		this.type = type;
//	}
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
	public Audit getAudit() {
		return audit;
	}
	public void setAudit(Audit audit) {
		this.audit = audit;
	}
	
	
	
	
	
}
