package com.javaspring.quickpoll.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

@Entity
public class Poll {
	@Id
	@GeneratedValue
	@Column(name = "POLL_ID")
	private Long id;
	
	@Column(name = "POLL_QUESTION")
	private String question;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "POLL_ID")
	@OrderBy
	private Set<Option> options;
	
	public Long getId() {
		return id;
	}
}
