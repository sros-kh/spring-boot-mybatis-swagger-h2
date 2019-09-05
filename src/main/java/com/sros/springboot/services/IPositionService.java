package com.sros.springboot.services;

import com.sros.springboot.model.dto.Position;

import java.util.List;

public interface IPositionService {

	Position findOne(long id);

	List<Position> findAll();

	Position create(Position position);

	void delete(long id);

}
