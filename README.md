# Meal Manager App

## Presentation

The **Meal Manager** application aims to allow users to manage meals. Users can create, rename, delete, modify, and display meals.  

Meals are defined by 4 choices: **Breakfast**, **Lunch**, **Dinner**, and **Snack**. A meal consists of a list of food. 
Food is composed of a name and nutrients. Nutrients consist of proteins, carbohydrates, and fats. Users can add or remove food from a meal. 

The application was built with English as the chosen language; both code and comments are in English only.

## Code Structure

The **Meal** class is an abstract class inherited by the **Breakfast**, **Lunch**, **Dinner**, and **Snack** classes. These classes exhibit polymorphic behavior through their **showDataSummary()** method.

The **Meal** class has attributes **name** and **foods**, where **foods** is an ArrayList of **Food** objects. This **ArrayList** implements the **List** interface. 
**Meal** also has methods to manage the list of foods, display food names, and show a summary of the total nutrients and calorie count of the meal. 

**Food** is a class with attributes **name** and **nutrients**, defined by the **Nutrient** class. 

**Nutrient** consists of attributes **protein**, **carbohydrates**, and **fats**, and a **getCalories()** method to return the total calorie count of the nutrients. 

Scientifically, 1 gram of protein provides 4 calories, 1 gram of carbohydrates provides 4 calories, and 1 gram of fats provides 9 calories; these values are defined as constants.

The **IMealService** interface is implemented by the **MealService** class, which manages **Meal** objects. 

**MealService** is composed of an ArrayList of **Meal** named **meals**. **MealService** allows management of this list, displays meal names, displays the names of foods in their list, modifies a meal's name, and shows a summary of all meals in the list with their name, calorie count, and nutrient count.

The **Main** class allows interaction with the ecosystem implemented by the previously presented classes. It displays a menu to the user and uses a Scanner to handle user input. 
When a user attempts to modify a meal's name with a special character, the **Meal** class throws an **InvalidMealNameException** from the **setName()** method. This exception is then caught and thrown again from the **changeMealName()** method of the **MealService**. In **Main**, the error is handled by a try-catch statement, returning the user to the main menu.

**InvalidMealNameException** inherits from the Java **Exception** class and calls the inherited constructor with the super statement.

## Software Architecture
The file structure consists of three main layers: **app**, **business**, **service**, and an additional **datastructure** layer.

## Class diagram
![final_uml](https://github.com/NoeBerdoz/MealManager/assets/44669187/e2b73cbf-b2d3-4df4-8647-c8c3fd895012)

