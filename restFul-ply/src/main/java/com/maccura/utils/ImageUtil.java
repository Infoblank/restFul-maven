package com.maccura.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
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

    public static String images() throws IOException {
        String resourceFile = "static/images/";
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources(resourceFile);
        String scheme = resources[0].getURI().getScheme();
        Resource resource;
        if ("jar".equals(scheme)) {
            resource = new ClassPathResource("BOOT-INF/classes/" + resourceFile);
            log.info("---{}",resource.getURI());
        } else {
            resource = new ClassPathResource(resourceFile);
        }
        // Resource resource = resources[0];
        //获得文件流，因为在jar文件中，不能直接通过文件资源路径拿到文件，但是可以在jar包中拿到文件流
        InputStream stream = resource.getInputStream();
        StringBuilder buffer = new StringBuilder();
        byte[] bytes = new byte[1024];
        try {
            for (int n; (n = stream.read(bytes)) != -1; ) {
                buffer.append(new String(bytes, 0, n));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer.toString();
       // System.out.println(txt);
    }
}
