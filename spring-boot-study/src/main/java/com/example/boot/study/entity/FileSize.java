package com.example.boot.study.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ author younger
 * @data 2021/3/9
 * @description 文件大小的配置获取类
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
public class FileSize {
    @Value("${spring.servlet.multipart.max-file-size}")
    private String maxSize;
}
