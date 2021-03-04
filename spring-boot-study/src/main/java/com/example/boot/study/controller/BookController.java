package com.example.boot.study.controller;

import com.example.boot.study.controller.dto.AjaxResponse;
import com.example.boot.study.entity.Book;
import com.example.boot.study.entity.BookReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @ author younger
 * @data 2021/3/5
 * @description BookController
 */

    @RestController
    @RequestMapping(value = "api/v1/books")
    @Slf4j
    public class BookController {

        @GetMapping("all")
        public AjaxResponse selectBooks(){
            BookReader[] readers={
                    BookReader.builder()
                            .name("ddd")
                            .age(20)
                            .build(),
                    BookReader.builder()
                            .name("fff")
                            .age(25)
                            .build(),
            };
            List<BookReader> readerList= Arrays.asList(readers);// 数组成集合
            Book book1= Book.builder()
                    .id(123)
                    .author("yxh")
                    .title("SringBoot")
                    .content("SpringBoot从入门到进阶")
                    .createTime(new Date())
                    .readers(readerList)
                    .build();

            Book book2= Book.builder()
                    .id(456)
                    .author("yxh")
                    .title("Vue.js")
                    .content("Vue.js从入门到进阶")
                    .createTime(new Date())
                    .readers(readerList)
                    .build();
            Book[] books={book1,book2};
            List<Book> booklist=Arrays.asList(books);

            return AjaxResponse.success(booklist);
        }

        @GetMapping("{id}")
        public AjaxResponse getBook(@PathVariable int id){
            Book book= Book.builder()
                    .id(id)
                    .author("yxh")
                    .title("java")
                    .content("java")
                    .createTime(new Date())
                    .build();
            return AjaxResponse.success(book);
        }

        @PostMapping()
        public AjaxResponse saveBook(@RequestBody Book book){
            log.info("saveBook:"+book);
            return AjaxResponse.success(book);
        }

        @PutMapping()    //修改,通过问号传参
        public  AjaxResponse updateBook(@RequestParam int id,@RequestParam String title){
            Book book= Book.builder()
                    .id(id)
                    .author("ldd")
                    .title("java")
                    .content("java")
                    .createTime(new Date())
                    .build();
            book.setTitle(title);
            log.info("book:"+book);
            return AjaxResponse.success(book);
        }
//    //删除
//    @DeleteMapping("{id}")
//    public  AjaxResponse deleteBook(@PathVariable int id,String title){
//        log.info("id:"+id);
//        return AjaxResponse.success();
//    }

        //删除,表单请求
//    @DeleteMapping()
////    public  AjaxResponse deleteBook(@RequestParam int id,@RequestParam String title){
//        public  AjaxResponse deleteBook(@RequestParam(value ="id",defaultValue = "888") int idd,@RequestParam("tit") String tit){
//        log.info("id:"+idd);
//        log.info("title:"+tit);
//        return AjaxResponse.success();
//    }
//    @DeleteMapping() //与以下同理
    //    @RequestMapping(value = "del",method = RequestMethod.DELETE)
     //   public AjaxResponse deletBook(@RequestBody Param param){
      //      log.info("id:"+param.getId());
      //      log.info("title:"+param.getTitle());
     //       return AjaxResponse.success(param);
       // }
  //  }
}
