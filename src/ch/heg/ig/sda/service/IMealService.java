package ch.heg.ig.sda.service;

import ch.heg.ig.sda.business.*;
import ch.heg.ig.sda.datastructure.ArrayList;

/**
 * Interface responsible for managing meals.
 */
public interface IMealService {

    /**
     * Gets the list of meals.
     *
     * @return The list of meals.
     */
    ArrayList<Meal> getMeals();

    /**
     * Gets the meal at the specified index.
     *
     * @param mealIndex The index of the meal.
     * @return The meal at the specified index.
     */
    Meal getMeal(int mealIndex);

    /**
     * Adds a meal to the list of meals.
     *
     * @param meal The meal to add.
     */
    void addMeal(Meal meal);

    /**
     * Removes a meal from the list of meals.
     *
     * @param mealToRemove The meal to remove.
     */
    void removeMeal(Meal mealToRemove);

    /**
     * Changes the name of a meal.
     *
     * @param meal The meal to change the name of.
     * @param newName The new name for the meal.
     * @throws InvalidMealNameException if the new name is invalid.
     */
    void changeMealName(Meal meal, String newName) throws InvalidMealNameException;

    /**
     * Adds a food to a meal.
     *
     * @param meal The meal to add the food to.
     * @param food The food to add.
     */
    void addFoodToMeal(Meal meal, Food food);

    /**
     * Removes a food from a meal.
     *
     * @param meal The meal to remove the food from.
     * @param food The food to remove.
     */
    void removeFoodFromMeal(Meal meal, Food food);

    /**
     * Displays a list of meals.
     *
     * @return A string representation of the list of meals.
     */
    String showMeals();

    /**
     * Displays a list of foods from all meals.
     *
     * @return A string representation of the list of foods from all meals.
     */
    String showFoodsFromMeals();

    /**
     * Calculates and returns the total calories from all meals.
     *
     * @return The total calories from all meals.
     */
    double getTotalCaloriesFromMeals();

    /**
     * Calculates and returns the total nutrients from all meals.
     *
     * @return The total nutrients from all meals.
     */
    Nutrient getTotalNutrientsFromMeals();

    /**
     * Displays a summary of data from all meals.
     *
     * @return A string representation of the summary of data from all meals.
     */
    String showDataSummaryFromMeals();
}
