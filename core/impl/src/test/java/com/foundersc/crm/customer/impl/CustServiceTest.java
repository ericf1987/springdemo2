package com.foundersc.crm.customer.impl;

import com.foundersc.crm.AppTest;
import com.foundersc.crm.customer.bean.Customer;
import com.foundersc.crm.customer.service.ICustService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @Author fengye
 * @Date 2020/4/8
 * @Time 17:06
 * @Desc
 */
@Slf4j
public class CustServiceTest extends AppTest{

    @Autowired
    ICustService custService;

    @Test
    public void testQueryCustomerList() throws Exception {

    }

    @Test
    public void testQueryCustomerByNo() throws Exception {
        String customerNo = "9808045001";
        Customer customer = custService.queryCustomerByNo(customerNo);
        log.info("客户信息 -> {}", customer.toString());
    }

    @Test
    public void testTest0() throws Exception {

    }
}