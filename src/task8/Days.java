package task8;

public class Days {

    public String daysAtMonth(int month, int year) {
        if (!isCorrect(month, year)) {
            return "Incorrect month or year.";
        }
        month--;
        int days = (month == 1 && leapYear(year)) ? Months.Feb.getDays() + 1 : Months.values()[month].getDays();
        return Months.values()[month].text + " " + year + " lasts " + days + " days.";
    }

    private boolean isCorrect(int month, int year) {
        return month >= 1 && month <= 12 && year >= 1;
    }

    private boolean leapYear(int year) {
        return year % 400 == 0 || year % 4 == 0 && year % 100 != 0;
    }
}
