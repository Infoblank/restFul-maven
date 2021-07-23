package com.maccura.utils;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author 7097
 */
public class ImageUtil {

    public static String[] loadImagePath() {
        Resource resource = new ClassPathResource("static/images/");
        byte[] bytes = new byte[0];
        try {
            bytes = FileCopyUtils.copyToByteArray(resource.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        String content = new String(bytes, StandardCharsets.UTF_8);
        String[] split = content.split("\\n");
        StringBuilder images = null;
        for (int i = 0; i < split.length; i++) {
            images = new StringBuilder("/images/");
            split[i] = images.append(split[i]).toString();
        }
        return split;
    }
}
