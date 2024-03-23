package ch.heg.ig.sda.app;

import ch.heg.ig.sda.business.*;
import ch.heg.ig.sda.service.MealNotFoundException;
import ch.heg.ig.sda.service.MealService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidMealNameException, MealNotFoundException {
        System.out.println("Welcome to your Meal Manager App");

        MealService mealService = new MealService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            showMainMenu();

            int choiceMenu = getUserChoice(scanner);

            switch (choiceMenu) {
                case 1:
                    userAddMeal(scanner, mealService);
                    break;
                case 2:
                    userAddFoodToMeal(scanner, mealService);
                    break;
                case 3:
                    userShowMealSummary(scanner, mealService);
                    break;
                case 4:
                    userRemoveMeal(scanner, mealService);
                    break;
                case 5:
                    userRemoveFoodFromMeal(scanner, mealService);
                    break;
                case 6:
                    userChangeMealName(scanner, mealService);
                    break;
                case 7:
                    userReplaceMeal(scanner, mealService);
                    break;
                case 8:
                    userShowFoodsFromMeals(mealService);
                    break;
                case 9:
                    userShowTotalCalories(mealService);
                    break;
                case 10:
                    userShowTotalNutrients(mealService);
                    break;
                case 11:
                    userShowAllMealsSummary(mealService);
                    break;
                case 42:
                    userGenerateListOfMeals(mealService);
                    break;
                case 0:
                    userExit(scanner);
                default:
                    System.out.println("Invalid choice, try again entering a valid choice number.");
            }
        }
    }

    public static void showMainMenu() {
        System.out.println("\nSelect an action:");
        System.out.println("1. Add a new meal");
        System.out.println("2. Add food to a meal");
        System.out.println("3. Show meal information");
        System.out.println("4. Remove a meal");
        System.out.println("5. Remove food from a meal");
        System.out.println("6. Change a meal name");
        System.out.println("7. Replace a Meal");
        System.out.println("8. Show foods from each meals");
        System.out.println("9. Show total calories");
        System.out.println("10. Show total nutrients");
        System.out.println("11. Show all meals information");
        System.out.println("42. Generate a list of meals");
        System.out.println("0. Exit");
    }

    public static int getUserChoice(Scanner scanner) {
        int userChoice = scanner.nextInt();
        scanner.nextLine();
        return userChoice;
    }

    public static void userAddMeal(Scanner scanner, MealService mealService) throws InvalidMealNameException {
        System.out.println("What type of meal:");
        System.out.println("1. Breakfast");
        System.out.println("2. Lunch");
        System.out.println("3. Dinner");
        System.out.println("4. Snack");

        int choiceMealType = getUserChoice(scanner);

        boolean mealAdded = false;
        do {
            System.out.println("What's the meal name:");
            String mealName = scanner.nextLine();
            try {
                switch (choiceMealType) {
                    case 1:
                        mealService.addMeal(new Breakfast(), mealName);
                        break;
                    case 2:
                        mealService.addMeal(new Lunch(), mealName);
                        break;
                    case 3:
                        mealService.addMeal(new Dinner(), mealName);
                        break;
                    case 4:
                        mealService.addMeal(new Snack(), mealName);
                        break;
                }
                System.out.println("Meal " + "\"" + mealName + "\"" + " added successfully.");
                mealAdded = true;
            } catch(InvalidMealNameException error) {
                System.out.print(error.getMessage());
            }
        } while (!mealAdded);
    }

    private static void userAddFoodToMeal(Scanner scanner, MealService mealService) throws MealNotFoundException {
        System.out.println("Select a meal to add food:");
        System.out.println(mealService.showMeals());

        int choiceMealToAddFood = getUserChoice(scanner);
        Meal mealToAddFoodTo = mealService.getMeal(choiceMealToAddFood);

        System.out.println("What's the food name:");
        String foodName = scanner.nextLine();

        System.out.println("How much protein has " + "\"" + foodName + "\"" + ":");
        double proteinAmount = scanner.nextDouble();
        System.out.println("How much carbohydrate has " + "\"" + foodName + "\"" + ":");
        double carbohydrateAmount = scanner.nextDouble();
        System.out.println("How much fats has " + "\"" + foodName + "\"" + ":");
        double fatAmount = scanner.nextDouble();

        Food foodToAdd = new Food(foodName, new Nutrient(proteinAmount, carbohydrateAmount, fatAmount));
        mealService.addFoodToMeal(mealToAddFoodTo, foodToAdd);
        System.out.println("\"" + foodName + "\"" + " added to " + "\"" + mealToAddFoodTo.getName() + " successfully");
    }

    private static void userShowMealSummary(Scanner scanner, MealService mealService) throws MealNotFoundException {
        System.out.println("Select a meal to view details:");
        System.out.println(mealService.showMeals());

        int choiceMealToView = getUserChoice(scanner);

        Meal mealToView = mealService.getMeal(choiceMealToView);
        System.out.println(mealToView.showDataSummary());
    }

    private static void userRemoveMeal(Scanner scanner, MealService mealService) throws MealNotFoundException {
        System.out.println("Select a meal to remove:");
        System.out.println(mealService.showMeals());

        int choiceMealToRemove = getUserChoice(scanner);
        Meal mealToRemove = mealService.getMeal(choiceMealToRemove);
        mealService.removeMeal(mealToRemove);

        System.out.println("Meal " + "\"" + mealToRemove.getName() + "\"" + " removed successfully");
    }

    private static void userRemoveFoodFromMeal(Scanner scanner, MealService mealService) throws MealNotFoundException {
        System.out.println("Select a meal to remove food:");
        System.out.println(mealService.showMeals());

        int choiceMealToRemoveFood = getUserChoice(scanner);
        Meal mealToRemoveFood = mealService.getMeal(choiceMealToRemoveFood);

        System.out.println("Select a food to remove from " + mealToRemoveFood.getName() + ":");
        System.out.print(mealToRemoveFood.showFoods());

        int choiceFoodToRemoveFromMeal = getUserChoice(scanner);

        Food foodToRemoveFromMeal = mealToRemoveFood.getFood(choiceFoodToRemoveFromMeal);
        mealService.removeFoodFromMeal(mealToRemoveFood, foodToRemoveFromMeal);
        System.out.println("\"" + foodToRemoveFromMeal.getName() + "\"" + " removed from " + "\"" + mealToRemoveFood.getName() + " successfully");
    }

    private static void userChangeMealName(Scanner scanner, MealService mealService) throws MealNotFoundException {
        System.out.println("Select a meal to change the name:");
        System.out.println(mealService.showMeals());

        int choiceMealToChangeName = getUserChoice(scanner);
        Meal mealToChangeName = mealService.getMeal(choiceMealToChangeName);

        boolean nameChanged = false;

        do {
            System.out.println("Choose a new name for meal " + "\"" + mealToChangeName.getName() + "\"");
            String newMealName = scanner.nextLine();

            try {
                mealService.setMealName(mealToChangeName, newMealName);
                nameChanged = true;

            } catch (InvalidMealNameException error) {
                System.out.print(error.getMessage());
            }
        } while (!nameChanged);
    }

    public static void userReplaceMeal(Scanner scanner, MealService mealService) throws MealNotFoundException {
        System.out.println("Select the meal that you want to replace:");
        System.out.println(mealService.showMeals());
        int mealToReplaceIndex = getUserChoice(scanner);
        String mealToReplaceName = mealService.getMeal(mealToReplaceIndex).getName();

        System.out.println("Select the meal that will replace:" + mealToReplaceName);
        System.out.println(mealService.showMeals());
        int mealThatReplaceIndex = getUserChoice(scanner);
        Meal mealThatReplace = mealService.getMeal(mealThatReplaceIndex);

        mealService.replaceMeal(mealToReplaceIndex, mealThatReplace);
        System.out.println("Meal: " + mealToReplaceName + " has been replaced by meal: " + mealThatReplace.getName());
    }

    public static void userShowFoodsFromMeals(MealService mealService) {
        System.out.println(mealService.showFoodsFromMeals());
    }

    public static void userShowTotalCalories(MealService mealService) {
        System.out.println("Total calories in all meals: " + mealService.getTotalCaloriesFromMeals());
    }

    public static void userShowTotalNutrients(MealService mealService) {
        Nutrient totalNutrients = mealService.getTotalNutrientsFromMeals();
        System.out.println("Total nutrients in all meals:");
        System.out.println(totalNutrients.getProtein() + " protein");
        System.out.println(totalNutrients.getCarbohydrates() + " carbohydrates");
        System.out.println(totalNutrients.getFats() + " fats");
    }

    public static void userShowAllMealsSummary(MealService mealService) {
        System.out.println(mealService.showDataSummaryFromMeals());
    }

    public static void userGenerateListOfMeals(MealService mealService) throws InvalidMealNameException {

        Meal fruitSalad = new Breakfast();
        mealService.addMeal(fruitSalad, "Fruit Salad");
        mealService.addFoodToMeal(fruitSalad, new Food("Apple", new Nutrient(2, 10, 1)));
        mealService.addFoodToMeal(fruitSalad, new Food("Coconut", new Nutrient(0, 5, 15)));
        mealService.addFoodToMeal(fruitSalad, new Food("Pineapple", new Nutrient(1, 8, 2)));

        Meal chickenMeal = new Lunch();
        mealService.addMeal(chickenMeal, "Chicken Rice");
        mealService.addFoodToMeal(chickenMeal, new Food("Grilled Chicken", new Nutrient(25, 0, 3)));
        mealService.addFoodToMeal(chickenMeal, new Food("Steamed Broccoli", new Nutrient(3, 6, 1)));
        mealService.addFoodToMeal(chickenMeal, new Food("Brown Rice", new Nutrient(4, 20, 1)));

        Meal pastaDish = new Dinner();
        mealService.addMeal(pastaDish, "Pasta with tomato sauce");
        mealService.addFoodToMeal(pastaDish, new Food("Spaghetti", new Nutrient(8, 40, 2)));
        mealService.addFoodToMeal(pastaDish, new Food("Tomato Sauce", new Nutrient(2, 10, 1)));
        mealService.addFoodToMeal(pastaDish, new Food("Parmesan Cheese", new Nutrient(5, 0, 3)));

        Meal yogurtSnack = new Snack();
        mealService.addMeal(yogurtSnack, "Yogurt Snack");
        yogurtSnack.addFood(new Food("Greek Yogurt", new Nutrient(12, 8, 0)));
        yogurtSnack.addFood(new Food("Blueberries", new Nutrient(1, 5, 0)));
        yogurtSnack.addFood(new Food("Granola", new Nutrient(3, 20, 5)));

        Meal vegetableSalad = new Lunch();
        mealService.addMeal(vegetableSalad, "Vegetable Salad");
        vegetableSalad.addFood(new Food("Lettuce", new Nutrient(1, 2, 0)));
        vegetableSalad.addFood(new Food("Tomato", new Nutrient(1, 4, 0)));
        vegetableSalad.addFood(new Food("Cucumber", new Nutrient(1, 3, 0)));

        Meal englishBreakfast = new Breakfast();
        mealService.addMeal(englishBreakfast, "English Breakfast");
        englishBreakfast.addFood(new Food("Sausages", new Nutrient(15, 5, 10)));
        englishBreakfast.addFood(new Food("Bacon", new Nutrient(10, 3, 8)));
        englishBreakfast.addFood(new Food("Eggs", new Nutrient(7, 1, 5)));
        englishBreakfast.addFood(new Food("Toast", new Nutrient(2, 8, 1)));

    }

    public static void userExit(Scanner scanner) {
        System.out.println("Exiting...");
        scanner.close();
        System.exit(0);
    }

}
