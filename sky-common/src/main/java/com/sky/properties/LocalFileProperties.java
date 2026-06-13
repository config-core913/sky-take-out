package com.sky.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "sky.localfile")
public class LocalFileProperties {
    private String uploadDir;
    private String baseUrl;
}
