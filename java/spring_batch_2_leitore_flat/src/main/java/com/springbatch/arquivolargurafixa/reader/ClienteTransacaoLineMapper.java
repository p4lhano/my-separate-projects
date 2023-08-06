package com.springbatch.arquivolargurafixa.reader;

import com.springbatch.arquivolargurafixa.dominio.Cliente;
import com.springbatch.arquivolargurafixa.dominio.Transacao;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.mapping.PatternMatchingCompositeLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ClienteTransacaoLineMapper {
    private final String REGEX_CLIENT_LINE = "0*";
    private final String REGEX_TRANSACTION_LINE = "1*";
    @Bean
    public PatternMatchingCompositeLineMapper lineMapper (){
        PatternMatchingCompositeLineMapper lineMapper = new PatternMatchingCompositeLineMapper<>();
        lineMapper.setTokenizers(tokenizers());
        lineMapper.setFieldSetMappers(fieldSetMappers());
        return lineMapper;
    }
    private Map<String, LineTokenizer> tokenizers() {
        Map<String,LineTokenizer> tokenizers = new HashMap<>();
        tokenizers.put(REGEX_CLIENT_LINE,clientLineTokenizers());
        tokenizers.put(REGEX_TRANSACTION_LINE,transacaoLineTokenizers());
        return tokenizers;
    }
    private LineTokenizer clientLineTokenizers() {
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setNames("nome","sobrenome","idade","email");
        lineTokenizer.setIncludedFields(1,2,3,4);
        return lineTokenizer;
    }
    private LineTokenizer transacaoLineTokenizers() {
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setNames("id","descricao","valor");
        lineTokenizer.setIncludedFields(1,2,3);
        return lineTokenizer;
    }


    private Map<String, FieldSetMapper> fieldSetMappers() {
        Map<String, FieldSetMapper> fieldSetMapperMappers = new HashMap<>();
        fieldSetMapperMappers.put(REGEX_CLIENT_LINE, fieldSetMapperMapper(Cliente.class));
        fieldSetMapperMappers.put(REGEX_TRANSACTION_LINE, fieldSetMapperMapper(Transacao.class));
        return fieldSetMapperMappers;
    }

    private FieldSetMapper fieldSetMapperMapper(Class clienteClass) {
        BeanWrapperFieldSetMapper filFieldSetMapper = new BeanWrapperFieldSetMapper<>();
        filFieldSetMapper.setTargetType(clienteClass);
        return filFieldSetMapper;
    }
}
