package task8;

public enum Months {
    Jan("January", 31),
    Feb("February", 28),
    Mar("March", 31),
    Apr("April", 30),
    May("May", 31),
    Jun("June", 30),
    Jul("July", 31),
    Aug("August", 31),
    Sep("September", 30),
    Oct("October", 31),
    Nov("November", 30),
    Dec("December", 31);

    String text;
    private int days;

    Months(String text, int days) {
        this.text = text;
        this.days = days;
    }

    public int getDays() {
        return days;
    }
}
