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
    public static void main(String[] args) {
        //Method for getting the list of Employee
        Employee[] dataBase = getEmployees();

        //UI for communication
        System.out.println("Выберите действие и напишите его порядковый номер:");
        System.out.println("1. Получить список всех сотрудников со всеми имеющимися по ним данными");
        System.out.println("2. Посчитать сумму затрат на ЗП в месяц");
        System.out.println("3. Найти сотрудника с минимальной ЗП");
        System.out.println("4. Найти сотрудника с максимальной ЗП");
        System.out.println("5. Подсчитать среднее значение зарплат");
        System.out.println("6. Распечатать ФИО всех сотрудников");
        Scanner option = new Scanner(System.in);
        switch (option.nextInt()) {
            case 1: {
                System.out.println("Список всех сотрудников и их данных:");
                allInfoOfEmployee(dataBase);
                break;
            }
            case 2: {
                System.out.println("Запрос по затратам в месяц.");
                System.out.println("Сумма затрат по ЗП в месяц составляет " + monthlyExpenses(dataBase));
                break;
            }
            case 3: {
                System.out.println("Запрос на сотрудника с минимальной зарплатой.");
                int minSalary = getMinSalary(dataBase);
                for (Employee employee : dataBase) {
                    if (employee.getSalary() == minSalary) {
                        System.out.println("Сотрудник с минимальной ЗП: " + employee.getName() + " " + employee.getSalary());
                    }
                }
                break;
            }
            case 4: {
                System.out.println("Запрос на сотрудника с максимальной зарплатой.");
                int maxSalary = getMaxSalary(dataBase);
                for (Employee employee : dataBase) {
                    if (employee.getSalary() == maxSalary) {
                        System.out.println("Сотрудник с максимальной ЗП: " + employee.getName() + " " + employee.getSalary());
                    }
                }
                break;
            }
            case 5: {
                System.out.println("Запрос на среднее значение зарплаты.");
                double averageSalary = getAverageSalary(dataBase);
                System.out.println("Среднее значение зарплаты: " + averageSalary);
                break;
            }
            case 6: {
                System.out.println("Запрос на печать ФИО всех сотрудников.");
                nameOfEmployee(dataBase);
                break;
            }
        }
    }

    private static double getAverageSalary(Employee[] dataBase) {
        return monthlyExpenses(dataBase) / dataBase.length;
    }

    private static void nameOfEmployee(Employee[] dataBase) {
        for (Employee employee : dataBase) {
            System.out.println(employee.getName());
        }
    }

    private static int getMaxSalary(Employee[] dataBase) {
        int maxSalary = dataBase[0].getSalary();
        for (int i = 1; i < dataBase.length; i++) {
            if (dataBase[i].getSalary() > maxSalary) {
                maxSalary = dataBase[i].getSalary();
            }
        }
        return maxSalary;
    }

    private static int getMinSalary(Employee[] dataBase) {
        int minSalary = dataBase[0].getSalary();
        for (int i = 1; i < dataBase.length; i++) {
            if (dataBase[i].getSalary() < minSalary) {
                minSalary = dataBase[i].getSalary();
            }
        }
        return minSalary;
    }

    private static void allInfoOfEmployee(Employee[] dataBase) {
        for (Employee employee : dataBase) {
            System.out.println(employee);
        }
    }

    private static double monthlyExpenses(Employee[] dataBase) {
        int sum = 0;
        for (Employee employee : dataBase) {
            sum += employee.getSalary();
        }
        return sum;
    }

    private static Employee[] getEmployees() {
        Employee worker1 = new Employee(new NameOfWorker("Иванов", "Иван", "Иванович"), 1, 70000);
        Employee worker2 = new Employee(new NameOfWorker("Петров", "Петр", "Петрович"), 2, 65000);
        Employee worker3 = new Employee(new NameOfWorker("Сидоров", "Алексей", "Дмитриевич"), 3, 60000);
        Employee worker4 = new Employee(new NameOfWorker("Капушин", "Александр", "Алексеевич"), 3, 54000);
        Employee worker5 = new Employee(new NameOfWorker("Пупкин", "Владислав", "Дмитриевич"), 3, 90000);
        Employee worker6 = new Employee(new NameOfWorker("Купцов", "Петр", "Дмитриевич"), 3, 100000);
        Employee worker7 = new Employee(new NameOfWorker("Молчанов", "Тимофей", "Матвеевич"), 3, 55000);
        Employee worker8 = new Employee(new NameOfWorker("Сидоров", "Алексей", "Дмитриевич"), 3, 89000);
        Employee worker9 = new Employee(new NameOfWorker("Сидоров", "Алексей", "Дмитриевич"), 3, 57000);
        Employee worker10 = new Employee(new NameOfWorker("Сидоров", "Алексей", "Дмитриевич"), 3, 67800);

        Employee[] dataBase = {worker1, worker2, worker3, worker4, worker5, worker6, worker7, worker8, worker9, worker10};
        return dataBase;
    }
}