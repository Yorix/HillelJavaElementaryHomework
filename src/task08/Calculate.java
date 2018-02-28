package task08;

public class Calculate {

    public String daysAtMonth(int month, int year) {
        month--;
        int days = month == 1 && leapYear(year) ? Months.FEB.getDays() + 1 : Months.values()[month].getDays();
        return Months.values()[month] + " " + year + " lasts " + days + " days.";
    }

    private boolean leapYear(int year) {
        return year % 400 == 0 || year % 4 == 0 && year % 100 != 0;
    }
}
