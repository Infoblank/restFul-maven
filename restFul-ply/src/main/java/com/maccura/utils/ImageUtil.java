package com.maccura.utils;

import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author 7097
 */
public class ImageUtil {

    public static ArrayList<String> loadImagePath() {
        ClassPathResource classPathResource = new ClassPathResource("static/images/");
        File[] files = new File[0];
        try {
            files = classPathResource.getFile().listFiles(pathname -> pathname.getAbsolutePath().endsWith(".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert files != null;
        ArrayList<String> images = new ArrayList<>();
        Arrays.stream(files).filter(s -> s.getAbsolutePath().endsWith(".png")).forEach(s -> images.add(s.getAbsolutePath().split("static")[1].replace("\\", "/")));
        return images;
    }
}
