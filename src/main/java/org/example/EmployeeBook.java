package org.example;

public class EmployeeBook {
    private Employee[] employees;

    public EmployeeBook(int capacity) {
        this.employees = new Employee[capacity];
    }

    public void addEmployee(Employee employee) {
        for (int i = 0; i < employees.length; i++)
            if (employees[i] == null) {
                employees[i] = employee;
                break;
            }
    }

    public void removeEmployee(String fullName, int id) {
        for (int i = 0; i < employees.length; i++)
            if (employees[i] != null && (employees[i].getFullName().equals(fullName) || employees[i].getId() == id)) {
                employees[i] = null;
                break;
            }
    }

    public void indexSalary(double percentage) {
        for (Employee employee : employees) {
            if (employee != null) {
                employee.setSalary(employee.getSalary() * (1 + percentage / 100));
            }
        }
    }


    public Employee findMinSalaryInDepartment(int department) {
        return findEmployeeBySalary(department, false);
    }

    public Employee findMaxSalaryInDepartment(int department) {
        return findEmployeeBySalary(department, true);
    }

    public double calculateTotalSalaryInDepartment(int department) {
        double totalSalary = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                totalSalary += employee.getSalary();
            }
        }
        return totalSalary;
    }

    public double calculateAverageSalaryInDepartment(int department) {
        int count = 0;
        double totalSalary = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                totalSalary += employee.getSalary();
                count++;
            }
        }
        return count > 0 ? totalSalary / count : 0;
    }

    public void indexSalaryInDepartment(int department, double percentage) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                double currentSalary = employee.getSalary();
                double indexedSalary = currentSalary + currentSalary * (percentage / 100);
                employee.setSalary(indexedSalary);
            }
        }
    }

    public void printEmployeesInDepartment(int department) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                System.out.println(employee);
            }
        }
    }

    private Employee findEmployeeBySalary(int department, boolean findMax) {
        Employee result = null;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                if (result == null || (findMax ? employee.getSalary() > result.getSalary() :
                        employee.getSalary() < result.getSalary())) {
                    result = employee;
                }
            }
        }
        return result;
    }

    public void printEmployeesWithSalaryLessThan(double thresholdSalary) {
        System.out.println("Сотрудники с зарплатой меньше " + thresholdSalary + ":");
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < thresholdSalary) {
                System.out.println("ID: " + employee.getId() +
                        ", Ф. И. О.: " + employee.getFullName() +
                        ", Зарплата: " + employee.getSalary());
            }
        }
        System.out.println();
    }

    public void printEmployeesWithSalaryGreaterOrEqual(double thresholdSalary) {
        System.out.println("Сотрудники с зарплатой больше или равной " + thresholdSalary + ":");
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() >= thresholdSalary) {
                System.out.println("ID: " + employee.getId() +
                        ", Ф. И. О.: " + employee.getFullName() +
                        ", Зарплата: " + employee.getSalary());
            }
        }
        System.out.println();
    }

    public void updateSalary(String fullName, double newSalary) {
        for (Employee employee : employees)
            if (employee != null && employee.getFullName().equals(fullName)) {
                employee.setSalary(newSalary);
                break;
            }
    }

    public void updateDepartment(String fullName, int newDepartment) {
        for (Employee employee : employees)
            if (employee != null && employee.getFullName().equals(fullName)) {
                employee.setDepartment(newDepartment);
                break;
            }
    }

    public void printEmployeesByDepartments() {
        for (Employee employee : employees)
            if (employee != null)
                System.out.println("Отдел " + employee.getDepartment() + ": " + employee.getFullName());
    }
}
