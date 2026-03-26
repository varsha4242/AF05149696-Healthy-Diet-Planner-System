import java.sql.*;

public class DietDAO {

    Connection con = DBConnection.getConnection();

    // ───── CREATE ─────────────────────────────────
    public void addPlan(String name, String goal, int calories, String mealPlan) {
        try {
            String sql = "INSERT INTO diet_plans (name, goal, calories, meal_plan) VALUES (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, goal);
            ps.setInt   (3, calories);
            ps.setString(4, mealPlan);
            ps.executeUpdate();
            System.out.println("✅ Diet Plan Added Successfully!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ───── READ (View All) ────────────────────────
    public void viewAllPlans() {
        try {
            String sql = "SELECT * FROM diet_plans";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            System.out.println("\n---- All Diet Plans ----");
            while (rs.next()) {
                System.out.println(
                    "ID: "       + rs.getInt("id")           +
                    " | Name: "  + rs.getString("name")      +
                    " | Goal: "  + rs.getString("goal")      +
                    " | Cal: "   + rs.getInt("calories")     +
                    " | Meal: "  + rs.getString("meal_plan")
                );
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ───── UPDATE ─────────────────────────────────
    public void updatePlan(int id, int newCalories, String newMealPlan) {
        try {
            String sql = "UPDATE diet_plans SET calories=?, meal_plan=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt   (1, newCalories);
            ps.setString(2, newMealPlan);
            ps.setInt   (3, id);
            ps.executeUpdate();
            System.out.println("✅ Diet Plan Updated!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ───── DELETE ─────────────────────────────────
    public void deletePlan(int id) {
        try {
            String sql = "DELETE FROM diet_plans WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("🗑️ Diet Plan Deleted!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}