package ch.heg.ig.sda.business;

public class Lunch extends Meal {

    public Lunch() {

    }

    @Override
    public String showDataSummary() {
        return "Lunch named " + getName() + " that contains " + getTotalCalories() + " calories\n"
                + getTotalProtein() + " protein\n"
                + getTotalCarbohydrates() + " carbohydrates\n"
                + getTotalFats() + " fats";
    }
}
