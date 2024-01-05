package com.steve.springboot.controller;

import com.steve.springboot.mapper.DeptMapper;
import com.steve.springboot.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: STEVE
 * @Description: Controller - Dept
 * @since: 2024/1/5
 */
@RestController
public class DeptController {

    @Autowired
    DeptMapper deptMapper;

    // 查询全部部门
    @GetMapping("/getDepts")
    public List<Dept> getDepartments(){
        return deptMapper.getDepts();
    }

    // 查询全部部门
    @GetMapping("/getDept/{id}")
    public Dept getDepartment(@PathVariable("id") Integer id){
        return deptMapper.getDept(id);
    }

}
