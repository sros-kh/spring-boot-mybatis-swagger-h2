package com.sros.springboot.dao;

import com.sros.springboot.model.Position;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionDAO {

    @Select("SELECT * FROM positions")
    List<Position> findAll();

    @Select("SELECT * FROM positions WHERE id = #{id}")
    Position findOne(@Param("id") long id);

    @Insert("INSERT INTO positions (id, position) VALUES(#{id}, #{position})")
    void create(Position position);

    @Delete("DELETE FROM positions WHERE id = #{id}")
    void delete(@Param("id") long id);

    @Update("UPDATE positions SET position = #{position} WHERE id = #{id}")
    void update(Position position);
}
