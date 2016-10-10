package com.epam.jpatraining.map.domain;

import java.time.LocalDate;

import javax.persistence.PrePersist;

import com.epam.jpatraining.context.UserContext;

public class AuditListener {

	@PrePersist
	public void prePersist(Auditable auditable) {
		auditable.getAudit().setCreated(LocalDate.now()); 
		auditable.getAudit().setCreatedBy(UserContext.getUser());
	}
}
