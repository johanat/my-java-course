import java.util.ArrayList;

public class Movie {
    private String title;
    private double duration;

    ArrayList<Actor> listActors = new ArrayList<>();

    public Movie(String title, double duration, ArrayList listActors) {
        this.title = title;
        this.duration = duration;
        this.listActors=listActors;
    }

    void watch() {
        System.out.println("watching the movie " + title + " that lasting " + duration + " minute y cuentan con los actores "+listActors);
    }

    @Override
    public String toString() {
        return "watching the movie " + title + " that lasting " + duration + " minute ";
    }

}
