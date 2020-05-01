package config;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class TestApp1 {

    public static void main(String[] args) {

        SpringApplication application=new SpringApplication();
        application.setBannerMode(Banner.Mode.CONSOLE);
        application.run(TestApp1.class,args);
    }
}
