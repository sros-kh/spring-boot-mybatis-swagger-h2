package com.service.demo.services;

import com.service.demo.model.Staff;

import java.util.List;

public interface IStaffService {

	Staff findOne(long id);

	List<Staff> findAll();

	Staff create(Staff staff);

	void delete(long id);
}
