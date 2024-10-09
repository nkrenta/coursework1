import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class EmployeeBook {
    private final static Random RANDOM = new Random();
    private final static String[] FIRSTNAMES = {"Тимофей", "Владислав", "Александр", "Алексей", "Петр", "Иван"};
    private final static String[] SECONDNAMES = {"Иванович", "Петрович", "Дмитриевич", "Алексеевич", "Матвеевич", "Александрович"};
    private final static String[] LASTNAMES = {"Иванов", "Петров", "Сидоров", "Капушин", "Пупкин", "Купцов", "Молчанов", "Сидоров"};

    private final static Employee[] EMPLOYEES = new Employee[10];

    private void initEmployees() {
        for (int i = 0; i < EMPLOYEES.length - 2; i++) {
            String lastName = LASTNAMES[RANDOM.nextInt(0, LASTNAMES.length)];
            String firstName = FIRSTNAMES[RANDOM.nextInt(0, FIRSTNAMES.length)];
            String secondName = SECONDNAMES[RANDOM.nextInt(0, SECONDNAMES.length)];
            EMPLOYEES[i] = new Employee(new NameOfWorker(lastName, firstName, secondName), RANDOM.nextInt(1, 6), RANDOM.nextInt(40000, 110000));
        }
    }

    private void addEmployee() {
        for (int i = 0; i < EMPLOYEES.length; i++) {
            if (EMPLOYEES[i] == null) {

                Scanner lastName = new Scanner(System.in);
                System.out.println("Input last name:");
                String lN = lastName.nextLine();

                Scanner firstName = new Scanner(System.in);
                System.out.println("Input first name:");
                String fN = firstName.nextLine();

                Scanner secondName = new Scanner(System.in);
                System.out.println("Input second name:");
                String sN = secondName.nextLine();

                Scanner divisionO = new Scanner(System.in);
                System.out.println("Input division of worker:");
                int division = divisionO.nextInt();

                Scanner salaryO = new Scanner(System.in);
                System.out.println("Input the salary:");
                int salary = salaryO.nextInt();

                EMPLOYEES[i] = new Employee(new NameOfWorker(lN, fN, sN), division, salary);
                System.out.println("Сотрудник добавлен!");
                return;
            }
        }
    }

    private void deleteEmployee() {
        System.out.println("Введите номер сотрудника, которого хотите удалить:");
        Scanner indexDelete = new Scanner(System.in);
        int index = indexDelete.nextInt();

        if (index < 0 || index >= EMPLOYEES.length) {
            System.out.println("Такого сотрудника нет!");
        } else {
            EMPLOYEES[index] = null;
            System.out.println("Сотрудник удален!");
        }
    }

    private Employee[] getListOfEmployeeDivision(int count, int iD) {
        if (count == 0) {
            System.out.println("Нет сотрудников в данном отделе!");
            return new Employee[0];
        } else if (count == 1) {
            System.out.println("В данном отделе только один сотрудник.");
            return new Employee[]{EMPLOYEES[0]};
        } else {
            List<Employee> employeesOfDivision = new ArrayList<>(count);
            for (int i = 0; i < EMPLOYEES.length; i++) {
                if (EMPLOYEES[i].getDivision() == iD) {
                    employeesOfDivision.add(EMPLOYEES[i]);
                }
            }
            Employee[] employeesOfDivisionArray = employeesOfDivision.toArray(new Employee[employeesOfDivision.size()]);
            return employeesOfDivisionArray;
        }
    }

    public int getDivision() {
        System.out.println("Введите номер отдела:");
        Scanner indexDivision = new Scanner(System.in);
        return indexDivision.nextInt();
    }

    public int getIndex() {
        System.out.println();
        Scanner persentageOfIndex = new Scanner(System.in);
        System.out.println("Введите процент зарплаты:");
        return persentageOfIndex.nextInt();
    }

    private int getEmployeesOfDivisionCount(int iD) {
        int count = 0;
        for (Employee value : EMPLOYEES) {
            if (value.getDivision() == iD) {
                count++;
            }
        }
        return count;
    }

    private void getIndexedSalaryAndPrint(Employee[] employees, double pOI) {
        System.out.println();
        System.out.println("Список сотрудников с обновленными зарплатами:");
        pOI /= 100;
        for (Employee employee : employees) {
            employee.setSalary((int) (employee.getSalary() + employee.getSalary() * pOI));
        }
        allInfoOfEmployee(EMPLOYEES);
    }

    private void getAverageSalaryAndPrint(Employee[] employees) {
        System.out.println("Среднее значение зарплаты: " + (int) (monthlyExpenses(employees) / employees.length));
    }

    private void nameOfEmployee() {
        for (Employee employee : EMPLOYEES) {
            System.out.println(employee.getName());
        }
    }

    private void getMaxSalaryAndPrint(Employee[] employee) {
        int maxSalary = employee[0].getSalary();
        for (int i = 1; i < employee.length; i++) {
            if (employee[i].getSalary() > maxSalary) {
                maxSalary = employee[i].getSalary();
            }
        }
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getSalary() == maxSalary) {
                System.out.println("Сотрудник с максимальной ЗП: " + employee[i].getName() + " " + employee[i].getSalary());
            }
        }
    }

    private void getMinSalaryAndPrint(Employee[] employee) {
        int minSalary = employee[0].getSalary();
        for (int i = 1; i < employee.length; i++) {
            if (employee[i].getSalary() < minSalary) {
                minSalary = employee[i].getSalary();
            }
        }
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getSalary() == minSalary) {
                System.out.println("Сотрудник с минимальной ЗП: " + employee[i].getName() + " " + employee[i].getSalary());
            }
        }
    }

    private void allInfoOfEmployee(Employee[] employees) {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    private double monthlyExpenses(Employee[] employees) {
        int sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return sum;
    }

    private void infoWithoutDivision(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            System.out.println("id [" + employees[i].getId() + "] " + employees[i].getName() + ", зарплата сотрудника - " + employees[i].getSalary());
        }
    }

    private void getEmployeesWithLowerSalary(Employee[] employee) {
        System.out.println("Введите число, для получения списка сотрудников с меньшей зарплатой:");
        Scanner lowSalary = new Scanner(System.in);
        int lS = lowSalary.nextInt();
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getSalary() < lS) {
                System.out.println(employee[i].getName() + " " + employee[i].getSalary());
            }
        }
    }

    private void getEmployeesWithHigherSalary(Employee[] employee) {
        System.out.println("Введите число, для получения списка сотрудников с большей зарплатой:");
        Scanner highSalary = new Scanner(System.in);
        int hS = highSalary.nextInt();
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getSalary() > hS) {
                System.out.println(employee[i].getName() + " " + employee[i].getSalary());
            }
        }
    }
}
