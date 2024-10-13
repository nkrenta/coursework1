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
        EmployeeBook employeeBook = new EmployeeBook();
        employeeBook.initEmployees();

        System.out.println();
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
                employeeBook.setChosenArray(1);
                System.out.println("Список всех сотрудников и их данных:");
                employeeBook.allInfoOfEmployee();
                break;
            }
            case 2: {
                employeeBook.setChosenArray(1);
                System.out.println("Список всех сотрудников и их данных:");
                employeeBook.allInfoOfEmployee();
                System.out.println();
                System.out.println("Запрос по затратам в месяц.");
                System.out.println("Сумма затрат по ЗП в месяц составляет " + employeeBook.monthlyExpenses());
                break;
            }
            case 3: {
                employeeBook.setChosenArray(1);
                System.out.println("Список всех сотрудников и их данных:");
                employeeBook.allInfoOfEmployee();
                System.out.println();
                System.out.println("Запрос на сотрудника с минимальной зарплатой.");
                employeeBook.getMinSalaryAndPrint();
                break;
            }
            case 4: {
                employeeBook.setChosenArray(1);
                System.out.println("Список всех сотрудников и их данных:");
                employeeBook.allInfoOfEmployee();
                System.out.println();
                System.out.println("Запрос на сотрудника с максимальной зарплатой.");
                employeeBook.getMaxSalaryAndPrint();
                break;
            }
            case 5: {
                employeeBook.setChosenArray(1);
                System.out.println("Список всех сотрудников и их данных:");
                employeeBook.allInfoOfEmployee();
                System.out.println();
                System.out.println("Запрос на среднее значение зарплаты.");
                employeeBook.getCountOfNULL();
                employeeBook.getAverageSalaryAndPrint();
                break;
            }
            case 6: {
                employeeBook.setChosenArray(1);
                System.out.println("Список всех сотрудников и их данных:");
                employeeBook.allInfoOfEmployee();
                System.out.println();
                System.out.println("Запрос на печать ФИО всех сотрудников.");
                employeeBook.nameOfEmployee();
                break;
            }
            case 7: {
                employeeBook.setChosenArray(1);
                System.out.println("Список всех сотрудников и их данных:");
                employeeBook.allInfoOfEmployee();
                System.out.println("Индексация зарплаты");
                employeeBook.getIndex();
                employeeBook.getIndexedSalaryAndPrint();
                break;
            }
            case 8: {
                employeeBook.setChosenArray(1);
                employeeBook.allInfoOfEmployee();
                employeeBook.setChosenArray(2);
                System.out.println();
                employeeBook.getDivision();
                System.out.println("Список сотрудников отдела [" + employeeBook.getiDiv() + "]");
                employeeBook.getEmployeesOfDivisionCount();
                employeeBook.infoWithoutDivision();
                employeeBook.getMinSalaryAndPrint();
                employeeBook.getMaxSalaryAndPrint();
                employeeBook.getAverageSalaryAndPrint();
                employeeBook.getIndex();
                employeeBook.getIndexedSalaryAndPrint();
                System.out.println();
                break;
            }
            case 9: {
                employeeBook.setChosenArray(1);
                employeeBook.allInfoOfEmployee();
                employeeBook.getArrayOfEmployees();
                if (employeeBook.getChosenArray() == 2) {
                    employeeBook.getDivision();
                    System.out.println("Список сотрудников отдела [" + employeeBook.getiDiv() + "]");
                    employeeBook.getEmployeesOfDivisionCount();
                    employeeBook.infoWithoutDivision();
                    System.out.println();
                    System.out.println("Поиск...");
                    System.out.println();
                    employeeBook.getEmployeesWithLowerSalary();
                    System.out.println();
                    employeeBook.getEmployeesWithHigherSalary();
                    break;
                } else if (employeeBook.getChosenArray() == 1) {
                    System.out.println();
                    System.out.println("Поиск...");
                    System.out.println();
                    employeeBook.getEmployeesWithLowerSalary();
                    System.out.println();
                    employeeBook.getEmployeesWithHigherSalary();
                    break;
                }
            }
            case 10: {
                employeeBook.setChosenArray(1);
                employeeBook.allInfoOfEmployee();
                employeeBook.addEmployee();
                employeeBook.allInfoOfEmployee();
                break;
            }
            case 11: {
                employeeBook.setChosenArray(1);
                employeeBook.allInfoOfEmployee();
                employeeBook.getID();
                System.out.println("Удаление сотрудника...");
                employeeBook.deleteEmployee();
                break;
            }
            case 12: {
                employeeBook.nameOfEmployeeWithId();
                System.out.println("Получение сотрудника по ID...");
                employeeBook.getID();
                employeeBook.getEmployeeByID();
                break;
            }
            default: {
                System.out.println("Неверный номер опции.");
            }
        }
    }
}