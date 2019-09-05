package com.sros.springboot.services.impl;

import com.sros.springboot.repos.StaffDao;
import com.sros.springboot.model.Staff;
import com.sros.springboot.services.IStaffService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements IStaffService {

	private StaffDao staffDao;

	public StaffServiceImpl(StaffDao staffDao) {
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
