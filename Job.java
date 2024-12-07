import java.util.ArrayList;
public class Job {

    static ArrayList<Employee> employees = new ArrayList<>();

    public static void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Працівника додано: " + employee.getName());
    }

    public static void removeEmployee(String name) {
        employees.removeIf(employee -> employee.getName().equalsIgnoreCase(name));
        System.out.println("Працівника \"" + name + "\" видалено.");
    }

    public static float totalPay() {
        float total = 0;
        for (Employee employee : employees) {
            total += employee.getPay();
        }
        return total;
    }

    public static float averagePay() {
        if (employees.isEmpty()) {
            return 0;
        }
        return totalPay() / employees.size();
    }
}
