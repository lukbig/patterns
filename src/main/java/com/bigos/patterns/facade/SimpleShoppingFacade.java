package com.bigos.patterns.facade;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
public class SimpleShoppingFacade implements ShoppingFacade {

    private final InventoryService inventoryService;
    private final PaymentService paymentService;
    private final Shipper shipper;

    @Override
    public boolean placeOrder(Product product) {
        boolean orderStatus = false;
        if (isProductAvailable(product)) {
            log.info("Product {} is available", product);
            boolean isPaymentDone = paymentService.doPayment(product);
            log.info("Is payment done? {}", isPaymentDone);
            orderStatus = shipOrder(product, isPaymentDone);
            log.info("Order status {}", orderStatus);
        }
        return orderStatus;
    }

    private boolean shipOrder(Product product, boolean isPaymentDone) {
        if (isPaymentDone) {
            shipper.ship(product);
            return true;
        }
        return false;
    }

    private boolean isProductAvailable(Product product) {
        return inventoryService.isAvailable(product);
    }
}
