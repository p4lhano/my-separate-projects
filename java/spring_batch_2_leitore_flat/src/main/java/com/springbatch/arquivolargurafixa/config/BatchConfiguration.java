package com.springbatch.arquivolargurafixa.config;

import javax.sql.DataSource;

import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration(exclude = {HibernateJpaAutoConfiguration.class})
@EnableBatchProcessing
public class BatchConfiguration extends DefaultBatchConfigurer {
// tabelas padrao do spring nao estava sendo configurada
    @Override
    public void setDataSource(DataSource dataSource) {
        super.setDataSource(null);
    }
}
