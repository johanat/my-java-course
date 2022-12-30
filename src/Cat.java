public class Cat implements Pet{

    private String name;
    private int age;
    private String color;

    Cat(String name, int age, String color){
        this.name=name;
        this.age=age;
        this.color=color;
    }
    @Override
    public void play() {
        System.out.println("Name: "+name+" is played with your mouse toy");
    }
}
