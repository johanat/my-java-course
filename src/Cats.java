
public class Cats {
    public static void main(String[] args) {

        Cat darwin = new Cat("Darwin", 3, 2.3f, "amarillo", "gruñon");
        Cat luigi = new Cat("Luigi", 1, 1.5f, "cafe", "jugeton");
        Cat tom = new Cat("Tom", 6, 3.2f, "atrigrado", "travieso");

        darwin.maulla();
        tom.maulla();
        luigi.maulla();

        System.out.println("\n");

        System.out.println(darwin);
        System.out.println(tom);
        System.out.println(luigi);

        darwin.come();
        tom.come();
        luigi.come();

        System.out.println("\n");
        System.out.println(darwin);
        System.out.println(tom);
        System.out.println(luigi);

        darwin.play();
        tom.play();
        luigi.play();
        System.out.println("\n");
        System.out.println(darwin);
        System.out.println(tom);
        System.out.println(luigi);

    }
}


