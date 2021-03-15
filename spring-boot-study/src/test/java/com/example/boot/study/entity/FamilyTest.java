package com.example.boot.study.entity;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;
import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@SpringBootTest
@ExtendWith(SpringExtension.class)
class FamilyTest {
    @Resource
    private  Family family;
    @Test
    void getFamilyName(){
        log.info("family:"+ family );
    }

}