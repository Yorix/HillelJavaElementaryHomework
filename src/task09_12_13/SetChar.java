package task09_12_13;

public class SetChar extends ListChar {
    public SetChar() {
        super(30);
    }

    public SetChar(int size) {
        super(size);
    }

    @Override
    public boolean set(int index, char c) {
        return !contains(c) && super.set(index, c);
    }
}
