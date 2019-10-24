package org.excavator.boot.r2db.config;

@Configuration
@EnableTransactionManangement
public class TransactionConfiguration{

    @Bean
    ReactiveTransactionManager reactiveTransactionMananger(ConnectionFactory cf){
        return new R2dbcTransactionManager(cf);
    }

    @Bean
    TransactionalOperator transactionalOperator(ReactiveTranactionManager txm){
        return TransactionalOperator.create(txm);
    }
}
