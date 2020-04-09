package com.foundersc.crm.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageHelper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @Author fengye
 * @Date 2020/4/8
 * @Time 16:52
 * @Desc
 */
@Configuration
@PropertySource("classpath:application-base.properties")
@MapperScan("com.foundersc.crm")
@Data
@Slf4j
public class DataSourceConfiguration {

    @Value("${base.datasource.url}")
    private String url;

    @Value("${base.datasource.username}")
    private String username;

    @Value("${base.datasource.password}")
    private String password;

    @Value("${base.datasource.driver}")
    private String driver;

    @Value("${mybatis.typeAliasesPackage}")
    private String typeAliasesPackage;

    @Value("${mybatis.mapperLocations}")
    private String mapperLocations;

    @Value("${mybatis.configLocation.cacheEnabled}")
    private String cacheEnabled;

    @Value("${mybatis.configLocation.lazyLoadingEnabled}")
    private String lazyLoadingEnabled;

    @Value("${mybatis.configLocation.aggressiveLazyLoading}")
    private String aggressiveLazyLoading;

    @Value("${mybatis.configLocation.multipleResultSetsEnabled}")
    private String multipleResultSetsEnabled;

    @Value("${mybatis.configLocation.useColumnLabel}")
    private String useColumnLabel;

    @Value("${mybatis.configLocation.useGeneratedKeys}")
    private String useGeneratedKeys;

    @Value("${mybatis.configLocation.autoMappingBehavior}")
    private String autoMappingBehavior;

    @Value("${mybatis.configLocation.defaultExecutorType}")
    private String defaultExecutorType;

    @Value("${mybatis.configLocation.mapUnderscoreToCamelCase}")
    private String mapUnderscoreToCamelCase;

    @Value("${mybatis.configLocation.localCacheScope}")
    private String localCacheScope;

    @Value("${mybatis.configLocation.jdbcTypeForNull}")
    private String jdbcTypeForNull;

    @Bean
    public DataSource baseDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(this.driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public DataSourceTransactionManager sqlTransactionManager() {
        return new DataSourceTransactionManager(baseDataSource());
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(@Qualifier("baseDataSource") DataSource baseDataSource) throws Exception {
        final SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(baseDataSource);

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources(this.mapperLocations);

        factoryBean.setMapperLocations(resources);
        factoryBean.setTypeAliasesPackage("com.foundersc.crm.*.**");

        factoryBean.setConfigurationProperties(getConfigurationProperties());

        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate() throws Exception{
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory(baseDataSource()));
        return sqlSessionTemplate;
    }

    private Properties getConfigurationProperties() {
        Properties properties = new Properties();
        properties.setProperty("mybatis.configLocation.cacheEnabled", cacheEnabled);
        properties.setProperty("mybatis.configLocation.lazyLoadingEnabled", lazyLoadingEnabled);
        properties.setProperty("mybatis.configLocation.aggressiveLazyLoading", aggressiveLazyLoading);
        properties.setProperty("mybatis.configLocation.multipleResultSetsEnabled", multipleResultSetsEnabled);
        properties.setProperty("mybatis.configLocation.useColumnLabel", useColumnLabel);
        properties.setProperty("mybatis.configLocation.useGeneratedKeys", useGeneratedKeys);
        properties.setProperty("mybatis.configLocation.autoMappingBehavior", autoMappingBehavior);
        properties.setProperty("mybatis.configLocation.defaultExecutorType", defaultExecutorType);
        properties.setProperty("mybatis.configLocation.mapUnderscoreToCamelCase", mapUnderscoreToCamelCase);
        properties.setProperty("mybatis.configLocation.localCacheScope", localCacheScope);
        properties.setProperty("mybatis.configLocation.jdbcTypeForNull", jdbcTypeForNull);
        return properties;
    }

    @Bean
    public PageHelper pageHelper() {
        log.info("MyBatis分页插件PageHelper");
        //分页插件
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum", "true");
        properties.setProperty("rowBoundsWithCount", "true");
        properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("returnPageInfo", "check");
        properties.setProperty("params", "count=countSql");
        pageHelper.setProperties(properties);
        return pageHelper;
    }
}
