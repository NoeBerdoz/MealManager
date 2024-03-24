package ch.heg.ig.sda.business;

public class Nutrient {
    public static final double CAL_PER_PROTEIN = 4.0;
    public static final double CAL_PER_CARBOHYDRATE = 4.0;
    public static final double CALORIES_PER_FAT = 9.0;
    private double protein;
    private double carbohydrates;
    private double fats;

    public Nutrient() {

    }

    public Nutrient(double protein, double carbohydrates, double fats) {
        this.protein = protein;
        this.carbohydrates = carbohydrates;
        this.fats = fats;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public double getFats() {
        return fats;
    }

    public void setFats(double fats) {
        this.fats = fats;
    }

    public double getCalories() {

        return getProtein() * Nutrient.CAL_PER_PROTEIN +
                getCarbohydrates() * Nutrient.CAL_PER_CARBOHYDRATE +
                getFats() * Nutrient.CALORIES_PER_FAT;
    }
}
