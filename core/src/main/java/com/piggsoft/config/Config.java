package com.piggsoft.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.piggsoft.context.MybatisConfig;
import com.piggsoft.interceptor.TokenInterceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.sql.DataSource;

/**
 * <br>Created by fire pigg on 2015/12/31.
 *
 * @author piggsoft@163.com
 */
@Configuration
// 标注启动了缓存
@EnableCaching
@EnableTransactionManagement
@MapperScan("com.piggsoft.mapper")
public class Config extends WebMvcConfigurerAdapter {

    @Autowired
    private TokenInterceptor tokenInterceptor;

    @Bean
    @ConfigurationProperties(prefix = "jdbc")
    public DataSource dataSource() {
        return new DruidDataSource();
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        MybatisConfig config = mybatisConfig();
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        sqlSessionFactoryBean.setConfigLocation(config.getConfigLocation());
        sqlSessionFactoryBean.setMapperLocations(config.getMapperLocations());
        sqlSessionFactoryBean.setTypeAliasesPackage(config.getTypeAliasesPackage());
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    @ConfigurationProperties(prefix = "mybatis")
    public MybatisConfig mybatisConfig() {
        return new MybatisConfig();
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor)
                .addPathPatterns("/**");
    }

    @Bean
    public ObjectMapper getObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper;
    }

    @Bean
    public EhCacheManagerFactoryBean getEhCacheFactory() {
        EhCacheManagerFactoryBean factoryBean = new EhCacheManagerFactoryBean();
        factoryBean.setShared(true);
        return factoryBean;
    }

    @Bean
    public CacheManager getCacheManager() {
        return new EhCacheCacheManager(getEhCacheFactory().getObject());
    }

    @Bean
    public Cache getCache() {
        return getCacheManager().getCache("token");
    }

}
