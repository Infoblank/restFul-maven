package com.maccura.controller;

import com.maccura.utils.ResultData;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 7097
 */
@RestController
@RequestMapping("service/v2")
public class MainController {

    @GetMapping("/add/{name}")
    public String add(@PathVariable("name") String name) {
        System.out.println("name = " + name);
        System.out.println("MainController.add");
        return name;
    }

    @GetMapping("return/data")
    public ResultData<String> to3dRotatingAlbum(Model model) {
        return ResultData.success("\"/page/3DRotatingAlbum\"");
    }

}
