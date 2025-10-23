public class Main {
    public static void main(String[] args) {
        System.out.println("=== ТЕСТИРОВАНИЕ СИСТЕМЫ УПРАВЛЕНИЯ СОТРУДНИКАМИ ===\n");
        
        EmployeeManagementSystem system = new EmployeeManagementSystem();
        
        System.out.println("--- ТЕСТ 1: Добавление сотрудников ---");
        Employee emp1 = new Employee("Иван", "Программист Java", 80000);
        Employee emp2 = new Employee("Мария", "Менеджер проектов", 70000);
        Employee emp3 = new Employee("Алексей", "UX/UI Дизайнер", 65000);
        
        system.addEmployee(1001, emp1);
        system.addEmployee(1002, emp2);
        system.addEmployee(1003, emp3);
        
        Employee emp4 = new Employee("Новиков Сергей", "Тестировщик", 60000);
        boolean add = system.addEmployee(1001, emp4);
        System.out.println("Результат добавления: " + add);
        
        Employee find1 = system.findEmployee(1002);
        if (find1 != null) {
            System.out.println(find1);
        }

        Employee find2 = system.findEmployee(9999);
        System.out.println("Результат: " + find2);

        Employee set = system.findEmployee(1001);
        if (set != null) {
            System.out.println("До: " + set);
            set.setSalary(95000);
            set.setPosition("Старший программист Java");
            System.out.println("После: " + set);
        }
        
        boolean del1 = system.removeEmployee(1003);
        System.out.println("Удаление 1003: " + del1);

        boolean del2 = system.removeEmployee(9999);
        System.out.println("Удаление 9999: " + del2);

        Employee check = system.findEmployee(1003);
        System.out.println("Поиск удалённого сотрудника (1003): " + check);
    }
}