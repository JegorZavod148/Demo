public class Employee {

    String name;
    float pay;
    String place;

    public Employee(String name, float pay, String place){
        this.name = name;
        this.pay = pay;
        this.place = place;
    }

    public String getName() {
        return name;
    }

    public float getPay() {
        return pay;
    }

    public String getPlace() {
        return place;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(float pay) {
        this.pay = pay;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getInfo() {
        return "Ім'я: " + name + ", Зарплата: " + pay + ", Відділ: " + place;
    }
}
