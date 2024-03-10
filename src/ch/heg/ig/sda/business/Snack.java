package ch.heg.ig.sda.business;

public class Snack extends Meal {

    public Snack() {

    }

    @Override
    public String showDataSummary() {
        return "Snack named " + getName() + " that contains " + getTotalCalories() + " calories\n"
                + getTotalProtein() + " protein\n"
                + getTotalCarbohydrates() + " carbohydrates\n"
                + getTotalFats() + " fats";
    }

}
