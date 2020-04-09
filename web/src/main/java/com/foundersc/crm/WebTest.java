package com.foundersc.crm;

import com.foundersc.crm.customer.service.ICustService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author fengye
 * @Date 2020/4/9
 * @Time 15:57
 * @Desc
 */
public class WebTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext xmlContext = new ClassPathXmlApplicationContext("classpath:spring/spring-*.xml");
        AnnotationConfigApplicationContext annotationContext = new AnnotationConfigApplicationContext();
        String[] beanDefinitionNames = annotationContext.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("====当前bean: " + beanDefinitionName);
        }

        Object custCtrl = xmlContext.getBean("custCtrl");
        System.out.println(custCtrl);
        ICustService custService = (ICustService) xmlContext.getBean("custService");
        custService.queryCustomerList();
    }

}
