package task14;

public class Pet extends Animal {

    private String name;

    @Override
    public String castVoice() {
        return super.castVoice() + "my name is " + name + ". ";
    }
}
