package com.crm.commun.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ConfigurationProperties
@EnableConfigurationProperties
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ConfigProperties {
    public static String appVersion;
    @Value("${api.version}")
    public void setAppVersion(String appVersion){
        this.appVersion = appVersion;
    }
}