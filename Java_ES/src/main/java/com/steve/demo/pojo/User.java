package com.steve.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @Author: STEVE
 * @Description: 实体类 - 用户
 * @since: 2023/12/27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class User {

    private String name;
    private int age;

}
