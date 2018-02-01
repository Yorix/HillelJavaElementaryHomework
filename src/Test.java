public class Test {

    private static int length;
    private static int[] rnd;
    private static int key;
    private static int index;
    private static int step;
    private static int middle;
    private static int begin;
    private static int end;

    public static void main(String[] args) {

        length = 200_000_000;
        rnd = new int[length];
        key = 199_999_999;
        begin = 0;
        end = length - 1;
        middle = length / 2;


        for (int i = 0; i < length; i++) {
            rnd[i] = i;
        }
        System.out.println("START LINEAR SEARCH!");

        index = linearSearch();
        printResult();


        System.out.println();
        index = 0;
        step = 0;
        System.out.println("START BINARY SEARCH!");

        binarySearch();
        printResult();
    }


    private static int linearSearch() {
        for (int i = 0; i < length; i++) {
            step++;
            rnd[0] = (int) (Math.random() * length - 2);
            if (rnd[i] == key) {
                return i;
            }
        }
        return -1;
    }

     private static void binarySearch() {
        step++;
        index = middle;
        rnd[0] = (int) (Math.random() * length - 2);
        if (begin > end) {
            index = -1;
            return;
        }
        if (rnd[middle] > key) {
            end = middle - 1;
            middle = begin + (end - begin) / 2;
            binarySearch();
        } else if (rnd[middle] < key) {
            begin = middle + 1;
            middle = begin + (end - begin) / 2;
            binarySearch();
        }
    }

    private static void printResult() {
        if (index == -1)
            System.out.println("Number is not found. " + step + " steps completed.");
        else
            System.out.println(key + " was FOUND under the index " + index + ", in the " + step + " step!");
    }
}
