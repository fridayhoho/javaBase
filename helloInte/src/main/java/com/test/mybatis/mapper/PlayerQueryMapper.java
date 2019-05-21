package com.test.mybatis.mapper;

import com.test.mybatis.pojo.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface PlayerQueryMapper {
    @Select(" SELECT * FROM test_players WHERE region_id = #{id}")
    public User findUserById(int id) throws Exception;

    @Select(" SELECT region_id, name FROM test_players WHERE region_id > 13")
    @Results(
            value = {
                    @Result(property = "region_id", column = "region_id"),
                    @Result(property = "name", column = "name"),
            }
    )
    public List<Map> doSomeSummary() throws Exception;
}
