package ch.heg.ig.sda.service;

import ch.heg.ig.sda.business.*;
import ch.heg.ig.sda.datastructure.ArrayList;

public class MealService implements IMealService {

    private static MealService instance;

    private ArrayList<Meal> meals;

    private MealService() {
        this.meals = new ArrayList<>();
    }

    public static MealService getInstance() {
        if (instance == null) {
            instance =  new MealService();
        }
        return instance;
    }

    public String getMealType(Meal meal) {
        return meal.getType();
    }

    @Override
    public ArrayList<Meal> getMeals() {
        return meals;
    }

    public Meal getMeal(int mealIndex) {
        return getMeals().get(mealIndex);
    }

    @Override
    public void addMeal(Meal meal, String mealName) throws InvalidMealNameException {
        try {
            setMealName(meal, mealName);
            meals.add(meal);
        } catch (InvalidMealNameException error) {
            throw new MealServiceInvalidMealNameException(error.getMessage());
        }

    }

    @Override
    public void removeMeal(Meal mealToRemove) throws MealNotFoundException {
        meals.remove(getMealIndex(mealToRemove));
    }

    public void replaceMeal(int mealToReplaceIndex, Meal mealThatReplace) {
        meals.set(mealToReplaceIndex, mealThatReplace);
    }

    public int getMealIndex(Meal mealToFind) throws MealNotFoundException{
        for (int index = 0; index < meals.size(); index++) {
            Meal meal = meals.get(index);
            if (meal.equals(mealToFind)) {
                return index;
            }
        }
        throw new MealNotFoundException("Meal not found: " + mealToFind.getName());
    }

    @Override
    public void setMealName(Meal meal, String newName) throws InvalidMealNameException {
        try {
            meal.setName(newName);
        } catch (InvalidMealNameException error) {
            throw new MealServiceInvalidMealNameException(error.getMessage());
        }
    }

    @Override
    public void addFoodToMeal(Meal meal, String foodName, double proteinAmount, double carbohydratesAmount, double fatsAmount) {
        meal.addFood(foodName, proteinAmount, carbohydratesAmount, fatsAmount);
    }

    @Override
    public void removeFoodFromMeal(Meal meal, Food food) {
        meal.removeFood(food);
    }

    @Override
    public String showMeals() throws MealNotFoundException {
        if (getMeals().isEmpty()) {
            throw new MealNotFoundException("There are no meals to show\n");
        }

        StringBuilder mealNames = new StringBuilder();
        for (int index = 0; index < getMeals().size(); index++) {
            mealNames.append(index);
            mealNames.append(". ");
            mealNames.append(getMeals().get(index).getName());

            // Add a newline between meal names
            if (index < getMeals().size() - 1) {
                mealNames.append("\n");
            }
        }
        return mealNames.toString();
    }

    @Override
    public String showFoodsFromMeals() {
        StringBuilder allFoodsNames = new StringBuilder();
        for (int indexMeal = 0; indexMeal < getMeals().size(); indexMeal++) {

            Meal currentMeal = getMeal(indexMeal);
            allFoodsNames.append("==================\n");
            allFoodsNames.append(currentMeal.getName());
            allFoodsNames.append(":\n");
            allFoodsNames.append(currentMeal.showFoods());

        }
        return allFoodsNames.toString();
    }

    @Override
    public double getTotalCaloriesFromMeals() {
        double totalCaloriesFromMeals = 0;
        for (int index = 0; index < getMeals().size(); index++) {
            totalCaloriesFromMeals += getMeals().get(index).getTotalCalories();
        }
        return totalCaloriesFromMeals;
    }

    @Override
    public Nutrient getTotalNutrientsFromMeals() {
        // TODO: this is duplicated code from getTotalNutrients, should get rid of this ugly way

        double totalProteinFromMeals = 0;
        double totalCarbohydrateFromMeals = 0;
        double totalFatsFromMeals = 0;

        for (int index = 0; index < getMeals().size(); index++) {

            Nutrient mealNutrients = getMeals().get(index).getTotalNutrients();

            totalProteinFromMeals += mealNutrients.getProtein();
            totalCarbohydrateFromMeals += mealNutrients.getCarbohydrates();
            totalFatsFromMeals += mealNutrients.getFats();
        }

        return new Nutrient(totalProteinFromMeals, totalCarbohydrateFromMeals, totalFatsFromMeals);
    }

    public String showDataSummaryFromMeals() {
        StringBuilder summaryFromMeals = new StringBuilder();
        for (int index = 0; index < getMeals().size(); index++) {
            Meal currentMeal = getMeals().get(index);

            summaryFromMeals.append("=========================================\n");
            summaryFromMeals.append("[").append(index).append("]");
            summaryFromMeals.append(currentMeal.getType()).append(": ").append(currentMeal.getName());
            summaryFromMeals.append(" that contains ").append(currentMeal.getTotalCalories()).append(" calories\n");
            summaryFromMeals.append(currentMeal.getTotalProtein()).append(" protein\n");
            summaryFromMeals.append(currentMeal.getTotalCarbohydrates()).append(" carbohydrates\n");
            summaryFromMeals.append(currentMeal.getTotalFats()).append(" fats\n");
        }
        return summaryFromMeals.toString();
    }
}
