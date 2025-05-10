import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class EmployeeBook {
    private final static Random RANDOM = new Random();
    private final static String[] FIRSTNAMES = {"Тимофей", "Владислав", "Александр", "Алексей", "Петр", "Иван"};
    private final static String[] SECONDNAMES = {"Иванович", "Петрович", "Дмитриевич", "Алексеевич", "Матвеевич", "Александрович"};
    private final static String[] LASTNAMES = {"Иванов", "Петров", "Сидоров", "Капушин", "Пупкин", "Купцов", "Молчанов", "Сидоров"};

    private double interestedIndex = 0;
    private int squareSpace = 0;
    private int iD = 0;
    private int iDiv = 0;
    private int countOfDivisionEmployee = 0;
    private int countOfNULL = 0;
    private int chosenArray = 0;

    private final Employee[] EMPLOYEES = new Employee[10];


    public int getChosenArray() {
        return chosenArray;
    }

    public int getiDiv() {
        return iDiv;
    }

    public void setChosenArray(int chosenArray) {
        this.chosenArray = chosenArray;
    }

    public void getCountOfNULL() {
        if (chosenArray == 1) {
            for (int i = 0; i < EMPLOYEES.length; i++) {
                if (EMPLOYEES[i] == null) {
                    countOfNULL++;
                }
            }
        } else if (chosenArray == 2) {
            for (int i = 0; i < getListOfEmployeeDivision().length; i++) {
                if (getListOfEmployeeDivision()[i] == null) {
                    countOfNULL++;
                }
            }
        }
    }

    //Initialization of employees [light]
    public void initEmployees() {
        for (int i = 0; i < EMPLOYEES.length - 2; i++) {
            String lastName = LASTNAMES[RANDOM.nextInt(0, LASTNAMES.length)];
            String firstName = FIRSTNAMES[RANDOM.nextInt(0, FIRSTNAMES.length)];
            String secondName = SECONDNAMES[RANDOM.nextInt(0, SECONDNAMES.length)];
            EMPLOYEES[i] = new Employee(new NameOfWorker(lastName, firstName, secondName), RANDOM.nextInt(1, 6), RANDOM.nextInt(40000, 110000));
        }
    }

    //Choose an array of employees
    public void getArrayOfEmployees() {
        System.out.println();
        Scanner rightMassive = new Scanner(System.in);
        System.out.println("Какой массив вы ходите обработать:");
        System.out.println("1. Все сотрудники");
        System.out.println("2. Сотрудники из определенного отдела");
        int rM = rightMassive.nextInt();
        if (rM == 1 || rM == 2) {
            chosenArray = rM;
        } else {
            System.out.println("Ошибка ввода. Повторите попытку.");
            getArrayOfEmployees();
        }

    }

    //Info about Employee [light] [1]
    public void allInfoOfEmployee() {
        if (chosenArray == 1) {
            for (int i = 0; i < EMPLOYEES.length; i++) {
                System.out.println(EMPLOYEES[i]);
            }
        } else if (chosenArray == 2) {
            for (int i = 0; i < getListOfEmployeeDivision().length; i++) {
                System.out.println(getListOfEmployeeDivision()[i]);
            }
        }
    }

    //Sum of month expenses [light] [2]
    public double monthlyExpenses() {
        int sum = 0;
        if (chosenArray == 1) {
            for (int i = 0; i < EMPLOYEES.length; i++) {
                if (EMPLOYEES[i] != null) {
                    sum += EMPLOYEES[i].getSalary();
                }
            }

        } else if (chosenArray == 2) {
            for (int i = 0; i < getListOfEmployeeDivision().length; i++) {
                if (getListOfEmployeeDivision()[i] != null) {
                    sum += getListOfEmployeeDivision()[i].getSalary();
                }
            }
        }
        return sum;
    }

    //Employee with minimal salary from chosen list of employees [light] [medium] [3, 8]
    public void getMinSalaryAndPrint() {
        if (chosenArray == 1) {
            int minSalary = EMPLOYEES[0].getSalary();
            for (int i = 1; i < EMPLOYEES.length; i++) {
                if (EMPLOYEES[i] != null) {
                    if (EMPLOYEES[i].getSalary() < minSalary) {
                        minSalary = EMPLOYEES[i].getSalary();
                    }
                }
            }
            for (int i = 0; i < EMPLOYEES.length; i++) {
                if (EMPLOYEES[i] != null) {
                    if (EMPLOYEES[i].getSalary() == minSalary) {
                        System.out.println("Сотрудник с минимальной ЗП: " + EMPLOYEES[i].getName() + " " + EMPLOYEES[i].getSalary());
                    }
                }
            }
        } else if (chosenArray == 2) {
            int minSalary = getListOfEmployeeDivision()[0].getSalary();
            for (int i = 1; i < getListOfEmployeeDivision().length; i++) {
                if (getListOfEmployeeDivision()[i] != null) {
                    if (getListOfEmployeeDivision()[i].getSalary() < minSalary) {
                        minSalary = getListOfEmployeeDivision()[i].getSalary();
                    }
                }
            }
            for (int i = 0; i < getListOfEmployeeDivision().length; i++) {
                if (getListOfEmployeeDivision()[i] != null) {
                    if (getListOfEmployeeDivision()[i].getSalary() == minSalary) {
                        System.out.println("Сотрудник с минимальной ЗП: " + getListOfEmployeeDivision()[i].getName() + " " + getListOfEmployeeDivision()[i].getSalary());
                    }
                }
            }
        }
    }

    //Employee with maximal salary from chosen list of employees [light] [medium] [4.8]
    public void getMaxSalaryAndPrint() {
        if (chosenArray == 1) {
            if (EMPLOYEES[0] != null) {
                int maxSalary = EMPLOYEES[0].getSalary();
                for (int i = 1; i < EMPLOYEES.length; i++) {
                    if (EMPLOYEES[i] != null) {
                        if (EMPLOYEES[i].getSalary() > maxSalary) {
                            maxSalary = EMPLOYEES[i].getSalary();
                        }
                    } else continue;
                }
                for (int i = 0; i < EMPLOYEES.length; i++) {
                    if (EMPLOYEES[i] != null) {
                        if (EMPLOYEES[i].getSalary() == maxSalary)
                            System.out.println("Сотрудник с минимальной ЗП: " + EMPLOYEES[i].getName() + " " + EMPLOYEES[i].getSalary());
                    } else continue;
                }

            } else if (chosenArray == 2) {
                if (getListOfEmployeeDivision()[0] != null) {
                    int maxSalary = getListOfEmployeeDivision()[0].getSalary();
                    for (int i = 1; i < getListOfEmployeeDivision().length; i++) {
                        if (getListOfEmployeeDivision()[i] != null) {
                            if (getListOfEmployeeDivision()[i].getSalary() > maxSalary) {
                                maxSalary = getListOfEmployeeDivision()[i].getSalary();
                            } else continue;
                        }
                    }
                    for (int i = 0; i < getListOfEmployeeDivision().length; i++) {
                        if (getListOfEmployeeDivision()[i] != null) {
                            if (getListOfEmployeeDivision()[i].getSalary() == maxSalary) {
                                System.out.println("Сотрудник с минимальной ЗП: " + EMPLOYEES[i].getName() + " " + EMPLOYEES[i].getSalary());
                            } else continue;
                        }
                    }
                }
            }
        }
    }

    //Average salary from chosen list of employees [light] [medium] [5,8]
    public void getAverageSalaryAndPrint() {
        if (chosenArray == 1) {
            System.out.println("Среднее значение зарплаты: " + (int) (monthlyExpenses() / (EMPLOYEES.length - countOfNULL)));
        } else if (chosenArray == 2) {
            System.out.println("Среднее значение зарплаты: " + (int) (monthlyExpenses() / (getListOfEmployeeDivision().length - countOfNULL)));
        }
    }

    //Just names of employees [8] [medium]
    public void nameOfEmployee() {
        for (int i = 0; i < EMPLOYEES.length; i++) {
            if (EMPLOYEES[i] != null) {
                System.out.println(EMPLOYEES[i].getName());
            }
        }
    }

    public void nameOfEmployeeWithId() {
        for (int i = 0; i < EMPLOYEES.length; i++) {
            if (EMPLOYEES[i] != null) {
                System.out.println("id [" + EMPLOYEES[i].getId() + "] " + EMPLOYEES[i].getName());
            }
        }
    }

    //Getting index for the next method [medium] [7]
    public void getIndex() {
        System.out.println();
        Scanner persentageOfIndex = new Scanner(System.in);
        System.out.println("Введите процент зарплаты:");
        interestedIndex = persentageOfIndex.nextInt();
    }

    //Indexed salary from chosen list of employees [medium] [7]
    public void getIndexedSalaryAndPrint() {
        System.out.println();
        System.out.println("Список сотрудников с обновленными зарплатами:");
        interestedIndex /= 100;
        if (chosenArray == 1) {
            for (int i = 0; i < EMPLOYEES.length; i++) {
                if (EMPLOYEES[i] != null) {
                    EMPLOYEES[i].setSalary((int) (EMPLOYEES[i].getSalary() + EMPLOYEES[i].getSalary() * interestedIndex));
                }
            }
        } else if (chosenArray == 2) {
            for (int i = 0; i < getListOfEmployeeDivision().length; i++) {
                if (getListOfEmployeeDivision()[i] != null) {
                    getListOfEmployeeDivision()[i].setSalary((int) (getListOfEmployeeDivision()[i].getSalary() + getListOfEmployeeDivision()[i].getSalary() * interestedIndex));
                }
            }
        }
        allInfoOfEmployee();
    }

    //Getting division for the next method [medium] [8]
    public void getDivision() {
        System.out.println("Введите номер отдела:");
        Scanner indexDivision = new Scanner(System.in);
        iDiv = indexDivision.nextInt();
    }

    //Count of employees in chosen division [medium] [8]
    public void getEmployeesOfDivisionCount() {
        int count = 0;
        for (int i = 0; i < EMPLOYEES.length; i++) {
            if (EMPLOYEES[i] != null) {
                if (EMPLOYEES[i].getDivision() == iDiv) {
                    count++;
                }
            }
        }
        countOfDivisionEmployee = count;
    }

    //Get list of employees from chosen division [medium] [8]
    public Employee[] getListOfEmployeeDivision() {
        if (countOfDivisionEmployee == 0) {
            System.out.println("Нет сотрудников в данном отделе!");
            return new Employee[0];
        } else if (countOfDivisionEmployee == 1) {
            System.out.println("В данном отделе только один сотрудник.");
            return new Employee[]{EMPLOYEES[0]};
        } else {
            List<Employee> employeesOfDivision = new ArrayList<>(countOfDivisionEmployee);
            for (int i = 0; i < EMPLOYEES.length; i++) {
                if (EMPLOYEES[i] != null) {
                    if (EMPLOYEES[i].getDivision() == iDiv) {
                        employeesOfDivision.add(EMPLOYEES[i]);
                    }
                }
            }
            Employee[] employeesOfDivisionArray = employeesOfDivision.toArray(new Employee[employeesOfDivision.size()]);
            return employeesOfDivisionArray;
        }
    }

    //Get list of employees without division [medium] [8]
    public void infoWithoutDivision() {
        for (int i = 0; i < getListOfEmployeeDivision().length; i++) {
            System.out.println("id [" + getListOfEmployeeDivision()[i].getId() + "] " + getListOfEmployeeDivision()[i].getName() + ", зарплата сотрудника - " + getListOfEmployeeDivision()[i].getSalary());
        }
    }

    //The lowest salary of employees [medium] [9]
    public void getEmployeesWithLowerSalary() {
        System.out.println("Введите число, для получения списка сотрудников с меньшей зарплатой:");
        Scanner lowSalary = new Scanner(System.in);
        int lS = lowSalary.nextInt();

        if (chosenArray == 1) {
            for (int i = 0; i < EMPLOYEES.length; i++) {
                if (EMPLOYEES[i] != null) {
                    if (EMPLOYEES[i].getSalary() < lS) {
                        System.out.println(EMPLOYEES[i].getName() + " " + EMPLOYEES[i].getSalary());
                    }
                }
            }
        } else if (chosenArray == 2) {
            for (int i = 0; i < getListOfEmployeeDivision().length; i++) {
                if (EMPLOYEES[i] != null) {
                    if (getListOfEmployeeDivision()[i].getSalary() < lS) {
                        System.out.println(getListOfEmployeeDivision()[i].getName() + " " + getListOfEmployeeDivision()[i].getSalary());
                    }
                }
            }
        }
    }

    //The highest salary of employees [medium] [9]
    public void getEmployeesWithHigherSalary() {
        System.out.println("Введите число, для получения списка сотрудников с большей зарплатой:");
        Scanner highSalary = new Scanner(System.in);
        int hS = highSalary.nextInt();

        if (chosenArray == 1) {
            for (int i = 0; i < EMPLOYEES.length; i++) {
                if (EMPLOYEES[i] != null) {
                    if (EMPLOYEES[i].getSalary() > hS) {
                        System.out.println(EMPLOYEES[i].getName() + " " + EMPLOYEES[i].getSalary());
                    }
                }
            }
        } else if (chosenArray == 2) {
            for (int i = 0; i < getListOfEmployeeDivision().length; i++) {
                if (EMPLOYEES[i] != null) {
                    if (getListOfEmployeeDivision()[i].getSalary() > hS) {
                        System.out.println(getListOfEmployeeDivision()[i].getName() + " " + getListOfEmployeeDivision()[i].getSalary());
                    }
                }
            }
        }
    }

    //Checking for free place to write [hard] [10]
    public boolean checkFreePlaceToAddEmployee() {
        boolean result = false;
        for (int i = 0; i < EMPLOYEES.length; i++) {
            if (EMPLOYEES[i] == null) {
                result = true;
                squareSpace = i;
                break;
            }
        }
        return result;
    }

    //Adding new employee to the list of employees [hard] [10]
    public void addEmployee() {
        if (!checkFreePlaceToAddEmployee()) {
            System.out.println("Список сотрудников заполнен!");
            return;
        } else {
            System.out.println("Добавление сотрудника...");
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

            EMPLOYEES[squareSpace] = new Employee(new NameOfWorker(lN, fN, sN), division, salary);
            System.out.println("Сотрудник добавлен!");
        }
    }

    //Deleting employee by id [hard] [11]
    public void deleteEmployee() {
        if (iD < 0 || iD >= EMPLOYEES.length) {
            System.out.println("Такого сотрудника нет!");
        } else {
            EMPLOYEES[iD - 1] = null;
            System.out.println("Сотрудник удален!");
        }
        allInfoOfEmployee();
    }

    //Getting id for the next method [hard] [12]
    public void getID() {
        System.out.println();
        System.out.println("Введите ID человека:");
        Scanner getID = new Scanner(System.in);
        iD = getID.nextInt();
    }

    //Get employee by ID [hard] [12]
    public void getEmployeeByID() {
        for (int i = 0; i < EMPLOYEES.length; i++) {
            if (EMPLOYEES[i] != null) {
                if (EMPLOYEES[i].getId() == iD) {
                    System.out.println(EMPLOYEES[i]);
                    break;
                } else {
                    continue;
                }
            }
        }
    }
}
