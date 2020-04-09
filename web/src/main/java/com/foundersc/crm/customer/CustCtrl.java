package com.foundersc.crm.customer;

import com.foundersc.crm.customer.bean.Customer;
import com.foundersc.crm.customer.service.ICustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author fengye
 * @Date 2020/4/9
 * @Time 9:41
 * @Desc
 */
@Controller
@RequestMapping(value="/cust")
public class CustCtrl {

    @Autowired
    ICustService custService;

    @ResponseBody
    @RequestMapping(value="/test", method = RequestMethod.GET)
    public String test(){
        return "Hello spring mvc";
    }

    @ResponseBody
    @RequestMapping(value="/queryCustomerByNo", method = RequestMethod.GET)
    public String queryCustomerByNo(
            @RequestParam("customerNo") String customerNo
    ){
        Customer customer = custService.queryCustomerByNo(customerNo);
        return customer.toString();
    }

}
