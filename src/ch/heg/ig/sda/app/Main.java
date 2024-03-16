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

        // TODO implement new methods, main is way too long
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
                    System.out.print("Select a meal to remove:\n");
                    System.out.println(mealService.showMeals());

                    int choiceMealToRemove = getUserChoice(scanner);
                    Meal mealToRemove = mealService.getMeal(choiceMealToRemove);
                    mealService.removeMeal(mealToRemove);

                    System.out.println("Meal " + "\"" + mealToRemove.getName() + "\"" + " removed successfully\n");
                    break;
                case 5:
                    System.out.print("Select a meal to remove food:\n");
                    System.out.println(mealService.showMeals());

                    int choiceMealToRemoveFood = getUserChoice(scanner);
                    Meal mealToRemoveFood = mealService.getMeal(choiceMealToRemoveFood);

                    System.out.print("Select a food to remove from " + mealToRemoveFood.getName() + ":\n");
                    System.out.print(mealToRemoveFood.showFoods());

                    int choiceFoodToRemoveFromMeal = getUserChoice(scanner);

                    Food foodToRemoveFromMeal = mealToRemoveFood.getFood(choiceFoodToRemoveFromMeal);
                    mealService.removeFoodFromMeal(mealToRemoveFood, foodToRemoveFromMeal);
                    System.out.println("\"" + foodToRemoveFromMeal.getName() + "\"" + " removed from " + "\"" + mealToRemoveFood.getName() + " successfully\n");
                    break;
                case 6:
                    System.out.print("Select a meal to change the name:\n");
                    mealService.showMeals();
                    System.out.println(mealService.showMeals());

                    int choiceMealToChangeName = getUserChoice(scanner);
                    Meal mealToChangeName = mealService.getMeal(choiceMealToChangeName);

                    System.out.print("Choose a new name for meal " + "\"" + mealToChangeName.getName() + "\"\n");
                    String newMealName = scanner.nextLine();

                    try {
                        mealService.changeMealName(mealToChangeName, newMealName);
                    } catch (InvalidMealNameException error) {
                        System.out.print(error.getMessage());
                        // TODO implement a way for the user to try again
                        System.out.print("\nGoing back to main menu...");
                        continue;
                    }
                    break;
                case 0:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice, try again entering a valid choice number.");
            }
        }
    }

    public static void showMainMenu() {
        System.out.println("Select an action:");
        System.out.println("1. Add a new meal");
        System.out.println("2. Add food to a meal");
        System.out.println("3. Display meal information");
        System.out.println("4. Remove a meal");
        System.out.println("5. Remove food from a meal");
        System.out.println("6. Change a meal name");
        System.out.println("0. Exit");
    }

    public static int getUserChoice(Scanner scanner) {
        int userChoice = scanner.nextInt();
        scanner.nextLine();
        return userChoice;
    }

    public static void userAddMeal(Scanner scanner, MealService mealService) throws InvalidMealNameException {
        System.out.print("What type of meal:\n");
        System.out.print("1. Breakfast\n");
        System.out.print("2. Lunch\n");
        System.out.print("3. Dinner\n");
        System.out.print("4. Snack\n");

        int choiceMealType = getUserChoice(scanner);

        System.out.print("What's the meal name:\n");
        String mealName = scanner.nextLine();

        switch (choiceMealType) {
            case 1:
                createMeal(new Breakfast(), mealName, mealService);
                break;
            case 2:
                createMeal(new Lunch(), mealName, mealService);
                break;
            case 3:
                createMeal(new Dinner(), mealName, mealService);
                break;
            case 4:
                createMeal(new Snack(), mealName, mealService);
                break;
        }

        System.out.println("Meal " + "\"" + mealName + "\"" + " created successfully.\n");

    }

    private static void createMeal(Meal meal, String mealName, MealService mealService) throws InvalidMealNameException {
        meal.setName(mealName);
        mealService.addMeal(meal);
    }

    private static void userAddFoodToMeal(Scanner scanner, MealService mealService) throws MealNotFoundException {
        System.out.print("Select a meal to add food:\n");
        System.out.println(mealService.showMeals());

        int choiceMealToAddFood = getUserChoice(scanner);
        Meal mealToAddFoodTo = mealService.getMeal(choiceMealToAddFood);

        System.out.print("What's the food name:\n");
        String foodName = scanner.nextLine();

        System.out.print("How much protein has " + "\"" + foodName + "\"" + ":\n");
        double proteinAmount = scanner.nextDouble();
        System.out.print("How much carbohydrate has " + "\"" + foodName + "\"" + ":\n");
        double carbohydrateAmount = scanner.nextDouble();
        System.out.print("How much fats has " + "\"" + foodName + "\"" + ":\n");
        double fatAmount = scanner.nextDouble();

        Food foodToAdd = new Food(foodName, new Nutrient(proteinAmount, carbohydrateAmount, fatAmount));
        mealService.addFoodToMeal(mealToAddFoodTo, foodToAdd);
        System.out.println("\"" + foodName + "\"" + " added to " + "\"" + mealToAddFoodTo.getName() + " successfully\n");
    }

    private static void userShowMealSummary(Scanner scanner, MealService mealService) throws MealNotFoundException {
        System.out.print("Select a meal to view details:\n");
        System.out.println(mealService.showMeals());

        int choiceMealToView = getUserChoice(scanner);

        Meal mealToView = mealService.getMeal(choiceMealToView);
        System.out.println(mealToView.showDataSummary());
    }



}
