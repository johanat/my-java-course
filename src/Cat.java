public class Cat {
    private String name;
    private int age;
    private float weight;
    private String color;
    private String mood;

    Cat(String name, int age, float weight, String color, String mood) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;
        this.mood = mood;
    }

    void maulla() {
        System.out.println("I am " + name + " and am " + mood);
    }

    void come() {
        weight = weight + 0.5f;
    }

    void play() {
        weight = weight - 0.2f;
    }

    @Override
    public String toString() {
        return " Nombre: "+name+" Age: "+age+ " Weight: "+weight+ " Color : "+color+ " Mood: "+ mood;
    }

}
