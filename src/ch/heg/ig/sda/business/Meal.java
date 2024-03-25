package ch.heg.ig.sda.business;

import ch.heg.ig.sda.datastructure.ArrayList;

/**
 * Abstract class representing a meal.
 *
 * @author NoeBerdoz
 */
public abstract class Meal {

    /**
     * The name of the meal.
     */
    private String name;

    /**
     * The list of foods in the meal.
     */
    private ArrayList<Food> foods;

    /**
     * Default constructor for Meal.
     */
    public Meal() {
        this.foods = new ArrayList<>();
    }

    /**
     * Gets the type of the meal
     *
     * @return the type of the meal
     */
    public abstract String getType();

    /**
     * Gets the name of the meal.
     *
     * @return The name of the meal.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the list of foods in the meal.
     *
     * @return The list of foods.
     */
    public ArrayList<Food> getFoods() {
        return foods;
    }

    /**
     * Gets the food at the specified index.
     *
     * @param foodIndex The index of the food.
     * @return The food at the specified index.
     */
    public Food getFood(int foodIndex) {
        return getFoods().get(foodIndex);
    }

    /**
     * Sets the name of the meal.
     *
     * @param name The name to set for the meal.
     * @throws InvalidMealNameException if the name is containing special characters.
     */
    public void setName(String name) throws InvalidMealNameException {
        // matches letters digits and whitespace characters only
        if (!name.matches("[a-zA-Z0-9\\s]+")) {
            throw new InvalidMealNameException("Invalid meal name: must contain only letters, digits, and whitespace.\n");
        }
        this.name = name;
    }

    /**
     * Adds a food to the meal.
     *
     * @param foodName            The food name to add.
     * @param proteinAmount       The amount of protein of the food.
     * @param carbohydratesAmount The amount of carbohydrates of the food.
     * @param fatsAmount          The amount of fats of the food.
     */
    public void addFood(String foodName, double proteinAmount, double carbohydratesAmount, double fatsAmount) {
        Food newFood = new Food();
        newFood.setName(foodName);

        Nutrient newNutrient = new Nutrient();
        newNutrient.setProtein(proteinAmount);
        newNutrient.setCarbohydrates(carbohydratesAmount);
        newNutrient.setFats(fatsAmount);
        newFood.setNutrients(newNutrient);

        foods.add(newFood);
    }

    /**
     * Removes a food from the meal.
     *
     * @param foodToRemove The food to remove.
     */
    public void removeFood(Food foodToRemove) {
        for (int index = 0; index < foods.size(); index++) {
            Food food = foods.get(index);
            if (food.equals(foodToRemove)) {
                foods.remove(index);
                return;
            }
        }
    }

    /**
     * Calculates and returns the total nutrients of the meal.
     *
     * @return The total nutrients of the meal.
     */
    public Nutrient getTotalNutrients() {

        double totalProtein = 0;
        double totalCarbohydrate = 0;
        double totalFats = 0;

        for (int index = 0; index < getFoods().size(); index++) {

            Nutrient foodNutrient = getFoods().get(index).getNutrients();

            totalProtein += foodNutrient.getProtein();
            totalCarbohydrate += foodNutrient.getCarbohydrates();
            totalFats += foodNutrient.getFats();
        }

        return new Nutrient(totalProtein, totalCarbohydrate, totalFats);
    }

    /**
     * Calculates and returns the total calories of the meal.
     *
     * @return The total calories of the meal.
     */
    public double getTotalCalories() {
        return getTotalNutrients().getCalories();
    }

    /**
     * Calculates and returns the total protein of the meal.
     *
     * @return The total protein of the meal.
     */
    public double getTotalProtein() {
        return getTotalNutrients().getProtein();
    }

    /**
     * Calculates and returns the total carbohydrates of the meal.
     *
     * @return The total carbohydrates of the meal.
     */
    public double getTotalCarbohydrates() {
        return getTotalNutrients().getCarbohydrates();
    }

    /**
     * Calculates and returns the total fats of the meal.
     *
     * @return The total fats of the meal.
     */
    public double getTotalFats() {
        return getTotalNutrients().getFats();
    }

    /**
     * Generates a string representation of the foods in the meal.
     *
     * @return A string representation of the foods in the meal.
     */
    public String showFoods() {
        StringBuilder foodNames = new StringBuilder();
        for (int index = 0; index < getFoods().size(); index++) {
            foodNames.append(index);
            foodNames.append(". ");
            foodNames.append(getFoods().get(index).getName());
            foodNames.append("\n");
        }
        return foodNames.toString();
    }

    /**
     * Generates a string representation of the data summary of the meal.
     *
     * @return A string representation of the data summary of the meal.
     */
    public String showDataSummary() {
        StringBuilder summary = new StringBuilder();
        summary.append(getType())
                .append(" named ")
                .append(" that contains ")
                .append(getTotalCalories())
                .append(" calories\n")
                .append(getTotalProtein())
                .append(" protein\n")
                .append(getTotalCarbohydrates())
                .append(" carbohydrates\n")
                .append(getTotalFats())
                .append(" fats\n");

        return summary.toString();
    }
}
