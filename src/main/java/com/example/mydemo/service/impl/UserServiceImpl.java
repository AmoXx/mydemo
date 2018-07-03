package com.example.mydemo.service.impl;

import com.example.mydemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public String query(String name) {
        String value = stringRedisTemplate.opsForValue().get("test");
        if (StringUtils.isEmpty(value) || value.contains(name)) {
            return "redis have no this name : " + name;
        }
        return value;
    }

    @Override
    public void add(String name) {
        String value = stringRedisTemplate.opsForValue().get("test");
        if (StringUtils.isEmpty(value)) {
            stringRedisTemplate.opsForValue().set("test", name);
        }
    }
}
