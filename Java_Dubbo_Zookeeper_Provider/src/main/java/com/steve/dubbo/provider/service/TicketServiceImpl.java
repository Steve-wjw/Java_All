package com.steve.dubbo.provider.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Author: STEVE
 * @Description:
 * @since: 2024/1/9
 */
@Service
@Component
public class TicketServiceImpl implements TicketService{

    @Override
    public String getTicket() {
        return "《狂神说Java》";
    }

}
