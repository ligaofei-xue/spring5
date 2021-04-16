package com.ligaofei.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 *  Spring的自动映射配置文件PropertySource注解
 *  @PropertySource，指定加载配置文件
 *  使用@Value映射到具体的java属性
 */
@Configuration
@PropertySource(value = {"classpath:config.properties"})
public class CustomConfig {

    @Value("${server.host}")
    private String host;

    @Value("${server.port}")
    private int port;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
