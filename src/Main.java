import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {
    /*LightVersion
    Создать класс Employee, который содержит информацию о ФИО, отделе и зарплате сотрудника. Отделы для простоты должны быть названы от 1 до 5.
    Добавить статическую переменную-счетчик, которая будет отвечать за id.
    Добавить в класс Employee поле id, которое проставляется из счетчика, а затем счетчик увеличивает свое значение.
    Скрыть прямой доступ к полям класса Employee и добавить возможность получать значения полей (геттеры) и устанавливать значения полей отдела и зарплаты (сеттеры).
    Реализовать в классе Employee контракты equals и hashCode.
    По-умолчанию все поля должны передаваться через конструктор (кроме id) и заполняться в нем (включая id, который нужно получить из счетчика).
    Создать внутри класса Main метод main и поле типа Employee[10], которое будет выполнять роль "хранилища" для записей о сотрудниках.
    Создать статические методы, которые будут взаимодействовать с массивом из пункта 6 и возвращать результат:
    Получить список всех сотрудников со всеми имеющимися по ним данными (вывести в консоль значения всех полей (toString));
    Посчитать сумму затрат на ЗП в месяц;
    Найти сотрудника с минимальной ЗП;
    Найти сотрудника с максимальной ЗП;
    Подсчитать среднее значение зарплат (можно использовать для этого метод из пункта b);
    Распечатать ФИО всех сотрудников (метод ничего).
    */

    private final static Random RANDOM = new Random();
    private final static String[] FIRSTNAMES = {"Тимофей", "Владислав", "Александр", "Алексей", "Петр", "Иван"};
    private final static String[] SECONDNAMES = {"Иванович", "Петрович", "Дмитриевич", "Алексеевич", "Матвеевич", "Александрович"};
    private final static String[] LASTNAMES = {"Иванов", "Петров", "Сидоров", "Капушин", "Пупкин", "Купцов", "Молчанов", "Сидоров"};

    private final static Employee[] EMPLOYEES = new Employee[10];

    private static void initEmployees() {
        for (int i = 0; i < EMPLOYEES.length; i++) {
            String lastName = LASTNAMES[RANDOM.nextInt(0, LASTNAMES.length)];
            String firstName = FIRSTNAMES[RANDOM.nextInt(0, FIRSTNAMES.length)];
            String secondName = SECONDNAMES[RANDOM.nextInt(0, SECONDNAMES.length)];
            EMPLOYEES[i] = new Employee(new NameOfWorker(lastName, firstName, secondName), RANDOM.nextInt(1, 6), RANDOM.nextInt(40000, 110000));
        }
    }


    public static void main(String[] args) {
        //Method for getting the list of Employee
        initEmployees();

        //UI for communication
        System.out.println("Выберите действие и напишите его порядковый номер:");
        System.out.println("1. Получить список всех сотрудников со всеми имеющимися по ним данными");
        System.out.println("2. Посчитать сумму затрат на ЗП в месяц");
        System.out.println("3. Найти сотрудника с минимальной ЗП");
        System.out.println("4. Найти сотрудника с максимальной ЗП");
        System.out.println("5. Подсчитать среднее значение зарплат");
        System.out.println("6. Распечатать ФИО всех сотрудников");
        System.out.println("7. Индексация заработной платы");
        System.out.println("8. Данные по отделу");
        Scanner option = new Scanner(System.in);
        switch (option.nextInt()) {
            case 1: {
                System.out.println("Список всех сотрудников и их данных:");
                allInfoOfEmployee(EMPLOYEES);
                break;
            }
            case 2: {
                System.out.println("Список всех сотрудников и их данных:");
                allInfoOfEmployee(EMPLOYEES);
                System.out.println("Запрос по затратам в месяц.");
                System.out.println("Сумма затрат по ЗП в месяц составляет " + monthlyExpenses(EMPLOYEES));
                break;
            }
            case 3: {
                System.out.println("Список всех сотрудников и их данных:");
                allInfoOfEmployee(EMPLOYEES);
                System.out.println("Запрос на сотрудника с минимальной зарплатой.");
                int minSalary = getMinSalary(EMPLOYEES);
                for (Employee employee : EMPLOYEES) {
                    if (employee.getSalary() == minSalary) {
                        System.out.println("Сотрудник с минимальной ЗП: " + employee.getName() + " " + employee.getSalary());
                    }
                }
                break;
            }
            case 4: {
                System.out.println("Список всех сотрудников и их данных:");
                allInfoOfEmployee(EMPLOYEES);
                System.out.println("Запрос на сотрудника с максимальной зарплатой.");
                int maxSalary = getMaxSalary(EMPLOYEES);
                for (Employee employee : EMPLOYEES) {
                    if (employee.getSalary() == maxSalary) {
                        System.out.println("Сотрудник с максимальной ЗП: " + employee.getName() + " " + employee.getSalary());
                    }
                }
                break;
            }
            case 5: {
                System.out.println("Список всех сотрудников и их данных:");
                allInfoOfEmployee(EMPLOYEES);
                System.out.println("Запрос на среднее значение зарплаты.");
                double averageSalary = getAverageSalary(EMPLOYEES);
                System.out.println("Среднее значение зарплаты: " + averageSalary);
                break;
            }
            case 6: {
                System.out.println("Список всех сотрудников и их данных:");
                allInfoOfEmployee(EMPLOYEES);
                System.out.println("Запрос на печать ФИО всех сотрудников.");
                nameOfEmployee();
                break;
            }
            case 7: {
                System.out.println("Список всех сотрудников и их данных:");
                allInfoOfEmployee(EMPLOYEES);
                System.out.println("Индексация зарплаты");
                getIndexedSalary(EMPLOYEES);
                allInfoOfEmployee(EMPLOYEES);
                break;
            }
            case 8: {
                System.out.println("Список всех сотрудников и их данных:");
                allInfoOfEmployee(EMPLOYEES);
                //allInfoOfEmployee(Objects.requireNonNull(getEmployeesOfDivision(EMPLOYEES)));
                getMinSalary(Objects.requireNonNull(getEmployeesOfDivision(EMPLOYEES)));
                getMaxSalary(Objects.requireNonNull(getEmployeesOfDivision(EMPLOYEES)));
                getAverageSalary(getEmployeesOfDivision(EMPLOYEES));
                getIndexedSalary(Objects.requireNonNull(getEmployeesOfDivision(EMPLOYEES)));

            }
        }
    }

    private static Employee[] getEmployeesOfDivision(Employee[] employees) {
        Scanner indexDivision = new Scanner(System.in);
        System.out.println("Введите номер отдела:");
        int iD = indexDivision.nextInt();
        indexDivision.close();
        System.out.println("Сотрудники в отделе " + iD + ":");
        int count = 0;
        for (Employee employee : employees) {
            if (employee.getDivision() == iD) {
                System.out.println(employee);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Нет сотрудников в данном отделе!");
            return null;
        } else if (count == 1) {
            System.out.println("В данном отделе только один сотрудник.");
            return new Employee[]{employees[0]};
        } else {
            Employee[] employeeOfDivision = new Employee[count];
            for (int i = 0; i < employees.length; i++) {
                if (employees[i].getDivision() == iD) {
                    employeeOfDivision[i] = employees[i];
                }
            }
            return employeeOfDivision;
        }
    }

    private static void getIndexedSalary(Employee[] employees) {
        Scanner persentageOfIndex = new Scanner(System.in);
        System.out.println("Введите процент зарплаты:");
        double pOI = persentageOfIndex.nextDouble();
        persentageOfIndex.close();
        pOI /= 100;
        for (Employee employee : employees) {
            employee.setSalary((int) (employee.getSalary() + employee.getSalary() * pOI));
        }
    }

    private static double getAverageSalary(Employee[] employees) {
        return monthlyExpenses(employees) / employees.length;
    }

    private static void nameOfEmployee() {
        for (Employee employee : EMPLOYEES) {
            System.out.println(employee.getName());
        }
    }

    private static int getMaxSalary(Employee[] employee) {
        int maxSalary = employee[0].getSalary();
        for (int i = 1; i < employee.length; i++) {
            if (employee[i].getSalary() > maxSalary) {
                maxSalary = employee[i].getSalary();
            }
        }
        return maxSalary;
    }

    private static int getMinSalary(Employee[] employees) {
        int minSalary = employees[0].getSalary();
        for (int i = 1; i < employees.length; i++) {
            if (employees[i].getSalary() < minSalary) {
                minSalary = employees[i].getSalary();
            }
        }
        return minSalary;
    }

    private static void allInfoOfEmployee(Employee[] employees) {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    private static double monthlyExpenses(Employee[] employees) {
        int sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return sum;
    }
}