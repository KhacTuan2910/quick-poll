package com.javaspring.quickpoll.repository;

import org.springframework.data.repository.CrudRepository;

import com.javaspring.quickpoll.domain.Poll;

public interface PollRepository extends CrudRepository<Poll, Long> {

}
