package task3;
import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        int year;
        int century;

        year = 1999;
        century = getCentury(year);
        printCentury(year, century);
        year = 1910;
        century = getCentury(year);
        printCentury(year, century);
        year = 1700;
        century = getCentury(year);
        printCentury(year, century);
        year = 1998;
        century = getCentury(year);
        printCentury(year, century);
        year = 2000;
        century = getCentury(year);
        printCentury(year, century);
        year = 2001;
        century = getCentury(year);
        printCentury(year, century);
        year = 200;
        century = getCentury(year);
        printCentury(year, century);
        year = 381;
        century = getCentury(year);
        printCentury(year, century);
        year = 45;
        century = getCentury(year);
        printCentury(year, century);
        year = 1000;
        century = getCentury(year);
        printCentury(year, century);
        year = 1001;
        century = getCentury(year);
        printCentury(year, century);
    }

    public static int getCentury(int year) {
        return (year - 1) / 100 + 1;
    }

    public static void printCentury(int year, int century) {
        out.println(year + " is the " + century + " century.");
    }
}
