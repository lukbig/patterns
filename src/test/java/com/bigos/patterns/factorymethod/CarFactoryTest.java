package com.bigos.patterns.factorymethod;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarFactoryTest {

    @Test
    void shouldBuildSedan() {
        Car car = CarFactory.buildCar(CarType.SEDAN);

        assertThat(car).isInstanceOf(SedanCar.class);
    }

    @Test
    void shouldBuildCabriolet() {
        Car car = CarFactory.buildCar(CarType.CABRIOLET);

        assertThat(car).isInstanceOf(Cabriolet.class);
    }

    @Test
    void shouldBuildLimousine() {
        Car car = CarFactory.buildCar(CarType.LIMOUSINE);

        assertThat(car).isInstanceOf(Limousine.class);
    }
}