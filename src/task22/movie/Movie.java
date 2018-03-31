package task22.movie;

public class Movie {
    private Property duration;
    private Property genre;
    private Property director;

    public Movie(String duration, String genre, String director) {
        this.duration = new Property(PropertyName.DURATION, duration);
        this.genre = new Property(PropertyName.GENRE, genre);
        this.director = new Property(PropertyName.DIRECTOR, director);
    }

    @Override
    public String toString() {
        return "Movie{" + duration + ", " + genre + ", " + director + "}";
    }

    private static class Property {
        private PropertyName propertyName;
        private String propertyValue;

        public Property(PropertyName propertyName, String value) {
            this.propertyName = propertyName;
            this.propertyValue = value;
        }

        @Override
        public String toString() {
            return propertyName + ": " + propertyValue;
        }
    }

    enum PropertyName {
        DURATION, GENRE, DIRECTOR
    }
}
