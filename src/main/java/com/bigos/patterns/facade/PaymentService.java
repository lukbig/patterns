package com.bigos.patterns.facade;


import lombok.extern.slf4j.Slf4j;

@Slf4j
class PaymentService {

    boolean doPayment(Product product) {
        log.info("Paying for product {}", product);
        return true;
    }
}
