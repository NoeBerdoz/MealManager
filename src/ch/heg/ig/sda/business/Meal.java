package ch.heg.ig.sda.business;

import ch.heg.ig.sda.datastructure.ArrayList;

public abstract class Meal {
    private String name;
    private ArrayList<Food> foods;

    public Meal(String name) {
        this.name = name;
        this.foods = new ArrayList<Food>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addFood(Food food) {
        foods.add(food);
    }

    public void removeFood(Food foodToRemove) throws FoodNotFoundException {
        for (int index = 0; index < foods.size(); index++) {
            Food food = foods.get(index);
            if (food.equals(foodToRemove)) {
                foods.remove(index);
                return;
            }
        }
        throw new FoodNotFoundException("food: \"" + foodToRemove.getName() + "\" not found in meal: \"" + getName() + "\"");
    }

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

    public double getTotalCalories() {
        return getTotalNutrients().getCalories();
    }

    public double getTotalProtein() {
        return getTotalNutrients().getProtein();
    }

    public double getTotalCarbohydrates() {
        return getTotalNutrients().getCarbohydrates();
    }

    public double getTotalFats() {
        return getTotalNutrients().getFats();
    }

    public String showFoods() {
        StringBuilder foodNames = new StringBuilder();
        for (int index = 0; index < getFoods().size(); index++) {
            foodNames.append(getFoods().get(index).getName());

            // Add a comma between food names
            if (index < getFoods().size() - 1) {
                foodNames.append(", ");
            }
        }
        return foodNames.toString();
    }

    public String showDataSummary() {
        return "Meal named " + getName() + " that contains " + getTotalCalories() + " calories\n"
               + getTotalProtein() + " protein\n"
               + getTotalCarbohydrates() + " carbohydrates\n"
               + getTotalFats() + " fats";
    }
}
