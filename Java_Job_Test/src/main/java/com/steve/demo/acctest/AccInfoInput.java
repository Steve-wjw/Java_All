package com.steve.demo.acctest;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Author: STEVE
 * @Description: 账户信息输入
 * @since: 2023/11/29
 */
@Data
@Component
@PropertySource(value = {"classpath:config/input-accinfo-dev.yml"}, factory = MixPropertySourceFactory.class)
@ConfigurationProperties(prefix = "acc")
public class AccInfoInput {

    private AccBO abcDebitAccBO;
    private AccBO abcCreditAccBO;
    private AccBO otherBankAccBO;

}
