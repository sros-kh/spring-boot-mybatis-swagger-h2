package com.service.demo.services;

import com.service.demo.model.Position;

import java.util.List;

public interface IPositionService {

	Position findOne(long id);

	List<Position> findAll();

	Position create(Position position);

	void delete(long id);

}
