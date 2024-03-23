package ch.heg.ig.sda.service;

import ch.heg.ig.sda.business.InvalidMealNameException;

public class MealServiceInvalidMealNameException extends InvalidMealNameException {
    public MealServiceInvalidMealNameException(String message) {
        super(message);
    }
}
