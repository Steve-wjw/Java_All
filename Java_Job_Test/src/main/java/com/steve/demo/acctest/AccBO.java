package com.steve.demo.acctest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: STEVE
 * @Description: 账户信息
 * @since: 2023/11/29
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccBO {

    private String accNo;

    private String accName;

    private String accCertNo;

    private String accMobileNo;

}
