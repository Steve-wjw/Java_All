package com.steve.springboot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Author: STEVE
 * @Description: 实体类 - Dog
 * @since: 2024/1/4
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
@PropertySource(value = "classpath:application.properties")
public class Dog {

    @Value("${name}")
    private String name;

    private Integer age;

}
