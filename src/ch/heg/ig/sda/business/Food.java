package ch.heg.ig.sda.business;

public class Food {
    private String name;
    private Nutrient nutrients;

    public Food() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Nutrient getNutrients() {
        return nutrients;
    }

    public void setNutrients(Nutrient nutrients) {
        this.nutrients = nutrients;
    }
}
