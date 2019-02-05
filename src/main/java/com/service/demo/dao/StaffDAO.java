package com.service.demo.dao;

import com.service.demo.dao.provider.StaffProvider;
import com.service.demo.model.Staff;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffDAO {

	@InsertProvider(type = StaffProvider.class, method = "create")
	void create(Staff staff);

	@SelectProvider(type = StaffProvider.class, method = "findAll")
	@Results({
			@Result(column = "pos_id", property = "position.id"),
			@Result(column = "position", property = "position.position")
	}
	)
	List<Staff> findAll();

	@SelectProvider(type = StaffProvider.class, method = "findOne")
	@Results({
			@Result(column = "pos_id", property = "position.id"),
			@Result(column = "position", property = "position.position")
	})
	Staff findOne(@Param("id") long id);

	@UpdateProvider(type = StaffProvider.class, method = "update")
	void update(Staff staff);

	@DeleteProvider(type = StaffProvider.class, method = "delete")
	void delete(@Param("id") long id);
}
