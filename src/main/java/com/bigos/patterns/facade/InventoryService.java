package com.bigos.patterns.facade;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class InventoryService {

    boolean isAvailable(Product product) {
        log.info("Checking if product {} is available", product);
        return true;
    }
}
