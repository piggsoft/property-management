package com.piggsoft.config;

import net.sf.ehcache.Ehcache;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheFactoryBean;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <br>Created by fire pigg on 2015/12/31.
 *
 * @author piggsoft@163.com
 */
@Configuration
// 标注启动了缓存
@EnableCaching
public class CacheConfiguration {

    @Bean
    public EhCacheManagerFactoryBean getEhCacheFactory(){
        EhCacheManagerFactoryBean factoryBean = new EhCacheManagerFactoryBean();
        factoryBean.setShared(true);
        return factoryBean;
    }



    @Bean
    public CacheManager getCacheManager() {
        return  new EhCacheCacheManager(getEhCacheFactory().getObject());
    }

    @Bean
    public Cache getCache() {
       return getCacheManager().getCache("demo");
    }

}
