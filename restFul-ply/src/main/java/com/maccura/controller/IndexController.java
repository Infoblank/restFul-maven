package com.maccura.controller;

import com.maccura.utils.ImageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

/**
 * @author 7097
 */
@Controller
@RequestMapping("service/v1")
public class IndexController {

    @GetMapping("getIndex")
    public String getIndex() {
        return "/page/index";
    }


    @GetMapping("to3DRotatingAlbum.html")
    public String to3dRotatingAlbum(Model model) {
        ArrayList<String> imagePath = ImageUtil.loadImagePath();
        model.addAttribute("images",imagePath);
        return "/page/3DRotatingAlbum";
    }
}
