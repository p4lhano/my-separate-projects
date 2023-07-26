package dev.palhano.spring_batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class BatchConfig {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Bean
    public Job printHelloWord () {
        return jobBuilderFactory
                .get("printHelloWord")
                .start(printHelloWordStep())
                .incrementer(new RunIdIncrementer())
                .build();
    }

    private Step printHelloWordStep() {
        return stepBuilderFactory
                .get("printHelloWordStep")// tasklet = tarefas simples 1 comando limpeza // chunck processamento complexo em pedeco  reader -> processor -> writer
                .tasklet(printHellowWordTasklet(null)).build();
    }
    @StepScope @Bean
    public Tasklet printHellowWordTasklet(@Value("#{jobParameters['nome']}") String param) {
        return new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                System.out.println(String.format("Ola mundo, %s",param));
                return RepeatStatus.FINISHED;
            }
        };
    }
}
