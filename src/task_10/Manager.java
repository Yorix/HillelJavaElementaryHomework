package task_10;

public class Manager extends Employee {

    public Manager() {
        super(Workplace.OFFICE);
    }

    public Manager(String name, long rate) {
        super(name, rate, Workplace.OFFICE);
    }

    public Manager(String name) {
        super(name, Workplace.OFFICE);
    }

    public Manager(long rate) {
        super(rate, Workplace.OFFICE);
    }
}
