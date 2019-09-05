package com.sros.springboot.model.dao.provider;

import com.sros.springboot.model.dto.Staff;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class StaffProvider {

    public String findOne(@Param("id") long id) {
        return new SQL() {
            {
                SELECT("id, name, gender, address, pos_id, (SELECT position FROM positions " +
                        "WHERE pos_id = id) as position, active, photo");
                FROM("staffs");
                WHERE("id = #{id}");
            }
        }.toString();
    }

    public String findAll() {
        return new SQL() {
            {
                SELECT("id, name, gender, address, pos_id, (SELECT position FROM positions " +
                        "WHERE pos_id = id) as position, active, photo");
                FROM("staffs");
                ORDER_BY("id ASC");
            }
        }.toString();
    }

    public String create() {
        return new SQL() {
            {
                INSERT_INTO("staffs");
                VALUES("name", "#{name}");
                VALUES("gender", "#{gender}");
                VALUES("address", "#{address}");
                VALUES("active", "#{active}");
                VALUES("photo", "#{photo}");
                VALUES("pos_id", "#{position.id}");
            }
        }.toString();
    }

    public String update(Staff staff) {
        return new SQL() {
            {
                UPDATE("staffs");
                SET("name = #{name}");
                SET("gender = #{gender}");
                SET("address = #{address}");
                SET("active = #{active}");
                SET("photo = #{photo}");
                SET("pos_id = #{position.id}");
                WHERE("id = #{id}");
            }
        }.toString();
    }

    public String delete(@Param("id") long id) {
        return new SQL() {
            {
                DELETE_FROM("staffs");
                WHERE("id = #{id}");
            }
        }.toString();
    }
}
