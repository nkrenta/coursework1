import java.util.Objects;
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
        System.out.println("10. Добавить сотрудника:");
        System.out.println("11. Удаление сотрудника:");
        System.out.println("12. Получить сотрудника по ID:");
        Scanner option = new Scanner(System.in);
        switch (option.nextInt()) {
            case 1: {
                System.out.println("Список всех сотрудников и их данных:");
                EmployeeBook.allInfoOfEmployee(EmployeeBook.EMPLOYEES());
                break;
            }
            case 2: {
                System.out.println("Список всех сотрудников и их данных:");
                EmployeeBook.allInfoOfEmployee(EmployeeBook.EMPLOYEES());
                System.out.println("Запрос по затратам в месяц.");
                System.out.println("Сумма затрат по ЗП в месяц составляет " + EmployeeBook.monthlyExpenses(EmployeeBook.EMPLOYEES()));
                break;
            }
            case 3: {
                System.out.println("Список всех сотрудников и их данных:");
                EmployeeBook.allInfoOfEmployee(EmployeeBook.EMPLOYEES());
                System.out.println("Запрос на сотрудника с минимальной зарплатой.");
                EmployeeBook.getMinSalaryAndPrint(EmployeeBook.EMPLOYEES());
                break;
            }
            case 4: {
                System.out.println("Список всех сотрудников и их данных:");
                EmployeeBook.allInfoOfEmployee(EmployeeBook.EMPLOYEES());
                System.out.println("Запрос на сотрудника с максимальной зарплатой.");
                EmployeeBook.getMaxSalaryAndPrint(EmployeeBook.EMPLOYEES());
                break;
            }
            case 5: {
                System.out.println("Список всех сотрудников и их данных:");
                EmployeeBook.allInfoOfEmployee(EMPLOYEES);
                System.out.println("Запрос на среднее значение зарплаты.");
                EmployeeBook.getAverageSalaryAndPrint(EMPLOYEES);
                break;
            }
            case 6: {
                System.out.println("Список всех сотрудников и их данных:");
                EmployeeBook.allInfoOfEmployee(EMPLOYEES);
                System.out.println("Запрос на печать ФИО всех сотрудников.");
                EmployeeBook.nameOfEmployee();
                break;
            }
            case 7: {
                System.out.println("Список всех сотрудников и их данных:");
                EmployeeBook.allInfoOfEmployee(EMPLOYEES);
                System.out.println("Индексация зарплаты");
                EmployeeBook.getIndexedSalaryAndPrint(EMPLOYEES, EmployeeBook.getIndex());
                EmployeeBook.allInfoOfEmployee(EMPLOYEES);
                break;
            }
            case 8: {
                System.out.println("Список всех сотрудников и их данных:");
                EmployeeBook.allInfoOfEmployee(EMPLOYEES);
                final int iD = getDivision();
                EmployeeBook.allInfoOfEmployee(Objects.requireNonNull(getListOfEmployeeDivision(getEmployeesOfDivisionCount(iD), iD)));
                System.out.println();
                EmployeeBook.getMinSalaryAndPrint(Objects.requireNonNull(getListOfEmployeeDivision(getEmployeesOfDivisionCount(iD), iD)));
                EmployeeBook.getMaxSalaryAndPrint(Objects.requireNonNull(getListOfEmployeeDivision(getEmployeesOfDivisionCount(iD), iD)));
                EmployeeBook.getAverageSalaryAndPrint(Objects.requireNonNull(getListOfEmployeeDivision(getEmployeesOfDivisionCount(iD), iD)));
                EmployeeBook.getIndexedSalaryAndPrint(Objects.requireNonNull(getListOfEmployeeDivision(getEmployeesOfDivisionCount(iD), iD)), getIndex());
                System.out.println();
                System.out.println("Список сотрудников отдела [" + iD + "]");
                EmployeeBook.infoWithoutDivision(Objects.requireNonNull(getListOfEmployeeDivision(getEmployeesOfDivisionCount(iD), iD)));
                break;
            }
            case 9: {
                EmployeeBook.allInfoOfEmployee(EMPLOYEES);
                System.out.println("Поиск...");
                EmployeeBook.getEmployeesWithLowerSalary(EMPLOYEES);
                EmployeeBook.getEmployeesWithHigherSalary(EMPLOYEES);
                break;
            }
            case 10: {
                System.out.println("Добавление сотрудника...");
                EmployeeBook.addEmployee();
                break;
            }
            case 11: {
                System.out.println("Удаление сотрудника...");
                EmployeeBook.deleteEmployee();
                break;
            }
            case 12: {
                System.out.println("Получение сотрудника по ID...");
                EmployeeBook.getEmployeeByID(getID());
                break;
            }
            default: {
                System.out.println("Неверный номер опции.");
            }
        }
    }
}