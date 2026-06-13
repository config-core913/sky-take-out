package com.sky.aspect;

import com.sky.properties.LocalFileProperties;
import com.sky.utils.LocalFileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class OssConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public LocalFileUtil localFileUtil(LocalFileProperties localFileProperties) {
        log.info("使用本地文件存储，目录：{}", localFileProperties.getUploadDir());
        return new LocalFileUtil(
                localFileProperties.getUploadDir(),
                localFileProperties.getBaseUrl()
        );
    }
}
