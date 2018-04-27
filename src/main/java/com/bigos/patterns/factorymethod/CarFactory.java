package com.bigos.patterns.factorymethod;

/**
 * If object creation code ('new') is spread in whole application
 * and if you need to change the process of object creation the you
 * need to go to each place and make changes in each one of them.
 */

public class CarFactory {

    public static Car buildCar(CarType carType) {
        switch (carType) {
            case SEDAN:
                return new SedanCar();
            case CABRIOLET:
                return new Cabriolet();
            case LIMOUSINE:
                return new Limousine();
            default:
                throw new IllegalArgumentException(String.format("Invalid car type given %s", carType));
        }
    }
}
