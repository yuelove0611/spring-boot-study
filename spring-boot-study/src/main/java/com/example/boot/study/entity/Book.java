package com.example.boot.study.entity;


import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @ author younger
 * @data 2021/3/5
 * @description 图书
 */
@Data
@Builder
public class Book {
    private  Integer id;
    private  String author;
    private  String title;
    private  String content;
    private  Date   createTime;
    private List<BookReader> readers;

}
