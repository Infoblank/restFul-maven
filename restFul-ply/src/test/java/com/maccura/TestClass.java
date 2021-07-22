package com.maccura;

import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class TestClass {

    @Test
    void contextLoadsLocalDateTime() {

        /*LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        //localDateTime.format();

        Instant instant2 = Instant.parse("2019-06-10T03:42:39Z");
        System.out.println(instant2);
        LocalDateTime localDateTime2 = LocalDateTime.parse("2013-04-08 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(localDateTime2);

        long milliSecond = localDateTime2.toInstant(ZoneOffset.of("+8")).toEpochMilli();
        System.out.println("milliSecond = " + milliSecond);
        // 时间戳转化为LocalDateTime
        long currentTimeMillis = System.currentTimeMillis();

        LocalDateTime dateTime =LocalDateTime.ofEpochSecond(currentTimeMillis-milliSecond,0, ZoneOffset.ofHours(8));

        System.out.println(dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));*/
        Duration duration = Duration.between(LocalDateTime.parse("2018-01-18T06:30"), LocalDateTime.parse("2018-02-14T22:58"));
        System.out.println("duration = " + duration);
        //  PT664H28M 3D旋转相册
    }

    @Test
    void file() throws IOException {
      //  File file = new File("src/main/resources/static/images/");
      //  File file1 = ResourceUtils.getFile("classpath:static/images/");
        ClassPathResource classPathResource = new ClassPathResource("static/images/");
        File[] files = classPathResource.getFile().listFiles(pathname -> pathname.getAbsolutePath().endsWith(".png"));
        ArrayList<String> strings = new ArrayList<>();
        Arrays.stream(files).filter(s -> s.getAbsolutePath().endsWith(".png")).forEach(s->strings.add(s.getAbsolutePath().split("static")[1].replace("\\","/")));
        System.out.println(strings);
        /*File[] files = file1.listFiles(pathname -> pathname.getAbsolutePath().endsWith(".png"));
        assert files != null;
      //  Arrays.stream(files).forEach(s-> System.out.println(s.getPath()));
        ArrayList<String> strings = new ArrayList<>();
        Arrays.stream(files).filter(s -> s.getAbsolutePath().endsWith(".png")).forEach(s->strings.add(s.getAbsolutePath().split("static")[1].replace("\\","/")));

        *//*String str = "src\\main\\resources\\static\\images\\img_1.png";
        System.out.println(str.split("static")[1].replace("\\","/"));*/
    }
}
