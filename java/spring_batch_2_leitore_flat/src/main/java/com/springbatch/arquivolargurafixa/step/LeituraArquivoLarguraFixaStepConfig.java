package com.springbatch.arquivolargurafixa.step;

import com.springbatch.arquivolargurafixa.reader.ArquivoClienteTransacaoReader;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LeituraArquivoLarguraFixaStepConfig {
	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Bean
	public Step leituraArquivoLarguraFixaStep(FlatFileItemReader leituraArquivoLarguraFixaReader,
											  ItemWriter leituraArquivoLarguraFixaWriter) {
		return stepBuilderFactory
				.get("leituraArquivoLarguraFixaStep")
				.chunk(1)
				.reader(new ArquivoClienteTransacaoReader(leituraArquivoLarguraFixaReader))
				.writer(leituraArquivoLarguraFixaWriter)
				.build();
	}
}
