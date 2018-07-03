package com.example.mydemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MydemoApplicationTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void contextLoads() {
        List<String> list =new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("v");
        stringRedisTemplate.opsForValue().set("abc", "测试");
        stringRedisTemplate.opsForList().leftPushAll("qq",list); // 向redis存入List
        stringRedisTemplate.opsForList().range("qwe",0,-1).forEach(value ->{
            System.out.println(value);
        });
    }

}
