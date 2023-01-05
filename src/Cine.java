import java.util.ArrayList;

public class Cine {
    ArrayList<Movie> listMovie = new ArrayList<>();


    void addMovie(Movie movie) {
        listMovie.add(movie);
    }

    void cinemaInfo() {
        System.out.println(listMovie);
    }


}
