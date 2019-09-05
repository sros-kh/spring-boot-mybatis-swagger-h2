package com.sros.springboot.controller;

import com.sros.springboot.model.dto.Position;
import com.sros.springboot.services.IPositionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/positions")
public class PositionController {

	private final IPositionService positionService;

	public PositionController(IPositionService positionService) {
		this.positionService = positionService;
	}

	@GetMapping("/find-one/{id}")
	public ResponseEntity findOne(@PathVariable long id) {
		return new ResponseEntity<>(this.positionService.findOne(id), HttpStatus.OK);
	}

	@GetMapping("/find-all")
	public ResponseEntity findAll() {
		return new ResponseEntity<>(this.positionService.findAll(), HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity create(@RequestBody Position position) {
		return new ResponseEntity<>(this.positionService.create(position), HttpStatus.OK);
	}

	@DeleteMapping("/delete{id}")
	public ResponseEntity delete(@PathVariable long id) {
		this.positionService.delete(id);
		return new ResponseEntity(HttpStatus.OK);
	}
}
