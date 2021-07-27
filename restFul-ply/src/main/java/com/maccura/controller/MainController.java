package com.maccura.controller;

import com.maccura.utils.ImageUtil;
import com.maccura.utils.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author 7097
 */
@RestController
@Slf4j
@RequestMapping("service/v2")
public class MainController {

    @GetMapping("/add/{name}")
    public String add(@PathVariable("name") String name) {
        System.out.println("name = " + name);
        System.out.println("MainController.add");
        return name;
    }

    @GetMapping("return/data")
    public ResultData<String> to3dRotatingAlbum() {
        return ResultData.success("\"/page/3DRotatingAlbum\"");
    }


    @GetMapping("getImagesPath.json")
    public ResultData<ArrayList<String>> getImagesPath() {
        String[] imagePath = ImageUtil.loadImagePath();
        ArrayList<String> strings = new ArrayList<>(Arrays.asList(imagePath));
        return ResultData.success(strings);
    }

    @GetMapping("getImagesPath1.json")
    public ResultData<String> getImagesPath1() throws IOException {
        return ResultData.success(ImageUtil.images());
    }

}
