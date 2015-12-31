package com.piggsoft.context;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <br>Created by fire pigg on 2015/12/11.
 *
 * @author piggsoft@163.com
 */
@Component
@ConfigurationProperties(prefix="app")
public class Context {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
