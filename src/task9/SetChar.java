package task9;

public class SetChar extends ListChar {
    private int size;
    private char[] list;

    public SetChar() {
        this(30);
    }

    public SetChar(int size) {
        this.size = size;
        list = new char[size];
        list = new char[size];
    }

    @Override
    public boolean add(char e) {
        return !contains(e) && super.add(e);
    }

    @Override
    public boolean set(int index, char c) {
        return !contains(c) && super.set(index, c);
    }
}
