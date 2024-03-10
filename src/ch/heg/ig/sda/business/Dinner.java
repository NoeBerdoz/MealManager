package ch.heg.ig.sda.business;

public class Dinner extends Meal {

    public Dinner(String name) {
        super(name);
    }

    @Override
    public String showDataSummary() {
        return "Dinner named " + getName() + " that contains " + getTotalCalories() + " calories\n"
                + getTotalProtein() + " protein\n"
                + getTotalCarbohydrates() + " carbohydrates\n"
                + getTotalFats() + " fats";
    }
}
