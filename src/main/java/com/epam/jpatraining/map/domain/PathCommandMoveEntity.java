package com.epam.jpatraining.map.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@DiscriminatorValue("M")
@Entity(name = "pathCommandMove")
public class PathCommandMoveEntity extends PathCommandEntity {

}
