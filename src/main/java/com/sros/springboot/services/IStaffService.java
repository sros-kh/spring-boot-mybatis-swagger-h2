package com.sros.springboot.services;

import com.sros.springboot.model.dto.Staff;

import java.util.List;

public interface IStaffService {

	Staff findOne(long id);

	List<Staff> findAll();

	Staff create(Staff staff);

	void delete(long id);
}
