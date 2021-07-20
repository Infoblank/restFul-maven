package com.maccura.restfulservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 7097
 */
@RestController
@RequestMapping("restFul/service")
public class MainController {

    @GetMapping("/add/{name}")
    public String add(@PathVariable("name") String name) {
        System.out.println("name = " + name);
        return name;
    }
}
