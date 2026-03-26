public class DietPlan {
    int    id;
    String name;
    String goal;
    int    calories;
    String mealPlan;

    // Constructor
    DietPlan(int id, String name, String goal, int calories, String mealPlan) {
        this.id       = id;
        this.name     = name;
        this.goal     = goal;
        this.calories = calories;
        this.mealPlan = mealPlan;
    }
}