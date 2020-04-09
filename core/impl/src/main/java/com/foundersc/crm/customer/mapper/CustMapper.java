package com.foundersc.crm.customer.mapper;

import com.foundersc.crm.customer.bean.Customer;

/**
 * @Author fengye
 * @Date 2020/4/8
 * @Time 17:07
 * @Desc
 */
public interface CustMapper {

    /**
     * 查询客户信息
     *
     * @param customerNo 客户编号
     * @return
     */
    Customer queryCustomerByNo(String customerNo);
}
