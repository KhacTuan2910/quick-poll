package com.javaspring.quickpoll.repository;

import org.springframework.data.repository.CrudRepository;

import com.javaspring.quickpoll.domain.Vote;

public interface VoteRepository extends CrudRepository<Vote, Long> {
	
}
