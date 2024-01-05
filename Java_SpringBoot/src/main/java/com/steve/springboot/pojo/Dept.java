package com.steve.springboot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: STEVE
 * @Description: 实体类 - Dept
 * @since: 2024/1/5
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dept {

    private Long deptNo;

    private String dname;

    private String dbSource;

}
