package task10;

public class Employee extends Person {
    private long rate;
    private Workplace workplace;

    public Employee() {
        super();
    }

    public Employee(String name) {
        super(name);
    }

    public Employee(String name, long rate, Workplace workplace) {
        super(name);
        this.rate = rate;
        this.workplace = workplace;
    }

    public Employee(String name, long rate) {
        super(name);
        this.rate = rate;
    }

    public Employee(String name, Workplace workplace) {
        super(name);
        this.workplace = workplace;
    }

    public Employee(long rate, Workplace workplace) {
        this.rate = rate;
        this.workplace = workplace;
    }

    public Employee(long rate) {
        this.rate = rate;
    }

    public Employee(Workplace workplace) {
        this.workplace = workplace;
    }

    public Workplace getWorkplace() {
        return workplace;
    }
}
