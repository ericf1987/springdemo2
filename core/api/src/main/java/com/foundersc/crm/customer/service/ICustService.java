package com.foundersc.crm.customer.service;

import com.foundersc.crm.customer.bean.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author fengye
 * @Date 2020/4/7
 * @Time 16:42
 * @Desc
 */
public interface ICustService {

    List<Customer> queryCustomerList();

    Customer queryCustomerByNo(String customerNo);

}
