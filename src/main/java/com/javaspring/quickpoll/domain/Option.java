package com.javaspring.quickpoll.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Option {
	
	@Id
	@GeneratedValue
	@Column(name = "OPTION_ID")
	private Long id;
	
	@Column(name = "OPTION_VALUE")
	private String value;
}
