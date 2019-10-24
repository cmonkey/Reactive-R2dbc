package org.excavator.boot.r2dbc.service;

import lombok.RequiredArgsConstructor;
import org.excavator.boot.r2dbc.entity.Customer;
import org.springframework.util.Assert;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class CustomerService{
    private final TranscationalOperator transcationalOperator;

    @Transacational
    Flux<Customer> saveAllWithTransactionalAnnoation(String...emails){
        return this.validaCustomersFromEamils(emails);
    }

    Flux<Customer> saveAllWithTransactionalOperator(String...emails){
        return this.transacationalOperator.transactional(this.validaCustomersFromEamils(emails));
    }

    Flux<Customer> validaCustomersFromEamils(String...emails){
        return Flux.fromArray(emails)
            .map(email -> new Customer(0L , email))
            .doOnNext(c -> Assert.isTrue(c.getName()
                        .contains("@"), "the email must contain a '@'"));
    }
}
