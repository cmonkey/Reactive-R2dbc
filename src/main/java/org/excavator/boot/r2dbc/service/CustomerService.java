package org.excavator.boot.r2dbc.service;

import lombok.RequiredArgsConstructor;
import org.excavator.boot.r2dbc.entity.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.reactive.TransactionalOperator;
import org.springframework.util.Assert;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class CustomerService{
    private final TransactionalOperator transcationalOperator;

    @Transactional
    Flux<Customer> saveAllWithTransactionalAnnoation(String...emails){
        return this.validaCustomersFromEamils(emails);
    }

    Flux<Customer> saveAllWithTransactionalOperator(String...emails){
        return this.transcationalOperator.transactional(this.validaCustomersFromEamils(emails));
    }

    Flux<Customer> validaCustomersFromEamils(String...emails){
        return Flux.fromArray(emails)
            .map(email -> new Customer(0L , email))
            .doOnNext(c -> Assert.isTrue(c.getName()
                        .contains("@"), "the email must contain a '@'"));
    }
}
