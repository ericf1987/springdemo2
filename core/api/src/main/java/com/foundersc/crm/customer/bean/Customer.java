package com.foundersc.crm.customer.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author fengye
 * @Date 2020/4/7
 * @Time 16:43
 * @Desc
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    private String customerNo;
    private String custName;
    private double allAsset;

}
