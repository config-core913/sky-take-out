package com.sky.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@Data
@AllArgsConstructor
@Slf4j
public class LocalFileUtil {
    private String uploadDir;
    private String baseUrl;

    public String upload(byte[] bytes,String objectName){
        //确保目录存在
        File dir = new File(uploadDir);
        if(!dir.exists()){
            dir.mkdirs();
        }

        //写文件
        File file = new File(uploadDir + File.separator + objectName);
        try (FileOutputStream fos = new FileOutputStream(file)){
            fos.write(bytes);
        } catch (IOException e) {
            log.error("本地文件保存失败：{}",e.getMessage());
            throw new RuntimeException("文件保存失败");
        }

        String url = baseUrl + "/" + objectName;
        log.info("文件已保存到本地：{}", url);
        return url;
    }
}
