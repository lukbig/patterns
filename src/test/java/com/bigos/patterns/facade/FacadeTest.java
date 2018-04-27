package com.bigos.patterns.facade;

import com.bigos.patterns.extensions.MockitoExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
class FacadeTest {

    private final Long PRODUCT_ID = 11L;

    @Mock
    private Shipper shipper;
    @Mock
    private InventoryService inventoryService;
    @Mock
    private PaymentService paymentService;

    private ShoppingFacade facade;

    @BeforeEach
    void setUp() {
        facade = new SimpleShoppingFacade(
                inventoryService,
                paymentService,
                shipper
        );
    }

    @Test
    void shouldNotPlaceOrderIfProductIsNotAvailable() {
        Product product = new Product(PRODUCT_ID);
        when(inventoryService.isAvailable(product)).thenReturn(false);

        boolean isOrderDone = facade.placeOrder(product);

        assertThat(isOrderDone).isFalse();
        verify(inventoryService).isAvailable(product);
        verifyZeroInteractions(paymentService);
        verifyZeroInteractions(shipper);
    }

    @Test
    void shouldNotPlaceOrderIfPaymentFails() {
        Product product = new Product(PRODUCT_ID);
        when(inventoryService.isAvailable(product)).thenReturn(true);
        when(paymentService.doPayment(product)).thenReturn(false);

        boolean isOrderDone = facade.placeOrder(product);

        assertThat(isOrderDone).isFalse();
        verify(inventoryService).isAvailable(product);
        verify(paymentService).doPayment(product);
        verifyZeroInteractions(shipper);
    }

    @Test
    void shouldPlaceOrder() {
        Product product = new Product(PRODUCT_ID);
        when(inventoryService.isAvailable(product)).thenReturn(true);
        when(paymentService.doPayment(product)).thenReturn(true);

        boolean isOrderDone = facade.placeOrder(product);

        assertThat(isOrderDone).isTrue();
        verify(inventoryService).isAvailable(product);
        verify(paymentService).doPayment(product);
        verify(shipper).ship(product);
    }
}