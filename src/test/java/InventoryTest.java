import models.Inventory;
import models.Movie;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class InventoryTest {

    /**
     * This tests is for getters
     */
    @Test
    public void testGetters(){
        Inventory movieInventory = new Inventory();
        Movie thisMovie;

        thisMovie = new Movie("movie1", "genre1", 2021, 1000, 5);
        movieInventory.addMovie(thisMovie);

        Assert.assertTrue(movieInventory.getMovieArchive().contains(thisMovie));
    }

    /**
     * This tests adding and deleting movies
     */
    @Test
    public void testAddDeleteMovie() {
        Inventory movieInventory = new Inventory();
        Movie thisMovie;

        thisMovie = new Movie("movie1", "genre1", 2021, 1000, 5);

        movieInventory.addMovie(thisMovie);
        Assert.assertTrue(movieInventory.getMovieArchive().contains(thisMovie));

        movieInventory.deleteMovie(thisMovie);
        Assert.assertFalse(movieInventory.getMovieArchive().contains(thisMovie));
    }

    /**
     * This tests for getting movies by title
     */
    @Test
    public void testGetMoviesByTitle() {
        Inventory movieInventory = new Inventory();
        Movie thisMovie;

        thisMovie = new Movie("movie1", "genre1", 2021, 1000, 5);
        movieInventory.addMovie(thisMovie);

        List<Movie> result = movieInventory.getAllMoviesByTitle("movie1");
        Assert.assertTrue(result.contains(thisMovie));
    }

    /**
     * This tests for getting movies by genre
     */
    @Test
    public void testGetMoviesByGenre() {
        Inventory movieInventory = new Inventory();
        Movie thisMovie;

        thisMovie = new Movie("movie1", "genre1", 2021, 1000, 5);
        movieInventory.addMovie(thisMovie);

        List<Movie> result = movieInventory.getAllMoviesByGenre("genre1");
        Assert.assertTrue(result.contains(thisMovie));
    }

    /**
     * This tests for getting movies by year
     */
    @Test
    public void testGetMoviesByYear() {
        Inventory movieInventory = new Inventory();
        Movie thisMovie;

        thisMovie = new Movie("movie1", "genre1", 2021, 1000, 5);
        movieInventory.addMovie(thisMovie);

        List<Movie> result = movieInventory.getAllMoviesByYear(2021);
        Assert.assertTrue(result.contains(thisMovie));
    }

    /**
     * This tests for getting movies by obj
     */
    @Test
    public void testGetMoviesByObj() {
        Inventory movieInventory = new Inventory();
        Movie thisMovie;

        thisMovie = new Movie("movie1", "genre1", 2021, 1000, 5);
        movieInventory.addMovie(thisMovie);

        Movie result = movieInventory.getMovieByObj(thisMovie);
        Assert.assertTrue(result.equals(thisMovie));
    }

    /**
     * This tests for reNewStock
     */
    @Test
    public void testReNewStock() {
        Inventory movieInventory = new Inventory();
        Movie thisMovie;
        int newStock = 10;

        thisMovie = new Movie("movie1", "genre1", 2021, 1000, 5);
        movieInventory.addMovie(thisMovie);

        movieInventory.reNewStock(thisMovie, newStock);
        Assert.assertEquals(movieInventory.getMovieByObj(thisMovie).getStock(), newStock);

    }

    /**
     * This tests for reNewPrice
     */
    @Test
    public void testReNewPrice() {
        Inventory movieInventory = new Inventory();
        Movie thisMovie;
        int newPrice = 500;

        thisMovie = new Movie("movie1", "genre1", 2021, 1000, 5);
        movieInventory.addMovie(thisMovie);

        movieInventory.reNewPrice(thisMovie, newPrice);
        Assert.assertEquals(movieInventory.getMovieByObj(thisMovie).getPrice(), newPrice);

    }

}
