package task14;

public class GuideDog extends Dog {

    private boolean isTrained;

    public GuideDog(int id, int age, double weight, String colour, String name, boolean isVaccinated, boolean isTrained) {
        super(id, age, weight, colour, name, isVaccinated);
        this.isTrained = isTrained;
    }


    public String castVoice() {
        return isTrained ? super.castVoice() + ". I can take you home." : super.castVoice();
    }
}