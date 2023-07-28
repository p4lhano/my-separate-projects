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
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

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
    @Bean
    public Job printParImparJob () {
        return jobBuilderFactory
                .get("printParImparJob")
                .start(printParImparJobStep())
                .incrementer(new RunIdIncrementer())
                .build();
    }

    private Step printParImparJobStep() {
        return stepBuilderFactory
                .get("printParImparJobStep")
                .<Integer, String>chunk(1)
                .reader(countOfThenReader())
                .processor(countOfThenProcessor())
                .writer(countOfThenWriter())
                .build();
    }
    // Por padrão nesssário retornar uma implentação da interface ItemReader<T>, nesse caso pode ser retornado a
    // implementação própria do spring IteratorItemReader<T>. Lembrando que o <T> é o mesmo tipo do chuck reader,
    // declarado anteriormente
    private IteratorItemReader<Integer> countOfThenReader() {
        List<Integer> numbers = Arrays.asList(0,1,2,3,4,5,6,7,8,9);
        return new IteratorItemReader<>(numbers.iterator());
    }
    // Interface padrão que um processor deve retornar ItemProcessor<? super T_reader, T_write>
    private FunctionItemProcessor<Integer, String> countOfThenProcessor() {
        return new FunctionItemProcessor<>(new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return integer + " é " + (integer % 2 == 0 ? "par" : "impar");
            }
        });
    }

    private ItemWriter<? super String> countOfThenWriter() {
        return null;
    }

}
