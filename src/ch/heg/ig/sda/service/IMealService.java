package ch.heg.ig.sda.service;

import ch.heg.ig.sda.business.*;
import ch.heg.ig.sda.datastructure.ArrayList;

public interface IMealService {
    // TODO Javadoc
    // TODO Polymorphisme
    // TODO Check everything according to the consignes
    ArrayList<Meal> getMeals();
    Meal getMeal(int index);
    void addMeal(Meal meal);
    void removeMeal(Meal meal);

    void changeMealName(Meal meal, String newName) throws InvalidMealNameException;
    void addFoodToMeal(Meal meal, Food food);
    void removeFoodFromMeal(Meal meal, Food food) throws FoodNotFoundException;

    String showMeals();
    String showFoodsFromMeals();
    double getTotalCaloriesFromMeals();
    Nutrient getTotalNutrientsFromMeals();
    String showDataSummaryFromMeals();
}
