package ch.heg.ig.sda.service;

import ch.heg.ig.sda.business.*;
import ch.heg.ig.sda.datastructure.ArrayList;

public class MealService implements IMealService {
    private ArrayList<Meal> meals;

    public MealService() {
        this.meals = new ArrayList<>();
    }

    @Override
    public ArrayList<Meal> getMeals() {
        return meals;
    }

    public Meal getMeal(int mealIndex) {
        return getMeals().get(mealIndex);
    }

    @Override
    public void addMeal(Meal meal) {
        meals.add(meal);
    }

    @Override
    public void removeMeal(Meal mealToRemove) {
        for (int index = 0; index < meals.size(); index++) {
            Meal meal = meals.get(index);
            if (meal.equals(mealToRemove)) {
                meals.remove(index);
                return;
            }
        }
    }

    @Override
    public void changeMealName(Meal meal, String newName) throws InvalidMealNameException {
        meal.setName(newName);
    }

    @Override
    public void addFoodToMeal(Meal meal, Food food) {
        meal.addFood(food);
    }

    @Override
    public void removeFoodFromMeal(Meal meal, Food food) throws FoodNotFoundException {
        meal.removeFood(food);
    }

    @Override
    public String showMeals() {
        // TODO: this is duplicated code from showFood, should get rid of this ugly way
        // TODO Create Exception when no meals available
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
        for (int index = 0; index < getMeals().size(); index++) {
            allFoodsNames.append(getMeals().get(index).showFoods());

            // Add a comma between meal's foods names
            if (index < getMeals().size() - 1) {
                allFoodsNames.append(", ");
            }
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

            // TODO make this responsive
            String separator = "=========================================";

            // TODO build this with StringBuilder append
            String summary = "[" + index + "]" + "Meal named " + currentMeal.getName() + " that contains " + currentMeal.getTotalCalories() + " calories\n"
                    + currentMeal.getTotalProtein() + " protein\n"
                    + currentMeal.getTotalCarbohydrates() + " carbohydrates\n"
                    + currentMeal.getTotalFats() + " fats";

            summaryFromMeals.append(separator);
            summaryFromMeals.append(summary);
        }
        return summaryFromMeals.toString();
    }
}
