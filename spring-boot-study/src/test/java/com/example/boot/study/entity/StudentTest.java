package com.example.boot.study.entity;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@SpringBootTest
@ExtendWith(SpringExtension.class)
class StudentTest {
    @Resource
    private ConfigurableApplicationContext ioc;

    @Test
    public void testLoadStudent() {
        //测试
        boolean flag = ioc.containsBean("student");
        assertTrue(flag);
        Student expectedStudent = Student.builder().id(123).name("tom").build();
        Student student = (Student) ioc.getBean("student");
        assertEquals(expectedStudent,student);
    }
}