package com.maccura.controller;

import com.maccura.utils.ImageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author 7097
 */
@Controller
@RequestMapping("service/v1")
public class IndexController {
    private static final Logger log = LoggerFactory.getLogger(IndexController.class);
    @GetMapping("getIndex")
    public String getIndex() {
        return "/page/index";
    }


    @GetMapping("to3DRotatingAlbum.html")
    public String to3dRotatingAlbum(Model model) {
        String[] imagePath = ImageUtil.loadImagePath();
        // 全局处理
        ArrayList<String> strings = new ArrayList<>(Arrays.asList(imagePath));
        log.info(strings.toString());
        model.addAttribute("images",strings);
        return "page/3DRotatingAlbum";
    }
}
