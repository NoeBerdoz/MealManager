package ch.heg.ig.sda.service;

import ch.heg.ig.sda.business.*;
import ch.heg.ig.sda.datastructure.ArrayList;

public interface IMealService {
    // TODO Javadoc
    // TODO Polymorphisme
    // TODO Check everything according to the consignes
    ArrayList<Meal> getMeals();
    void addMeal(Meal meal);
    void removeMeal(Meal meal) throws MealNotFoundException;

    void modifyMeal(Meal meal, int choice);
    void addFoodToMeal(Meal meal, Food food);
    void removeFoodFromMeal(Meal meal, Food food) throws FoodNotFoundException;

    String showMeals();
    String showFoodsFromMeals();
    double getTotalCaloriesFromMeals();
    Nutrient getTotalNutrientsFromMeals();
    String showDataSummaryFromMeals();
}
