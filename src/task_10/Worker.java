package task_10;

public class Worker extends Employee {

    public Worker() {
        super(Workplace.STORE);
    }

    public Worker(String name, long rate) {
        super(name, rate, Workplace.STORE);
    }

    public Worker(String name) {
        super(name, Workplace.STORE);
    }

    public Worker(long rate) {
        super(rate, Workplace.STORE);
    }
}
