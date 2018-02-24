package task9;

import java.util.Arrays;

public class ListChar {
    private int size;
    private char[] list;
    private int length;
    private int lastElement;
    private Direction d;

    public ListChar() {
        this(30);
    }

    public ListChar(int size) {
        this.size = size;
        list = new char[size];
        list = new char[size];
    }

    /**
     * add a new char to list
     */
    public boolean add(char e) {
        if (lastElement >= size - 1) return false;
        while (list[lastElement] != 0 && length <= size) {
            lastElement++;
        }
        list[lastElement] = e;
        length++;
        return true;
    }

    /**
     * set a char to a place located by the index
     */
    public boolean set(int index, char c) {
        if (index < 0 || index >= size) {
            return false;
        }
        if (list[index] == 0) {
            length++;
        }
        list[index] = c;
        return true;
    }

    /**
     * get a code of char by the index or -1 in case element wasn't found by the index
     */
    public int get(int index) {
        return index < size && list[index] != 0 ? list[index] : -1;
    }

    /**
     * true if list contains a char c
     */
    public boolean contains(char c) {
        for (char element : list) {
            if (element == c) {
                return true;
            }
        }
        return false;
    }

    /**
     * add all elements from another list
     */
    public boolean addAll(ListChar listChar) {
        if (listChar.length > getFreeSize()) {
            return false;
        }
        for (char adding : listChar.list) {
            if (adding != 0) {
                add(adding);
            }
        }
        return true;
    }

    /**
     * compare two ListChar
     */
    public boolean equals(ListChar c) {
        if (c == null) return false;
        if (this == c) return true;
        if (c.size != size || c.length != length) return false;
        for (int i = 0; i < size; i++) {
            if (c.list[i] != list[i]) return false;
        }
        return true;
    }

    /**
     * clear all elements of list
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            list[i] = 0;
        }
        length = 0;
        lastElement = 0;
    }

    /**
     * return index of found element else if not then -1
     */
    public int indexOf(char c) {
        for (int i = 0; i < size; i++) {
            if (list[i] == c) {
                return i;
            }
        }
        return -1;
    }

    /**
     * return full size of all list
     */
    public int getFullSize() {
        return size;
    }

    /**
     * return number of free elements of list
     */
    public int getFreeSize() {
        return size - length;
    }

    /**
     * return current size
     */
    public int length() {
        return length;
    }

    char[] getList() {
        return list;
    }

    /**
     * true, if list is empty
     */
    public boolean isEmpty() {
        return length == 0;
    }

    /**
     * sorting elements inside current list
     */
    public void sort(Direction d) {
        this.d = d;
        list = mergeSort(list);
    }

    private char[] mergeSort(char[] arr) {
        int len = arr.length;
        if (len < 2) return arr;
        int middle = len / 2;
        return merge(mergeSort(Arrays.copyOfRange(arr, 0, middle)),
                     mergeSort(Arrays.copyOfRange(arr, middle, len)));
    }

    private char[] merge(char[] arr1, char[] arr2) {
        int len1 = arr1.length, len2 = arr2.length;
        int a = 0, b = 0, len = len1 + len2;
        char[] result = new char[len];
        for (int i = 0; i < len; i++) {
            if (a < len1 && b < len2 && d.equals(Direction.ASC)) {
                if (arr1[a] > arr2[b] && arr2[b] != 0) {
                    result[i] = arr2[b++];
                } else result[i] = arr1[a++];
            } else if (a < len1 && b < len2 && d.equals(Direction.DESC)) {
                if (arr1[a] < arr2[b] && arr2[b] != 0) {
                    result[i] = arr2[b++];
                } else result[i] = arr1[a++];
            } else if (b < len2) {
                result[i] = arr2[b++];
            } else {
                result[i] = arr1[a++];
            }
        }
        return result;
    }
}
