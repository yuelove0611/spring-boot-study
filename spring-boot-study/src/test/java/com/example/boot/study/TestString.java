package com.example.boot.study;

/**
 * @ author younger
 * @data 2021/3/9
 * @description TestString
 */
public class TestString {
    public static void main(String[]args){
        String name="111.11.aaa.jpg";
        int index=name.lastIndexOf(".");
        System.out.println(index);
        System.out.println(name.substring(index));
    }
}
