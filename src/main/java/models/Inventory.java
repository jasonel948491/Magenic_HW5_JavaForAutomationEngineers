package models;

import java.util.*;

public class Inventory {

    /**
     * A unique list of every movie
     */
    private TreeSet<Movie> movieArchive;

    /**
     * Creates an instance of the Inventory class
     */
    public Inventory() {
        movieArchive = new TreeSet<Movie>();
    }

    /**
     * Gets the movie archive
     * @return The movie archive
     */
    public List<Movie> getMovieArchive() { return new ArrayList<Movie> (movieArchive); }

    /**
     * Adds the given movie to the movie archive
     * @param thisMovie The movie object
     */
    public void addMovie(Movie thisMovie) throws IllegalArgumentException {
        // Check for existing movie
        Iterator<Movie> it = movieArchive.iterator();
        while (it.hasNext()) {
            Movie movie = it.next();
            if (movie.equals(thisMovie)) {
                throw new IllegalArgumentException("Movie already exist!");
            }
        }
        this.movieArchive.add(thisMovie);
    }

    /**
     * Removes the given movie from the movie archive
     * @param thisMovie The movie object
     */
    public void deleteMovie(Movie thisMovie) throws IllegalArgumentException {
        // Check for existing movie
        Iterator<Movie> it = movieArchive.iterator();
        while (it.hasNext()) {
            Movie movie = it.next();
            if (movie.equals(thisMovie)) {
                it.remove();
            }
        }
    }

    /**
     * Returns a List of movies object from archive, and an empty list if no movie from the title are found
     * @param title The title of the movie
     * @return The List of movies object, and an empty list if no songs from the title are found
     */
    public List<Movie> getAllMoviesByTitle(String title){
        List<Movie> movieList =  new ArrayList<Movie>();
        Iterator<Movie> it = movieArchive.iterator();
        while (it.hasNext()) {
            Movie movie = it.next();
            if (movie.getTitle().equals(title)) {
                movieList.add(movie);
            }
        }
        return movieList;
    }

    /**
     * Returns a List of movies object from archive, and an empty list if no movie from the genre are found
     * @param genre The genre of the movie
     * @return The List of movies object, and an empty list if no songs from the genre are found
     */
    public List<Movie> getAllMoviesByGenre(String genre){
        List<Movie> movieList =  new ArrayList<Movie>();
        Iterator<Movie> it = movieArchive.iterator();
        while (it.hasNext()) {
            Movie movie = it.next();
            if (movie.getGenre().equals(genre)) {
                movieList.add(movie);
            }
        }
        return movieList;
    }

    /**
     * Returns a List of movies object from archive, and an empty list if no movie from the year are found
     * @param year The genre of the movie
     * @return The List of movies object, and an empty list if no songs from the year are found
     */
    public List<Movie> getAllMoviesByYear(int year){
        List<Movie> movieList =  new ArrayList<Movie>();
        Iterator<Movie> it = movieArchive.iterator();
        while (it.hasNext()) {
            Movie movie = it.next();
            if (movie.getYear() == year) {
                movieList.add(movie);
            }
        }
        return movieList;
    }

    /**
     * Returns a List of movies object from archive, and an empty list if no movie from the year are found
     * @param thisMovie The genre of the movie
     * @return The movies object, and null if no movie from the object are found
     */
    public Movie getMovieByObj(Movie thisMovie){
        Iterator<Movie> it = movieArchive.iterator();
        while (it.hasNext()) {
            Movie movie = it.next();
            if (movie.equals(thisMovie)) {
                return movie;
            }
        }
        return null;
    }

    /**
     * Changes the stock(s) for a certain movie object in the movie archive
     * @param thisMovie The movie object
     * @param stock New stock(s)
     */
    public void reNewStock(Movie thisMovie, int stock){
        Iterator<Movie> it = movieArchive.iterator();
        while (it.hasNext()) {
            Movie movie = it.next();
            if (movie.equals(thisMovie)) {
                movie.setStock(stock);
            }
        }
    }

    /**
     * Changes the price for a certain movie object in the movie archive
     * @param thisMovie The movie object
     * @param price New price
     */
    public void reNewPrice(Movie thisMovie, int price){
        Iterator<Movie> it = movieArchive.iterator();
        while (it.hasNext()) {
            Movie movie = it.next();
            if (movie.equals(thisMovie)) {
                movie.setPrice(price);
            }
        }
    }

}
