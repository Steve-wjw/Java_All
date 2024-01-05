package com.steve.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Author: STEVE
 * @Description: JDBC 测试
 * @since: 2024/1/5
 */
@RestController
@RequestMapping("/jdbc")
public class JdbcController {

    /**
     * Spring Boot 默认提供了数据源，默认提供了 org.springframework.jdbc.core.JdbcTemplate
     * JdbcTemplate 中会自己注入数据源，用于简化 JDBC操作
     * 还能避免一些常见的错误,使用起来也不用再自己来关闭数据库连接
     */
    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * 查询dept表中所有数据
     * List 中的 1个 Map 对应数据库的 1行数据
     * Map 中的 key 对应数据库的字段名，value 对应数据库的字段值
     *
     * @return
     */
    @GetMapping("/list")
    public List<Map<String, Object>> deptList() {
        String sql = "select * from dept";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }

    /**
     * 新增一个部门
     *
     * @return
     */
    @GetMapping("/add")
    public String addUser() {
        //插入语句，注意时间问题
        String sql = "insert into dept(deptno, dname, db_source) values (01, '开发部', 'springboot')";
        jdbcTemplate.update(sql);
        //查询
        return "addOk";
    }

    /**
     * 修改部门信息
     *
     * @param id
     * @return
     */
    @GetMapping("/update/{id}")
    public String updateUser(@PathVariable("id") int id) {
        //插入语句
        String sql = "update dept set dname=? where deptno=" + id;
        //数据
        Object[] objects = new Object[1];
        objects[0] = "开发二部";
        jdbcTemplate.update(sql, objects);
        //查询
        return "updateOk";
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public String delUser(@PathVariable("id") int id) {
        //插入语句
        String sql = "delete from dept where deptno=?";
        jdbcTemplate.update(sql, id);
        //查询
        return "deleteOk";
    }

}
