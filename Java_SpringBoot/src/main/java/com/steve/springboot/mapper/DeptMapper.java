package com.steve.springboot.mapper;

import com.steve.springboot.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: STEVE
 * @Description: Mapper - Dept
 * @Mapper : 表示本类是一个 MyBatis 的 Mapper
 * @since: 2024/1/5
 */
@Mapper
@Repository
public interface DeptMapper {

    // 获取所有部门信息
    List<Dept> getDepts();

    // 通过deptNo获得部门
    Dept getDept(@Param("deptNo") long id);

}
