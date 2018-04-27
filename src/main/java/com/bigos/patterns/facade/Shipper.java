package com.bigos.patterns.facade;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class Shipper {

    void ship(Product product) {
        log.info("Ship product {}", product);
    }
}
