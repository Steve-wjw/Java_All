package com.steve.dubbo;

import com.steve.dubbo.consumer.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: STEVE
 * @Description:
 * @since: 2024/1/9
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ConsumerServerApplicationTests {

    @Autowired
    UserService userService;

    @Test
    public void contextLoads() {
        userService.buyTicket();
    }

}
