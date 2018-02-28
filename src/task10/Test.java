package task10;

public class Test {
    public static void main(String[] args) {
        Person person = new Person();
        Employee employee = new Employee("Василий");
        Manager manager = new Manager("Иван");
        SysAdmin sysAdmin = new SysAdmin("Пётр");
        Worker worker = new Worker("Леонид");
        Client client = new Client("Варфоломей");

        /*
Проверить является ли объект класса SysAdmin наследником класса Client.
Проверить является ли объект класса Worker наследником класса Person.
Проверить является ли объект класса Worker наследником класса Manager.
Проверить является ли объект класса SysAdmin наследником класса Person.
Проверить является ли объект класса Manager наследником класса Client.
Проверить является ли объект класса Client наследником класса Employee.
Проверить является ли объект класса Client наследником класса Person.
        */

        System.out.println("SysAdmin is Client - " + ((Object) sysAdmin instanceof Client));
        System.out.println("Worker is Person - " + ((Object) worker instanceof Person));
        System.out.println("Worker is Manager - " + ((Object) worker instanceof Manager));
        System.out.println("SysAdmin is Person - " + ((Object) sysAdmin instanceof Person));
        System.out.println("Manager is Client - " + ((Object) manager instanceof Client));
        System.out.println("Client is Employee - " + ((Object) client instanceof Employee));
        System.out.println("Client is Person - " + ((Object) client instanceof Person));
    }
}
