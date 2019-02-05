package com.service.demo.services.impl;

import com.service.demo.dao.StaffDAO;
import com.service.demo.model.Staff;
import com.service.demo.services.IStaffService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements IStaffService {

	private StaffDAO staffDao;

	public StaffServiceImpl(StaffDAO staffDao) {
		this.staffDao = staffDao;
	}

	public Staff findOne(long id) {
		return staffDao.findOne(id);
	}

	@Override
	public List<Staff> findAll() {
		return this.staffDao.findAll();
	}

	@Override
	public Staff create(Staff staff) {
		Staff st = this.staffDao.findOne(staff.getId());
		if (st == null) this.staffDao.create(staff);
		else this.staffDao.update(staff);
		return this.staffDao.findOne(staff.getId());
	}

	@Override
	public void delete(long id) {
		this.staffDao.delete(id);
	}
}
