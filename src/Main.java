
public class Main {
    public static void main(String[] args) {

        String msj = "( Message of main)";

        Dog dog = new Dog();
        dog.toEat(new Listener() {
            @Override
            public void yaEsta(int kilos) {
                System.out.println("Dog finished of eat "+kilos+" kilos"+ msj);
            }
        });
    }
}


