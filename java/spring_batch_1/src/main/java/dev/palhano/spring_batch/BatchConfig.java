package dev.palhano.spring_batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

@EnableBatchProcessing
@Configuration
public class BatchConfig {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    public BatchConfig(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
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
                .<Integer, String>chunk(15)// nao entendi esse chanck size
                // quant de transaçoes que serao podem ficar aber, 1 nessa caso significa que para cada registro sera abertos 1 transacao
                // quando mais o valor, menos transacoes serao abertas, mas o custo sera maior em memoria do processador
                .reader(countOfThenReader())// obrigatorio informar em chunk
                .processor(countOfThenProcessor())// opcional informar em chunk
                .writer(countOfThenWriter())// obrigatorio informar em chunk
                .build();
    }
    // Processo de chunk 1 - Reader vai atras dos itens que devem ser processados
    // Por padrão nesssário retornar uma implentação da interface ItemReader<T>, nesse caso pode ser retornado a
    // implementação própria do spring IteratorItemReader<T>. Lembrando que o <T> é o mesmo tipo do chuck reader,
    // declarado anteriormente
    private IteratorItemReader<Integer> countOfThenReader() {
        List<Integer> numbers = Arrays.asList(0,1,2,3,4,5,6,7,8,9);
        return new IteratorItemReader<>(numbers.iterator());
    }
    // Processo de chunk 2 - Processor recebe cada item separador do Reader, via Iterator, e faz o processamento individual
    // Interface padrão que um processor deve retornar ItemProcessor<? super T_reader, T_write>
    private FunctionItemProcessor<Integer, String> countOfThenProcessor() {
        return new FunctionItemProcessor<>(new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return integer + " é " + (integer % 2 == 0 ? "par" : "impar");
            }
        });
    }
    // Processo de chunk 3 - Writer recebe a colecao ja processada que foi realizada no processor
    private ItemWriter<String> countOfThenWriter() {
        return new ItemWriter<String>() {
            @Override
            public void write(List<? extends String> list) throws Exception {
                list.forEach(System.out::println);
            }
        };
    }

}
