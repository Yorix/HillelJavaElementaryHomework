package task14;

public class Wild extends Animal {

    @Override
    public String castVoice() {
        return super.castVoice() + "I am a wild animal";
    }
}
