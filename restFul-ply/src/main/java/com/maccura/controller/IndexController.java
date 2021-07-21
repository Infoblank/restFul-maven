package com.maccura.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 7097
 */
@Controller
@RequestMapping("toIndex")
public class IndexController {

    @GetMapping("getIndex")
    public String getIndex() {
        return "/page/index";
    }

}
