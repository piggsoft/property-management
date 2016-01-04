package com.piggsoft.context;

import org.springframework.core.io.Resource;

/**
 * <br>Created by fire pigg on 2016/01/04.
 *
 * @author piggsoft@163.com
 */
public class MybatisConfig {
    private Resource configLocation;
    private Resource[] mapperLocations;
    private String typeAliasesPackage;

    public Resource getConfigLocation() {
        return configLocation;
    }

    public void setConfigLocation(Resource configLocation) {
        this.configLocation = configLocation;
    }

    public Resource[] getMapperLocations() {
        return mapperLocations;
    }

    public void setMapperLocations(Resource[] mapperLocations) {
        this.mapperLocations = mapperLocations;
    }

    public String getTypeAliasesPackage() {
        return typeAliasesPackage;
    }

    public void setTypeAliasesPackage(String typeAliasesPackage) {
        this.typeAliasesPackage = typeAliasesPackage;
    }
}
