package models;

import java.util.*;

public class Movie implements Comparable<Movie> {

    /**
     * The title of the movie
     */
    private String title;

    /**
     * The genre of the movie
     */
    private String genre;

    /**
     * The year of the movie
     */
    private int year;

    /**
     * The price of the movie
     */
    private int price;

    /**
     * The stocks of the movie
     */
    private int stock;

    /**
     * Creates an instance of the Movie class
     * @param title The movie name
     * @param genre The movie genre
     * @param year The movie year
     * @param price The movie casts
     * @param stock The movie directors
     */
    public Movie(String title, String genre, int year, int price, int stock) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.price = price;
        this.stock = stock;
    }

    /**
     * Gets the movie title
     * @return The movie title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Gets the movie genre
     * @return The movie genre
     */
    public String getGenre() {
        return this.genre;
    }

    /**
     * Gets the movie year
     * @return The movie year
     */
    public int getYear() {
        return this.year;
    }

    /**
     * Gets the movie price
     * @return The movie price
     */
    public int getPrice() {
        return this.price;
    }

    /**
     * Gets the movie stock
     * @return The movie stock
     */
    public int getStock() {
        return this.stock;
    }

    /**
     * Sets the price
     * @param price
     */
    public void setPrice(int price){ this.price = price; }

    /**
     * Sets the stock
     * @param stock
     */
    public void setStock(int stock){ this.stock = stock; }

    /**
     * Converters a models.Movie to a string description
     * @return The string representation of a 'models.Movie' object
     */
    @Override
    public String toString() {
        return "Movie Details ~ " + System.lineSeparator() +
               "\tTitle: " + getTitle() + System.lineSeparator() +
               "\tGenre: " + getGenre() + System.lineSeparator() +
               "\tYear: " + getYear() + System.lineSeparator() +
               "\tPrice: " + getPrice()+ System.lineSeparator() +
               "\tStock(s): " + getStock() + System.lineSeparator();
    }

    /**
     * Determines if this models.Movie obj is equal to the provided object
     * @param obj The compared object
     * @return True if the Movie are the same, and false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        // Checks if 'obj' is null or can't be assigned to a 'models.Song' class
        if (obj == null || !Movie.class.isAssignableFrom(obj.getClass())) {
            return false;
        }

        // Casts the 'obj' to a 'models.Movie' object
        final Movie otherMovie = (Movie)obj;

        // Checks if the title, genre and year are the same
        if ( (this.getTitle().equals(otherMovie.getTitle())) && (this.getGenre().equals(otherMovie.getGenre())) &&
                (this.getYear() == otherMovie.getYear()) ) {
            return true;
        }

        // Returns false, as a catch all
        return false;
    }

    /**
     * @param other The other movie object
     * @return 0 if the movie are equal and other numbers if not
     */
    @Override
    public int compareTo(Movie other) {
        int result = this.title.compareTo(other.title); //compare title
        if (result != 0){ return result; } // name is not the same
        else { // name is the same
            result = this.genre.compareTo(other.genre); //compare genre
            if (result != 0){ return result; } // genre is not the same
            else {
                result = Integer.compare(this.year, other.year);
                if (result != 0){ return result; } // year is not the same
                else {
                    return 0; //Movie is same for name, genre, and year
                }
            }
        }
    }
}
