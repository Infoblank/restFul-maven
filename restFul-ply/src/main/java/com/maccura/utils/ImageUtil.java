package com.maccura.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * @author 7097
 */
public class ImageUtil {

    private static final Logger log = LoggerFactory.getLogger(ImageUtil.class);

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
