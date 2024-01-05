package com.steve.springboot;

import com.alibaba.druid.pool.DruidDataSource;
import com.steve.springboot.pojo.Dog;
import com.steve.springboot.pojo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class SpringbootApplicationTests {

    @Autowired
    Person person; // 将person自动注入进来
    @Autowired
    Dog dog;

    // DI注入数据源
    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() {
        System.out.println(person); // 打印person信息
        System.out.println(dog); //打印dog信息
    }

    @Test
    void contextLoads2() throws SQLException {
        //看一下默认数据源
        System.out.println(dataSource.getClass());
        //获得连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        //关闭连接
        connection.close();
    }

    @Test
    void contextLoads3() throws SQLException {
        //看一下默认数据源
        System.out.println(dataSource.getClass());
        //获得连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

        DruidDataSource druidDataSource = (DruidDataSource) dataSource;
        System.out.println("druidDataSource 数据源最大连接数：" + druidDataSource.getMaxActive());
        System.out.println("druidDataSource 数据源初始化连接数：" + druidDataSource.getInitialSize());

        //关闭连接
        connection.close();
    }

}
