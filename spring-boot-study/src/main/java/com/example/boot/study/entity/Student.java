package com.example.boot.study.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Resource;


/**
 * @ author younger
 * @data 2021/3/11
 * @description IoC
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Integer id;
    private String name;
//    @Resource
// private Father father;
}
