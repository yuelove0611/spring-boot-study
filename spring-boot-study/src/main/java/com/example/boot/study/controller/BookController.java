package com.example.boot.study.controller;

import com.example.boot.study.controller.dto.AjaxResponse;
import com.example.boot.study.controller.dto.Param;
import com.example.boot.study.entity.Book;
import com.example.boot.study.entity.BookReader;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @ author younger
 * @data 2021/3/5
 * @description BookController
 */

    @RestController
    @RequestMapping(value = "api/v1/books")
    @Slf4j
    @Validated
    public class BookController {

    private MockMultipartFile multipartFile;

    @GetMapping("all")
    public AjaxResponse selectBooks() {
        BookReader[] readers = {BookReader.builder().name("ddd").age(20).build(), BookReader.builder().name("fff").age(25).build(),};
        List<BookReader> readerList = Arrays.asList(readers);// 数组成集合
        Book book1 = Book.builder().id(123).author("yxh").title("SpringBoot").content("SpringBoot从入门到进阶").createTime(new Date()).readers(readerList).build();

        Book book2 = Book.builder().id(456).author("yxh").title("Vue.js").content("Vue.js从入门到进阶").createTime(new Date()).readers(readerList).build();
        Book[] books = {book1, book2};
        List<Book> booklist = Arrays.asList(books);

        return AjaxResponse.success(booklist);
    }

    @GetMapping("{id}")//路径传参
    public AjaxResponse getBook(@PathVariable int id) {
        Book book = Book.builder().id(id).author("yxh").title("java").content("java").createTime(new Date()).build();
        return AjaxResponse.success(book);
    }

    @PostMapping()
    public AjaxResponse saveBook(@RequestBody Book book) {
        log.info("saveBook:" + book);
        return AjaxResponse.success();
    }

    @PutMapping()    //修改,通过问号传参
    public AjaxResponse updateBook(@RequestParam int id, @RequestParam String title) {
        Book book = Book.builder().id(id).author("yxh").title("java").content("java").createTime(new Date()).build();
        book.setTitle(title);
        log.info("book:" + book);
        return AjaxResponse.success(book);
    }

    //    //删除
    @DeleteMapping("{id}")
    public AjaxResponse deleteBook(@PathVariable int id, String title) {
        log.info("id:" + id);
        return AjaxResponse.success();
    }

    //删除,表单请求,缺省请求
//    @DeleteMapping()
    //public  AjaxResponse deleteBook(@RequestParam int id,@RequestParam String title){
    //  public  AjaxResponse deleteBook(@RequestParam(value ="id",defaultValue = "888") int idd,@RequestParam("tit") String tit){
    // log.info("id:"+idd);
    //log.info("title:"+tit);
    // return AjaxResponse.success();
    //}
//    @DeleteMapping() //与以下同理
    //  @RequestMapping(value = "del",method = RequestMethod.DELETE)
    //public AjaxResponse deletBook(@RequestBody Param param){
    //  log.info("id:"+param.getId());
    //  log.info("title:"+param.getTitle());
    //  return AjaxResponse.success(param);
    // }
    //  }
    @PostMapping("upload")
    public AjaxResponse handleUpload(MultipartFile file, HttpServletRequest request) {
        //创建文件在服务器的存放目录
        String path = request.getServletContext().getRealPath("/upload");
        log.info(path);
        File fileDir = new File(path);
        if (!fileDir.exists()) {
            boolean flag = fileDir.mkdirs();
            log.info("flag:" + flag);

        }
        //生成文件在服务器的名字
        String prefixName=UUID.randomUUID().toString();
        //取得原文件的后缀名
        String originalFilename=file.getOriginalFilename();
        //从原文件名中分离出扩展名(后缀) 111.jpg->.jpg
        assert  originalFilename !=null;
        String suffixName=originalFilename.substring(originalFilename.lastIndexOf("."));
        //拼接新的文件名
        String fileName=prefixName+suffixName;
        log.info(fileName);
        //创建上传文件对象
        File saveFile=new File(path+"/"+fileName);
        //上传
        try {
            file.transferTo(saveFile);
        } catch (IOException e) {
           log.info(e.getMessage());
           AjaxResponse.failure("文件上传失败");
        }
        return AjaxResponse.success(fileName);
    }

    @PostMapping(value = "/upload2")
    public AjaxResponse sourceUpload(MultipartFile[] sourceFiles, HttpServletRequest request) {
        List fileNames = new ArrayList();
        YearMonth yearMonth = YearMonth.now();
        Calendar now = Calendar.getInstance();
        for(MultipartFile file :sourceFiles) {
            if(file.isEmpty()) {
                System.out.println("文件为空");
            }

            //文件重命名
            String prefixName1 = UUID.randomUUID().toString();
            //获取文件后缀名
            String originalFilename = file.getOriginalFilename();
            //
            assert originalFilename != null;
            String suffixName = originalFilename.substring(originalFilename.lastIndexOf("."));
            //拼接新的文件名
            String newFileName = prefixName1 + suffixName;
            log.info(newFileName);
            //上传文件
            String ym = yearMonth.format(DateTimeFormatter.ofPattern("yyyy-MM"));
            int day = now.get(Calendar.DAY_OF_MONTH);
            String path = request.getServletContext().getRealPath("img/"+ym+"/"+ day + "/" + suffixName);
            log.info(path);
            File fileDir = new File(path);
            if (!fileDir.exists()){
                boolean flag = fileDir.mkdirs();
                log.info("flag:"+flag);
            }
            //创建上传文件对象
            File saveFile = new File(path + "/" + newFileName);
            try {
                file.transferTo(saveFile);
            } catch (IOException e) {
                e.printStackTrace();
                log.info(e.getMessage());
                AjaxResponse.failure("文件上传失败");
            }
            fileNames.add(newFileName);
            log.info(fileNames.toString());
        }
        return AjaxResponse.success(fileNames);
    }
}


