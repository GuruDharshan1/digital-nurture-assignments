public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private float salary;

    public Employee() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public float getSalary() { return salary; }
    public void setSalary(float salary) { this.salary = salary; }

    @Override
    public String toString() {
        return id + ": " + firstName + " " + lastName + " - " + salary;
    }
}
