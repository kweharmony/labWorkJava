import java.util.HashMap;

public class EmployeeManagementSystem {
    
    private HashMap<Integer, Employee> employees;
    
    public EmployeeManagementSystem() {
        employees = new HashMap<>();
    }
    

    public boolean addEmployee(int id, Employee employee) {
        if (employees.containsKey(id)) {
            System.out.println("Ошибка: Сотрудник с ID " + id + " уже существует!");
            return false;
        }
        
        employees.put(id, employee);
        System.out.println("Сотрудник успешно добавлен с ID: " + id);
        return true;
    }
    
    public Employee findEmployee(int id) {
        Employee employee = employees.get(id);
        
        if (employee == null) {
            System.out.println("Сотрудник с ID " + id + " не найден!");
        } else {
            System.out.println("Сотрудник найден!");
        }
        
        return employee;
    }
    
    public boolean removeEmployee(int id) {
        Employee removed = employees.remove(id);
        
        if (removed == null) {
            System.out.println("Сотрудник с ID " + id + " не найден!");
            return false;
        } else {
            System.out.println("Сотрудник " + removed.getName() + " (ID: " + id + ") успешно удалён!");
            return true;
        }
    }
    
}