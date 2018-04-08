package com.bigos.patterns.abstractfactory;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CountriesFactoryTest {

    @Test
    void shouldReturnPolishCapital() {
        CountryFactory factory = CountryFactoryProvider.createFactory(CountryType.POLAND);

        Capital capital = factory.capital();

        assertThat(capital.name()).isEqualTo(PolishCapital.CAPITAL_NAME);
    }

    @Test
    void shouldReturnPolishHymn() {
        CountryFactory factory = CountryFactoryProvider.createFactory(CountryType.POLAND);

        Hymn hymn = factory.hymn();

        assertThat(hymn.name()).isEqualTo(PolishHymn.NAME);
    }

    @Test
    void shouldReturnPolishSymbol() {
        CountryFactory factory = CountryFactoryProvider.createFactory(CountryType.POLAND);

        Symbol symbol = factory.symbol();

        assertThat(symbol.description()).isEqualTo(PolishSymbol.DESCRIPTION);
    }

    @Test
    void shouldReturnGermanCapital() {
        CountryFactory factory = CountryFactoryProvider.createFactory(CountryType.GERMANY);

        Capital capital = factory.capital();

        assertThat(capital.name()).isEqualTo(GermanCapital.CAPITAL_NAME);
    }

    @Test
    void shouldReturnGermanHymn() {
        CountryFactory factory = CountryFactoryProvider.createFactory(CountryType.GERMANY);

        Hymn hymn = factory.hymn();

        assertThat(hymn.name()).isEqualTo(GermanHymn.NAME);
    }

    @Test
    void shouldReturnGermanSymbol() {
        CountryFactory factory = CountryFactoryProvider.createFactory(CountryType.GERMANY);

        Symbol symbol = factory.symbol();

        assertThat(symbol.description()).isEqualTo(GermanSymbol.DESCRIPTION);
    }
}