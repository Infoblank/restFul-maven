package com.maccura.controller;

import com.maccura.utils.ImageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        String[] imagePath = ImageUtil.loadImagePath();
        model.addAttribute("images",imagePath);
        return "/page/3DRotatingAlbum";
    }


}
