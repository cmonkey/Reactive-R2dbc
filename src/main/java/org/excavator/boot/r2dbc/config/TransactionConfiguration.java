package org.excavator.boot.r2dbc.config;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.connectionfactory.R2dbcTransactionManager;
import org.springframework.transaction.ReactiveTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.reactive.TransactionalOperator;

@Configuration
@EnableTransactionManagement
public class TransactionConfiguration{

    @Bean
    ReactiveTransactionManager reactiveTransactionMananger(ConnectionFactory cf){
        return new R2dbcTransactionManager(cf);
    }

    @Bean
    TransactionalOperator transactionalOperator(ReactiveTransactionManager txm){
        return TransactionalOperator.create(txm);
    }
}
