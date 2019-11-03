package pl.tdd.movies;

public class MovieID {
    private final String raw;

    public MovieID(String raw) {
        this.raw = raw;
    }

    public String raw() {
        return raw;
    }
}
