import java.util.*;

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
        System.out.println("9. Поиск сотрудников по заданным максимальному и минимальному порогу зарплат:");
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
                getMinSalaryAndPrint(EMPLOYEES);
                break;
            }
            case 4: {
                System.out.println("Список всех сотрудников и их данных:");
                allInfoOfEmployee(EMPLOYEES);
                System.out.println("Запрос на сотрудника с максимальной зарплатой.");
                getMaxSalaryAndPrint(EMPLOYEES);
                break;
            }
            case 5: {
                System.out.println("Список всех сотрудников и их данных:");
                allInfoOfEmployee(EMPLOYEES);
                System.out.println("Запрос на среднее значение зарплаты.");
                getAverageSalaryAndPrint(EMPLOYEES);
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
                getIndexedSalaryAndPrint(EMPLOYEES, getIndex());
                allInfoOfEmployee(EMPLOYEES);
                break;
            }
            case 8: {
                System.out.println("Список всех сотрудников и их данных:");
                allInfoOfEmployee(EMPLOYEES);
                final int iD = getDivision();
                allInfoOfEmployee(Objects.requireNonNull(getListOfEmployeeDivision(getEmployeesOfDivisionCount(iD), iD)));
                System.out.println();
                getMinSalaryAndPrint(Objects.requireNonNull(getListOfEmployeeDivision(getEmployeesOfDivisionCount(iD), iD)));
                getMaxSalaryAndPrint(Objects.requireNonNull(getListOfEmployeeDivision(getEmployeesOfDivisionCount(iD), iD)));
                getAverageSalaryAndPrint(Objects.requireNonNull(getListOfEmployeeDivision(getEmployeesOfDivisionCount(iD), iD)));
                getIndexedSalaryAndPrint(Objects.requireNonNull(getListOfEmployeeDivision(getEmployeesOfDivisionCount(iD), iD)), getIndex());
                System.out.println();
                System.out.println("Список сотрудников отдела [" + iD + "]");
                infoWithoutDivision(Objects.requireNonNull(getListOfEmployeeDivision(getEmployeesOfDivisionCount(iD), iD)));
                break;
            }
            case 9: {
                allInfoOfEmployee(EMPLOYEES);
                System.out.println("Поиск...");
                getEmployeesWithLowerSalary(EMPLOYEES);
                getEmployeesWithHigherSalary(EMPLOYEES);
                break;
            }
        }
    }

    private static Employee[] getListOfEmployeeDivision(int count, int iD) {
        if (count == 0) {
            System.out.println("Нет сотрудников в данном отделе!");
            return new Employee[0];
        } else if (count == 1) {
            System.out.println("В данном отделе только один сотрудник.");
            return new Employee[]{Main.EMPLOYEES[0]};
        } else {
            List<Employee> employeesOfDivision = new ArrayList<>(count);
            for (int i = 0; i < Main.EMPLOYEES.length; i++) {
                if (Main.EMPLOYEES[i].getDivision() == iD) {
                    employeesOfDivision.add(Main.EMPLOYEES[i]);
                }
            }
            Employee[] employeesOfDivisionArray = employeesOfDivision.toArray(new Employee[employeesOfDivision.size()]);
            return employeesOfDivisionArray;
        }
    }

    public static int getDivision() {
        System.out.println("Введите номер отдела:");
        Scanner indexDivision = new Scanner(System.in);
        return indexDivision.nextInt();
    }

    public static int getIndex() {
        System.out.println();
        Scanner persentageOfIndex = new Scanner(System.in);
        System.out.println("Введите процент зарплаты:");
        return persentageOfIndex.nextInt();
    }

    private static int getEmployeesOfDivisionCount(int iD) {
        int count = 0;
        for (Employee value : Main.EMPLOYEES) {
            if (value.getDivision() == iD) {
                count++;
            }
        }
        return count;
    }

    private static void getIndexedSalaryAndPrint(Employee[] employees, double pOI) {
        System.out.println();
        System.out.println("Список сотрудников с обновленными зарплатами:");
        pOI /= 100;
        for (Employee employee : employees) {
            employee.setSalary((int) (employee.getSalary() + employee.getSalary() * pOI));
        }
        allInfoOfEmployee(EMPLOYEES);
    }

    private static void getAverageSalaryAndPrint(Employee[] employees) {
        System.out.println("Среднее значение зарплаты: " + (int) (monthlyExpenses(employees) / employees.length));
    }

    private static void nameOfEmployee() {
        for (Employee employee : EMPLOYEES) {
            System.out.println(employee.getName());
        }
    }

    private static void getMaxSalaryAndPrint(Employee[] employee) {
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

    private static void getMinSalaryAndPrint(Employee[] employee) {
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

    private static void infoWithoutDivision(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            System.out.println("id [" + employees[i].getId() + "] " + employees[i].getName() + ", зарплата сотрудника - " + employees[i].getSalary());
        }
    }

    private static void getEmployeesWithLowerSalary(Employee[] employee) {
        System.out.println("Введите число, для получения списка сотрудников с меньшей зарплатой:");
        Scanner lowSalary = new Scanner(System.in);
        int lS = lowSalary.nextInt();
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getSalary() < lS) {
                System.out.println(employee[i].getName() + " " + employee[i].getSalary());
            }
        }
    }

    private static void getEmployeesWithHigherSalary(Employee[] employee) {
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