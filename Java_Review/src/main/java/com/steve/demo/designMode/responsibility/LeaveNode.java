package com.steve.demo.designMode.responsibility;

import lombok.Data;

/**
 * @Author: STEVE
 * @Description: 请假条
 * @since: 2023/12/18
 */
@Data
public class LeaveNode {

    /* 请假天数 */
    private int number;

    /* 请假人 */
    private String person;

    public LeaveNode(String person, int number) {
        this.number = number;
        this.person = person;
    }

}
