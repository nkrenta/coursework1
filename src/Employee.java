public class Employee {

    private static int idGenerator = 1;

    private final int id;
    private final NameOfWorker name;
    private int division;
    private int salary;

    public Employee(NameOfWorker name, int division, int salary) {
        id = idGenerator++;
        this.name = name;
        this.division = division;
        this.salary = salary;
    }

    public int getDivision() {
        return division;
    }

    public void setDivision(int division) {
        this.division = division;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public NameOfWorker getName() {
        return name;
    }

    @Override
    public String toString() {
        return "id[" + id + "], " + name.toString() +
                ", отдел [" + division + "]" +
                ", зарплата сотрудника - " + salary;
    }
}
