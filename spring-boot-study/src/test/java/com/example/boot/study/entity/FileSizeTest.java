package com.example.boot.study.entity;

import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

class FileSizeTest {
    @Resource
    private  FileSize fileSize;

    @Test
    void getMaxSize(){
        String maxSize=fileSize.getMaxSize();
        assertEquals("300MB",maxSize);
    }

}