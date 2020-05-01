package springbatch.split;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class TestApp {

    public static void main(String[] args) {

        SpringApplication application=new SpringApplication();
        application.setBannerMode(Banner.Mode.CONSOLE);
        application.run(TestApp.class,args);
    }
}
