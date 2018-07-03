package com.example.mydemo.control;

import com.example.mydemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/query.json")
    public String query(@RequestParam(name = "name") String name) {
        return userService.query(name);
    }

    @RequestMapping("/add.json")
    public String add(@RequestParam(name = "name") String name) {
        userService.add(name);
        return String.format("The name[%s] has be add", name);
    }
}
