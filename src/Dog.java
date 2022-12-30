public class Dog implements Pet {
   private String name;
   private int age;
   private String race;

    Dog(String name, int age, String race){
        this.name=name;
        this.age=age;
        this.race=race;
    }

    @Override
    public void play() {
        System.out.println("Name: "+name+ "  is played ");
    }
}
