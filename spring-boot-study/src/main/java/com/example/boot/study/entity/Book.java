package com.example.boot.study.entity;


import com.fasterxml.jackson.annotation.*;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @ author younger
 * @data 2021/3/5
 * @description 图书
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder(value = {"content","title"})
public class Book {
    @JsonIgnore
    private  Integer id;
    @JsonProperty("name")
    private  String author;
    private  String title;
    private  String content;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private  Date   createTime;
    private List<BookReader> readers;

}
