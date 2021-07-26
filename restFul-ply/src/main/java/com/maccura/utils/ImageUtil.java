package com.maccura.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * @author 7097
 */
@Slf4j
public class ImageUtil {


    public static String[] loadImagePath() {
        // Resource resource = new ClassPathResource("static/images/");
        InputStream stream = ImageUtil.class.getClassLoader().getResourceAsStream("static/images/");
        byte[] bytes = new byte[0];
        try {
            bytes = FileCopyUtils.copyToByteArray(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String content = new String(bytes, StandardCharsets.UTF_8);
        String[] split = content.split("\\n");
        StringBuilder images;
        for (int i = 0; i < split.length; i++) {
            if (split[i].endsWith(".png")) {
                images = new StringBuilder("/images/");
                split[i] = images.append(split[i]).toString();
            }
        }
        return split;
    }
}
