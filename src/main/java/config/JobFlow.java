package config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobFlow {


    @Autowired
    private JobBuilderFactory jobBuilderFactory;


    @Autowired
    private StepBuilderFactory stepBuilderFactory;


    @Bean
    public Job jobFlow1() {
        return jobBuilderFactory.get("jobFlow1").start(step1()).build();
    }

    public Step step1() {
        return stepBuilderFactory.get("step1").tasklet((contribution, context) -> {
            System.out.println("job flow test1");
            return RepeatStatus.FINISHED;
        }).build();
    }

    public Step step2() {
        return stepBuilderFactory.get("step2").tasklet((contribution, context) -> {
            System.out.println("job flow test2");
            return RepeatStatus.FINISHED;
        }).build();
    }


}
