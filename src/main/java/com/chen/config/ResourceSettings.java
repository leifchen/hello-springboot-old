package com.chen.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Resource
 *
 * @Author LeifChen
 * @Date 2018-12-07
 */
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "com.chen.hello")
@PropertySource(value = "classpath:resource.properties")
public class ResourceSettings {
    private String name;
    private String website;
}
