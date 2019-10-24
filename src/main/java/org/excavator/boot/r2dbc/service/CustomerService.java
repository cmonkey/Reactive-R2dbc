package org.excavator.boot.r2dbc.service;

@RequiredArgsConstructor
public class CustomerService{
    private final TranscationalOperator transcationalOperator;

    @Transacational
    Flux<Customer> saveAllWithTransactionalAnnoation(String...emails){
        return this.validaCustomersFromEamils(emails);
    }

    Flux<Customer> saveAllWithTransactionalOperator(String...emails){
        return this.transacationalOperator.transactional(this.validCustomersFromEamils(emails));
    }

    Flux<Customer> validaCustomersFromEamils(String...emails){
        return Flux.fromArray(emails)
            .map(email -> new Customer(null , email))
            .doOnNext(c -> Assert.isTrue(c.getEmail()
                        .contains("@"), "the email must contain a '@'"));
    }
}
