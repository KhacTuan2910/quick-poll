package com.javaspring.quickpoll.repository;

import org.springframework.data.repository.CrudRepository;

import com.javaspring.quickpoll.domain.Option;

public interface OptionRepository extends CrudRepository<Option, Long>{

}
