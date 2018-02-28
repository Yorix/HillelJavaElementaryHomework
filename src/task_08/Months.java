package task_08;

public enum Months {
    JAN("January", 31),
    FEB("February", 28),
    MAR("March", 31),
    APR("April", 30),
    May("May", 31),
    JUN("June", 30),
    JUL("July", 31),
    AUG("August", 31),
    SEP("September", 30),
    OCT("October", 31),
    NOV("November", 30),
    DEC("December", 31);

    private String text;
    private int days;

    Months(String text, int days) {
        this.text = text;
        this.days = days;
    }

    @Override
    public String toString() {
        return text;
    }

    public int getDays() {
        return days;
    }
}
