package com.bigos.patterns.decorator;

import com.bigos.patterns.extensions.MockitoExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class DecoratorTest {

    @Test
    void shoulReturnFullInfo() {
        FullInfoWithDashedDecorator decorator = new FullInfoWithDashedDecorator(new PolishCitizen());

        String fullInfo = decorator.getFullInfo();

        assertThat(fullInfo).isEqualTo("Jan-Kowalski-70121212012");
    }

    @Test
    void shouldReturnUpperCasedName() {
        UpperCaseDecorator decorator = new UpperCaseDecorator(new PolishCitizen());

        String firstName = decorator.firstName();

        assertThat(firstName).isEqualTo("JAN");
    }
}