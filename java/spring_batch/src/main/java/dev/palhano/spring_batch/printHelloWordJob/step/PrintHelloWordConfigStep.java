package dev.palhano.spring_batch.printHelloWordJob.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PrintHelloWordConfigStep {
    private final StepBuilderFactory stepBuilderFactory;

    public PrintHelloWordConfigStep(StepBuilderFactory stepBuilderFactory) {
        this.stepBuilderFactory = stepBuilderFactory;
    }
    @Bean
    public Step printHelloWordStep(Tasklet printHellowWordTasklet) {
        return stepBuilderFactory
                .get("printHelloWordStep")// tasklet = tarefas simples 1 comando limpeza // chunck processamento complexo em pedeco  reader -> processor -> writer
                .tasklet(printHellowWordTasklet)
                .build();
    }
}
