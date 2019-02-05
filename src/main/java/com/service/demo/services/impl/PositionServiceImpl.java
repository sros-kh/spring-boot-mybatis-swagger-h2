package com.service.demo.services.impl;

import com.service.demo.dao.PositionDAO;
import com.service.demo.model.Position;
import com.service.demo.services.IPositionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements IPositionService {

	private PositionDAO positionDao;

	public PositionServiceImpl(PositionDAO positionDao) {
		this.positionDao = positionDao;
	}

	@Override
	public Position findOne(long id) {
		return this.positionDao.findOne(id);
	}

	@Override
	public List<Position> findAll() {
		return positionDao.findAll();
	}

	@Override
	public Position create(Position position) {
		if (this.positionDao.findOne(position.getId()) == null)
			this.positionDao.create(position);
		else
			this.positionDao.update(position);

		return this.positionDao.findOne(position.getId());
	}

	@Override
	public void delete(long id) {
		this.positionDao.delete(id);
	}
}
