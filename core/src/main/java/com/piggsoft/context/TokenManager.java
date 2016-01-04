package com.piggsoft.context;

import com.piggsoft.model.User;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.UUID;

/**
 * <br>Created by fire pigg on 2016/01/04.
 *
 * @author piggsoft@163.com
 */
@Component
public class TokenManager implements InitializingBean{

    @Autowired
    private Cache cache;

    private static Cache CACHE;

    public static String add(User user) {
        String token = UUID.randomUUID().toString();
        CACHE.put(token, user);
        return token;
    }

    public static User get(String token) {
        if (StringUtils.isEmpty(token)) {
            return null;
        }
        Cache.ValueWrapper valueWrapper = CACHE.get(token);
        if (null == valueWrapper) {
            return null;
        }
        return (User)valueWrapper.get();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        CACHE = this.cache;
    }
}
