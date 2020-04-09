package com.foundersc.crm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author fengye
 * @Date 2020/4/9
 * @Time 17:04
 * @Desc
 */
@Configuration
public class WebConfig {

    @Bean
    public StringHttpMessageConverter stringHttpMessageConverter(){
        StringHttpMessageConverter converter = new StringHttpMessageConverter();
        converter.setSupportedMediaTypes(Arrays.asList(
                new MediaType(MediaType.TEXT_HTML, Charset.forName("UTF-8")),
                new MediaType(MediaType.TEXT_PLAIN, Charset.forName("UTF-8")),
                new MediaType(MediaType.APPLICATION_JSON, Charset.forName("UTF-8"))
        ));
        return converter;
    }

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(){
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Arrays.asList(
                new MediaType(MediaType.TEXT_HTML, Charset.forName("UTF-8")),
                new MediaType(MediaType.TEXT_XML, Charset.forName("UTF-8")),
                new MediaType(MediaType.TEXT_PLAIN, Charset.forName("UTF-8")),
                new MediaType(MediaType.APPLICATION_JSON, Charset.forName("UTF-8")),
                new MediaType(MediaType.APPLICATION_XML, Charset.forName("UTF-8"))

        ));
        return converter;
    }

    @Bean
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter(){
        RequestMappingHandlerAdapter adapter = new RequestMappingHandlerAdapter();
        List<HttpMessageConverter<?>> list =  new ArrayList<>(4);
        list.add(stringHttpMessageConverter());
        list.add(mappingJackson2HttpMessageConverter());
        adapter.setMessageConverters(list);
        return adapter;
    }

}
