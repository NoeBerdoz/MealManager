package ch.heg.ig.sda.app;
import ch.heg.ig.sda.service.MealService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        MealService mealService = new MealService();
        Scanner scanner = new Scanner(System.in);

        showMainMenu();
        while (true) {
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("What type of meal:");
                    System.out.print("1. Breakfast");
                    System.out.print("1. Lunch");
                    System.out.print("1. Dinner");
                    System.out.print("1. Snack");
                    // TODO build a nested switch statement

                    System.out.println("Meal created successfully.");
                    break;
                case 2:
                    System.out.print("Select a meal to add food: ");
                    // TODO display meals with MealService
                    break;
                case 3:
                    System.out.print("Select a meal to view details: ");
                    // TODO display meals with MealService
                    break;
                case 4:
                    System.out.print("Select a meal to remove: ");
                    // TODO display meals with MealService
                    // use a try catch like this
                    //  try {
                    //      mealService.removeMeal(meal);
                    //  } catch (MealNotFoundException e) {
                    //      throw new RuntimeException(e);
                    //  }
                    break;
                case 5:
                    System.out.print("Select a meal to remove food: ");
                    // TODO display meals with MealService
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
        System.out.println("Welcome to your Meal Manager App");
        System.out.println("Select an action: ");
        System.out.println("1. Add a new meal");
        System.out.println("2. Add food to a meal");
        System.out.println("3. Display meal information");
        System.out.println("4. Remove a meal");
        System.out.println("5. Remove food from a meal");
        System.out.println("0. Exit");
    }
}
