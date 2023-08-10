package com.springbatch.arquivolargurafixa.reader;

import com.springbatch.arquivolargurafixa.dominio.Cliente;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.builder.MultiResourceItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class LeituraArquivoLarguraFixaReaderConfig {

//	@Bean @StepScope
//	public FlatFileItemReader<Cliente> leituraArquivoLarguraFixaReader(
//			@Value("#{jobParameters['arquivoClientes']}") Resource arquivoClientes ) {
//		// leitor de arquivo de largura fixa.
//		return new FlatFileItemReaderBuilder<Cliente>()
//				.name("leituraArquivoLarguraFixaReader")
//				.resource(arquivoClientes)
//				.fixedLength()
//				.columns(new Range[]{new Range(1,10),new Range(11,20),new Range(21,23),new Range(24,37)})
//				.names("nome","sobrenome","idade","email")
//				.targetType(Cliente.class)
//				.build();
//	}
//	@Bean @StepScope
//	public FlatFileItemReader<Cliente> leituraArquivoDelimitadoReader(
//			@Value("#{jobParameters['arquivoClientes']}") Resource arquivoClientes ) {
//		// leitor de arquivo de com delimitador ','.
//		return new FlatFileItemReaderBuilder<Cliente>()
//				.name("leituraArquivoDelimitadoReader")
//				.resource(arquivoClientes)
//				.delimited()
//				.names("nome","sobrenome","idade","email")
//				.targetType(Cliente.class)
//				.build();
//	}
	@Bean @StepScope
	public FlatFileItemReader leitorArquivosMultiplosFormatosReader(
			@Value("#{jobParameters['arquivoClientes']}") Resource arquivoClientes,
			LineMapper lineMapper) {
		// leitor de arquivo de com delimitador ','.
		return new FlatFileItemReaderBuilder<Cliente>()
				.name("leituraArquivoMultiplosFormatosReader")
				.resource(arquivoClientes)
				.lineMapper(lineMapper)
				.build();
	}
	@Bean @StepScope
	public MultiResourceItemReader leiturasArquivosMultiplosFormatosReader(
			@Value("#{jobParameters['arquivoClientes']}") Resource arquivoClientes,
			FlatFileItemReader leitorArquivosMultiplosFormatosReader) {
		// leitor de arquivo de com delimitador ','.
		return new MultiResourceItemReaderBuilder<>()
				.name("leiturasArquivosMultiplosFormatosReader")
				.resources(arquivoClientes)
				.delegate(new ArquivoClienteTransacaoReader(leitorArquivosMultiplosFormatosReader))
				.build();
	}
}
