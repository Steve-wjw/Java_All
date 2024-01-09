package com.steve.dubbo.consumer.service;

import com.steve.dubbo.provider.service.TicketService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * @Author: STEVE
 * @Description:
 * @since: 2024/1/9
 */
@Service
public class UserService {

    @Reference(check = false)
    TicketService ticketService;

    public void buyTicket() {
        String ticket = ticketService.getTicket();
        System.out.println("在注册中心买到" + ticket);
    }


}
