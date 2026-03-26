import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        DietDAO dao     = new DietDAO();
        Scanner scanner = new Scanner(System.in);
        int choice      = 0;

        while (choice != 5) {
            System.out.println("\n==============================");
            System.out.println("   🥗 Healthy Diet Planner   ");
            System.out.println("==============================");
            System.out.println("1. Add Diet Plan");
            System.out.println("2. View All Plans");
            System.out.println("3. Update Diet Plan");
            System.out.println("4. Delete Diet Plan");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    System.out.print("Enter your name     : ");
                    String name = scanner.nextLine();
                    System.out.print("Enter your goal     : ");
                    String goal = scanner.nextLine();
                    System.out.print("Enter daily calories: ");
                    int cal = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter meal plan     : ");
                    String meal = scanner.nextLine();
                    dao.addPlan(name, goal, cal, meal);
                    break;

                case 2:
                    dao.viewAllPlans();
                    break;

                case 3:
                    System.out.print("Enter Plan ID to update : ");
                    int uid = scanner.nextInt();
                    System.out.print("Enter new calories      : ");
                    int newCal = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new meal plan     : ");
                    String newMeal = scanner.nextLine();
                    dao.updatePlan(uid, newCal, newMeal);
                    break;

                case 4:
                    System.out.print("Enter Plan ID to delete: ");
                    int did = scanner.nextInt();
                    dao.deletePlan(did);
                    break;

                case 5:
                    System.out.println("Goodbye! 👋");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }
}
