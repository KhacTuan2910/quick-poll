package com.javaspring.quickpoll.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.javaspring.quickpoll.domain.Poll;
import com.javaspring.quickpoll.repository.PollRepository;

@RestController
@RequestMapping("/polls")
public class PollController {
	@Autowired
	private PollRepository repository;
	
	@GetMapping
	public ResponseEntity<Iterable<Poll>> getAllPolls() {
		Iterable<Poll> allPolls = repository.findAll();
		return new ResponseEntity<>(allPolls, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> createPoll(@RequestBody Poll poll) {
		poll = repository.save(poll);
		
		// Set the location header for the newly created resource
		HttpHeaders responseHeaders = new HttpHeaders();
		URI newPollUri = ServletUriComponentsBuilder
												.fromCurrentRequest()
												.path("/{id}")
												.buildAndExpand(poll.getId())
												.toUri();
		responseHeaders.setLocation(newPollUri);
		
		return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
	}
	
	@GetMapping("/{pollId}")
	public ResponseEntity<?> getPoll(@PathVariable Long pollId) {
		// Save the entity
		Optional<Poll> pOpt = repository.findById(pollId);
		Poll p = pOpt.get();
		return new ResponseEntity<>(p, HttpStatus.OK);
	}
	
	@PutMapping("/{pollId}")
	public ResponseEntity<?> updatePoll(@RequestBody Poll poll, @PathVariable Long pollId) {
		// Save the entity
		Poll p = repository.save(poll);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{pollId}")
	public ResponseEntity<?> deletePoll(@PathVariable Long pollId) {
		repository.deleteById(pollId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
