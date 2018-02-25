package task9;

public class Program {
    public static void main(String[] args) {
        ListChar list1 = new ListChar();
        ListChar list2 = new ListChar(5);
        SetChar list3 = new SetChar();
        SetChar list4 = new SetChar(10);

        System.out.println("list1 unsorted:");
        for (int i = 0; i < 25; i++) {
            char letter = (char) ('A' + (int) (Math.random() * 26));
            list1.add(letter);
            System.out.print((char) list1.get(i));
        }
        System.out.println();
        System.out.println("list1 full size: " + list1.getFullSize());
        System.out.println("list1 free size: " + list1.getFreeSize());
        System.out.println("list1 length: " + list1.length());


        list1.sort(Direction.ASC);
        System.out.println("list1 ASC-sorted:");
        for (char e : list1.getList()) {
            System.out.print(e);
        }
        System.out.println();

        list1.sort(Direction.DESC);
        System.out.println("list1 DESC-sorted:");
        for (char e : list1.getList()) {
            System.out.print(e);
        }
        System.out.println();

        System.out.println("set '!' to list2 under index 0: " + list2.set(3, '!'));
        System.out.println("add '?' to list2: " + list2.add('?'));
        System.out.println("add '?' to list2: " + list2.add('?'));
        System.out.println("add '?' to list2: " + list2.add('?'));
        System.out.println("add '?' to list2: " + list2.add('?'));
        System.out.println("add '?' to list2: " + list2.add('?'));
        System.out.println("list2: ");
        for (char e : list2.getList()) {
            System.out.print(e);
        }
        System.out.println();


        System.out.println("add all from list2 to list1: " + list1.addAll(list2));
        System.out.println("add all from list1 to list2: " + list2.addAll(list1));
        System.out.println("Merge list1 + list2: ");
        for (char e : list1.getList()) {
            System.out.print(e);
        }
        System.out.println();

        System.out.println("list1 == list2: " + list1.equals(list2));
        System.out.println("is list1 contains 'X'? - " + list1.contains('X'));
        System.out.println("'X' has index " + list1.indexOf('X'));
        System.out.println("is list1 empty? - " + list1.isEmpty());
        System.out.println("CLEAR list1...");
        list1.clear();
        System.out.println("is list1 empty? - " + list1.isEmpty());


        ///////////////////////////////////////////////////////////////////




        System.out.println("\nadd 'x' to list3: " + list3.add('x'));
        System.out.println("add 'y' to list3: " + list3.add('y'));
        System.out.println("add 'z' to list3: " + list3.add('z'));
        System.out.println("add 'x' to list3 again: " + list3.add('y'));
        System.out.println("set 'y' to list3 under index 10: " + list3.set(10, 'y'));
        System.out.println("set '!' to list3 under index 1: " + list3.set(1, '!'));
        System.out.println("set '?' to list3 under index 10: " + list3.set(10, '?'));
        System.out.println("list3: ");
        for (char e : list3.getList()) {
            System.out.print(e);
        }
        System.out.println();


        System.out.println("\nadd 'a' to list4: " + list4.add('a'));
        System.out.println("add 'b' to list4: " + list4.add('b'));
        System.out.println("add 'c' to list4: " + list4.add('c'));
        System.out.println("set 'x' to list4 under index 0: " + list4.set(0, 'x'));
        System.out.println("list4: ");
        for (char e : list4.getList()) {
            System.out.print(e);
        }
        System.out.println();

        System.out.println("add all from list4 to list3: " + list3.addAll(list4));
        System.out.println("Merge list3 + list4: ");
        for (char e : list3.getList()) {
            System.out.print(e);
        }
        System.out.println();

    }
}
