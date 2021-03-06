package com.javaspring.quickpoll.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Vote {
	@Id
	@GeneratedValue
	@Column(name = "VOTE_ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "OPTION_ID")
	private Option option;
}
