import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Actor actor1 = new Actor("Chris Evans", 38);
        Actor actor2 = new Actor("Henry Cavill", 40);
        Actor actor3 = new Actor("Mario Casas", 35);
        Actor actor4 = new Actor("Antonio Bandera",33);

        ArrayList<Actor> reparto1 = new ArrayList<>();
        reparto1.add(actor1);
        reparto1.add(actor2);

        ArrayList<Actor> reparto2 = new ArrayList<>();
        reparto2.add(actor2);
        reparto2.add(actor4);
        ArrayList<Actor> reparto3 = new ArrayList<>();
        reparto3.add(actor3);


        Movie movie1 = new Movie("Capital america", 2.12, reparto1);
        Movie movie2 = new Movie("Super Man", 1.15, reparto2);
        Movie movie3 = new Movie("Tres metros sobre el cielo", 1.45, reparto3);

        Cine cine = new Cine();

        cine.addMovie(movie2);
        cine.addMovie(movie3);

        cine.cinemaInfo();

        movie1.watch( );
        movie2.watch();

    }
}
