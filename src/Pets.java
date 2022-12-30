import java.util.ArrayList;

public class Pets {
    public static void main(String[] args) {
        ArrayList<Pet>pets= new ArrayList<>();

        pets.add(new Dog("Firulay",5,"doberman"));
        pets.add(new Dog("Roky",3,"pit bull"));
        pets.add(new Dog("Niky",7,"french poodle "));
        pets.add(new Dog("Roy",8,"rottweiler"));
        pets.add(new Cat("Sasha",2,"amarillo"));
        pets.add(new Cat("Kimy",5,"atrigrada"));
        pets.add(new Cat("Tom",1,"gris"));

        for(int i=0; i< pets.size(); i++){
           pets.get(i).play();
        }
    }
}
