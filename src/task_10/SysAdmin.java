package task_10;

public class SysAdmin extends Employee {

    public SysAdmin() {
        super(Workplace.CABINET);
    }

    public SysAdmin(String name, long rate) {
        super(name, rate, Workplace.CABINET);
    }

    public SysAdmin(String name) {
        super(name, Workplace.CABINET);
    }

    public SysAdmin(long rate) {
        super(rate, Workplace.CABINET);
    }
}
