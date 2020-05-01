package springbatch.split;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;


@Configuration
public class SplitTest {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job splitJob() {
        return jobBuilderFactory.get("splitJob").start(flow1()).split(new SimpleAsyncTaskExecutor()).add(flow2()).end().build();
    }

    @Bean
    public Flow flow1() {
        return new FlowBuilder<Flow>("flow1").start(step3()).next(step2())
                .build();
    }

    @Bean
    public Flow flow2() {
        return new FlowBuilder<Flow>("flow2").start(step2()).next(step3()).build();
    }

    @Bean
    public Step step2() {

        return stepBuilderFactory.get("step2").tasklet((contribution, context) -> {
            System.out.println("-----step2------");
            System.out.println(Thread.currentThread().getName());
            return RepeatStatus.FINISHED;
        }).build();
    }

    @Bean
    public Step step3() {

        return stepBuilderFactory.get("step3").tasklet((contribution, context) -> {
            System.out.println("step3");
            System.out.println(Thread.currentThread().getName());
            return RepeatStatus.FINISHED;
        }).build();
    }

    public Job flowDome() {
        return jobBuilderFactory.get("flowDome").start(flow1()).next(flow2()).end().build();
    }

    public JobBuilderFactory getJobBuilderFactory() {
        return jobBuilderFactory;
    }

    public void setJobBuilderFactory(JobBuilderFactory jobBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
    }

    public StepBuilderFactory getStepBuilderFactory() {
        return stepBuilderFactory;
    }

    public void setStepBuilderFactory(StepBuilderFactory stepBuilderFactory) {
        this.stepBuilderFactory = stepBuilderFactory;
    }
}
