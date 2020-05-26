package com.yph.redisdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @GetMapping("/test")
    void test(){
        ValueOperations<String,String> valueOperations = stringRedisTemplate.opsForValue();
        valueOperations.set("name","三国演义");
        String name = valueOperations.get("name");
        System.out.println(name);
        ValueOperations<String,Object> valueOperations2 = redisTemplate.opsForValue();
        Book book = new Book();
        book.setAuthor("曹雪芹");
        book.setId(1);
        book.setName("红楼梦");
        valueOperations2.set("book",book);
        Book b1 = (Book)valueOperations2.get("book");
        System.out.println(b1);
    }
}
