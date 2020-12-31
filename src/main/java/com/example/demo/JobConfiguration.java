package com.example.demo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.step.tasklet.MethodInvokingTaskletAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    
    @Bean
    public CustomService service() {
        return new CustomService();
    }
    
    @StepScope
    @Bean
    public MethodInvokingTaskletAdapter methodInvokingTasklet() {
        MethodInvokingTaskletAdapter methodInvokingTaskletAdapter = new MethodInvokingTaskletAdapter();
        methodInvokingTaskletAdapter.setTargetObject(service());
        methodInvokingTaskletAdapter.setTargetMethod("getEmployees");
        return methodInvokingTaskletAdapter;
    }
    
    @Bean
    public Job methodInvokingJob() {
        return this.jobBuilderFactory.get("methodInvokingJob")
                .start(methodInvokingStep())
                .build();
    }

    @Bean
    public Step methodInvokingStep() {
        // Looking to configure the Chunk based Step here, dont know how to do using MethodInvokingTaskletAdapter
        return this.stepBuilderFactory.get("methodInvokingStep")
                .tasklet(methodInvokingTasklet())
                .build();
    }
}