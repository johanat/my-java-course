public class Cat implements Animal{
    @Override
    public void toEat() {
        System.out.println("I am Cat and go to eat");

    }

    @Override
    public void sleep(int hours) {
        System.out.println("I am Cat will sleep "+ hours+ " horas");

    }
}
