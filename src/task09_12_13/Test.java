package task09_12_13;

public class Test {
    public static void main(String[] args) {
        ListChar list1 = new ListChar();
        ListChar list2 = new ListChar(5);
        SetChar list3 = new SetChar();
        SetChar list4 = new SetChar(10);

        for (int i = 0; i < 25; i++) {
            char letter = (char) ('A' + (int) (Math.random() * 26));
            list1.add(letter);
        }
        System.out.print("list1 unsorted: " + list1);
        System.out.println();
        System.out.println("list1 full size: " + list1.getFullSize());
        System.out.println("list1 free size: " + list1.getFreeSize());
        System.out.println("list1 length: " + list1.length());
        System.out.println("get code of element under index 2: " + list1.get(2));
        list1.sort(Direction.ASC);
        System.out.println("list1 ASC-sorted: " + list1);
        list1.sort(Direction.DESC);
        System.out.println("list1 DESC-sorted: " + list1);
        System.out.println("set '!' to list2 under index 3: " + list2.set(3, '!'));
        System.out.println("add '?' to list2: " + list2.add('?'));
        System.out.println("add '?' to list2: " + list2.add('?'));
        System.out.println("add '?' to list2: " + list2.add('?'));
        System.out.println("add '?' to list2: " + list2.add('?'));
        System.out.println("add '?' to list2: " + list2.add('?'));
        System.out.println("list2: " + list2);
        System.out.println("add all from list2 to list1: " + list1.addAll(list2));
        System.out.println("add all from list1 to list2: " + list2.addAll(list1));
        System.out.println("Merge list1 + list2: " + list1);
        System.out.println("list1 == list2: " + list1.equals(list2));
        System.out.println("is list1 contains 'X'? - " + list1.contains('X'));
        System.out.println("'X' has index " + list1.indexOf('X'));
        System.out.println("is list1 empty? - " + list1.isEmpty());
        System.out.println("CLEAR list1...");
        list1.clear();
        System.out.println("is list1 empty? - " + list1.isEmpty());
        System.out.println();


        ///////////////////////////////////////////////////////////////////


        System.out.println("add 'x' to list3: " + list3.add('x'));
        System.out.println("add 'y' to list3: " + list3.add('y'));
        System.out.println("add 'z' to list3: " + list3.add('z'));
        System.out.println("add 'x' to list3 again: " + list3.add('y'));
        System.out.println("set 'y' to list3 under index 10: " + list3.set(10, 'y'));
        System.out.println("set '!' to list3 under index 1: " + list3.set(1, '!'));
        System.out.println("set '?' to list3 under index 10: " + list3.set(10, '?'));
        System.out.println("list3: " + list3);
        System.out.println("add 'a' to list4: " + list4.add('a'));
        System.out.println("add 'b' to list4: " + list4.add('b'));
        System.out.println("add 'c' to list4: " + list4.add('c'));
        System.out.println("set 'x' to list4 under index 0: " + list4.set(0, 'x'));
        System.out.println("list4: " + list4);
        System.out.println("add all from list4 to list3: " + list3.addAll(list4));
        System.out.println("Merge list3 + list4: " + list3);
        for (int i = 0; i < 500; i++) {
            char letter = (char) ('a' + (int) (Math.random() * 26));
            list3.add(letter);
        }
        System.out.println("list3: " + list3);
        list3.sort(Direction.ASC);
        System.out.println("list3 ASC-sorted: " + list3);
        System.out.println("list3 full size: " + list3.getFullSize());
        System.out.println("list3 free size: " + list3.getFreeSize());
        System.out.println("list3 length: " + list3.length());

        SetChar list5 = new SetChar();
        SetChar list6 = new SetChar();
        list5.add('5');
        list6.set(1, '5');
        list6.add('4');
        list5.clear();
        list5.add('4');
        list5.add('5');
        System.out.println(list5.equals(list6));


        //////////////////////////////////////////////////////////// TASK 13 TEST

        System.out.println("\n\nTASK 13 TEST\n");

        ListChar list7 = new ListChar(10);
        System.out.println("list7: " + list7);
        System.out.println("list7 full size: " + list7.getFullSize());
        System.out.println("list7 filling...");
        for (int i = 0; i < 20; i++) {
            char letter = (char) ('A' + (int) (Math.random() * 26));
            list7.add(letter);
        }
        System.out.println("list7 full size: " + list7.getFullSize());
        System.out.println("list7: " + list7);

        SetChar list8 = new SetChar(2);
        System.out.println("add '#' to list8: " + list8.add('#'));
        System.out.println("list8: " + list8);
        System.out.println("list8 full size: " + list8.getFullSize());
        System.out.println("add all from list8 to list7: " + list7.addAll(list8));
        System.out.println("list7: " + list7);
        System.out.println("list7 full size: " + list7.getFullSize());
        System.out.println("add all from list7 to list8: " + list8.addAll(list7));
        System.out.println("list8: " + list8);
        System.out.println("list8 full size: " + list8.getFullSize());

    }
}
