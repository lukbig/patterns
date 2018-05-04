package com.bigos.patterns.proxy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Provide a surrogate or placeholder for another object to control
 * access to it.
 *
 * 1. A virtual proxy is a placeholder for expensive to create objects.
 * The real object is only created when a client first requests/accesses the object.
 * 2. Remote proxy provides a local representative for an object that resides in a
 * different address space - stub.
 * 3. A protective proxy controls access to a sensitive master object. The proxy
 * checks that the caller has the access permissions required prior to forwarding
 * the request.
 * 4. A smart proxy interposes additional action when an object is accessed.
 */

class ProxyTest {

    private static final String STATE = "state";

    @Test
    void shouldDisplayState() {
        Proxy proxy = new Proxy(STATE);

        String state = proxy.display();

        assertThat(state).isEqualTo(STATE);

        state = proxy.display();

        assertThat(state).isEqualTo(STATE);
    }
}