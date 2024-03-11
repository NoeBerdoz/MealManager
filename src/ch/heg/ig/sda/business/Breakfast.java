package ch.heg.ig.sda.business;

public class Breakfast extends Meal {

    public Breakfast() {

    }

    @Override
    public String showDataSummary() {
        return "Breakfast named " + getName() + " that contains " + getTotalCalories() + " calories\n"
                + getTotalProtein() + " protein\n"
                + getTotalCarbohydrates() + " carbohydrates\n"
                + getTotalFats() + " fats";
    }
}


