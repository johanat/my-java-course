public class Dog implements Animal{

    @Override
    public void toEat() {
        System.out.println("I am Dog and go to eat");

    }

    @Override
    public void sleep( int hours) {
        System.out.println("I am Dog  will sleep "+ hours+ " horas");

    }
}
