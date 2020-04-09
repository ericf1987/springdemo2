package com.foundersc.crm.customer.impl;

import com.foundersc.crm.customer.bean.Customer;
import com.foundersc.crm.customer.mapper.CustMapper;
import com.foundersc.crm.customer.service.ICustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author fengye
 * @Date 2020/4/8
 * @Time 17:06
 * @Desc
 */
@Service
public class CustService implements ICustService{

    @Autowired
    CustMapper custMapper;

    @Override
    public List<Customer> queryCustomerList() {
        System.out.println("【客户模块】 queryCustomerList");
        return null;
    }

    @Override
    public Customer queryCustomerByNo(String customerNo) {
        Customer customer = custMapper.queryCustomerByNo(customerNo);
        return customer;
    }

    public void test0(){
        System.out.println("【客户模块】 custService ... test");
    }

}
