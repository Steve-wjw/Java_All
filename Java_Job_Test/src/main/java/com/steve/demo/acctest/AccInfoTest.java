package com.steve.demo.acctest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: STEVE
 * @Description: 账户信息测试案例
 * @since: 2023/11/29
 */
@RestController
public class AccInfoTest {

    @Autowired
    AccInfoInput accInfoInput;

    @RequestMapping("/test")
    public void test1() {
        System.out.println(accInfoInput.getAbcDebitAccBO());
        System.out.println(accInfoInput.getAbcCreditAccBO());
        System.out.println(accInfoInput.getOtherBankAccBO());
    }

}
