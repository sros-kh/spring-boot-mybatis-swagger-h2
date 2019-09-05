package com.sros.springboot.controller;

import com.sros.springboot.model.Position;
import com.sros.springboot.services.IPositionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/position")
public class PositionController {

	private final IPositionService positionService;

	public PositionController(IPositionService positionService) {
		this.positionService = positionService;
	}

	@PostMapping("/find-one/{id}")
	public ResponseEntity findOne(@PathVariable long id) {
		return new ResponseEntity<>(this.positionService.findOne(id), HttpStatus.OK);
	}

	@PostMapping("/find-all")
	public ResponseEntity findAll() {
		return new ResponseEntity<>(this.positionService.findAll(), HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity create(@RequestBody Position position) {
		return new ResponseEntity<>(this.positionService.create(position), HttpStatus.OK);
	}

	@PostMapping("/delete{id}")
	public ResponseEntity delete(@PathVariable long id) {
		this.positionService.delete(id);
		return new ResponseEntity(HttpStatus.OK);
	}
}
