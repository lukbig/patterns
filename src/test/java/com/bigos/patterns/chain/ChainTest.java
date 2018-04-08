package com.bigos.patterns.chain;

import com.bigos.patterns.extensions.MockitoExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

@ExtendWith(MockitoExtension.class)
class ChainTest {

    private static final String MESSAGE = "some message";

    @Mock
    private AbstractLogger abstractLogger;

    @Test
    void shouldReceiveRequestIfLoggerIsSet() {
        AbstractLogger logger = new InfoLogger(AbstractLogger.INFO);
        logger.setNextLogger(abstractLogger);

        logger.receiveRequest(1, MESSAGE);

        verify(abstractLogger).receiveRequest(1, MESSAGE);
    }


    @Test
    void shoulNotReceiveRequestIfLoggerIsNotSet() {
        AbstractLogger logger = new InfoLogger(AbstractLogger.INFO);
        logger.setNextLogger(null);

        logger.receiveRequest(1, MESSAGE);

        verifyZeroInteractions(abstractLogger);
    }

    @Test
    void shouldLogWithChain() {
        AbstractLogger infoLogger = new InfoLogger(AbstractLogger.INFO);
        AbstractLogger debugLogger = new DebugLogger(AbstractLogger.DEBUG);
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        errorLogger.setNextLogger(debugLogger);
        debugLogger.setNextLogger(infoLogger);

        errorLogger.receiveRequest(AbstractLogger.ERROR, MESSAGE);
    }
}