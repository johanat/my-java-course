
public class Main {
    public static void main(String[] args) {

        Dog myDog = new Dog();
        Cat myCat = new Cat();
        Cow myCow = new Cow();

        Granja myGranja= new Granja();

        myGranja.feed(myDog);
        myGranja.feed(myCat);
        myGranja.feed(myCow);

        myDog.sleep(4);
        myCat.sleep(6);
        myCow.sleep(1);

    }
}

