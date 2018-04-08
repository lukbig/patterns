package com.bigos.patterns.adapter;

import com.bigos.patterns.extensions.MockitoExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PlugAdapterTest {

    @Mock
    private MaleConnectorAdapter maleConnectorAdapter;

    @Test
    void testAdapter() {
        Plug plug = new Plug(maleConnectorAdapter);

        plug.plug();

        verify(maleConnectorAdapter).plug();
    }
}