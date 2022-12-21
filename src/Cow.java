public class Cow implements Animal{
    @Override
    public void toEat() {
        System.out.println("I am Cow and go to eat");

    }

    @Override
    public void sleep(int hours) {
        System.out.println("I am Cow will sleep "+ hours+ " horas");
    }
}
