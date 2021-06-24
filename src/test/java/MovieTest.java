import models.Movie;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MovieTest {

    /**
     * This test is for the 'Getters'
     */
    @Test
    public void testGetters(){
        String title = "title1";
        String genre = "genre1";
        int year = 2021;
        int price = 1000;
        int stock = 5;

        Movie movie = new Movie(title, genre, year, price, stock);

        Assert.assertEquals(movie.getTitle(), title);
        Assert.assertEquals(movie.getGenre(), genre);
        Assert.assertEquals(movie.getYear(), year);
        Assert.assertEquals(movie.getPrice(), price);
        Assert.assertEquals(movie.getStock(), stock);
    }

    /**
     * This test is for the 'toString' override
     */
    @Test
    public void testToString() {

        String title = "title1";
        String genre = "genre1";
        int year = 2021;
        int price = 1000;
        int stock = 5;

        Movie movie = new Movie(title, genre, year, price, stock);

        String expectedString = "Movie Details ~ " + System.lineSeparator() +
                "\tTitle: " + title + System.lineSeparator() +
                "\tGenre: " + genre + System.lineSeparator() +
                "\tYear: " + year + System.lineSeparator() +
                "\tPrice: " + price + System.lineSeparator() +
                "\tStock(s): " + stock + System.lineSeparator();

        Assert.assertEquals(movie.toString(), expectedString);
    }

    /**
     * This test is for the 'equals' override
     */
    @Test
    public void testEquals() {

        Movie movie = new Movie("title1", "genre1", 2021, 1000, 5);
        Movie dupMovie = new Movie("title1", "genre1", 2021, 1000, 5);
        Movie wrongMovie = new Movie("title2", "genre2", 2020, 1000, 5);

        Assert.assertFalse(movie.equals(wrongMovie));
        Assert.assertTrue(movie.equals(dupMovie));

    }

    /**
     * This test is for the 'compareTo' override
     */
    @Test
    public void testCompareTo() {
        Movie movie0 = new Movie("title0", "genre0", 2021, 1000, 5);
        Movie movie1 = new Movie("title1", "genre1", 2021, 1000, 5);
        Movie dupMovie = new Movie("title1", "genre1", 2021, 1000, 5);
        Movie movie2 = new Movie("title2", "genre2", 2020, 1000, 5);

        Assert.assertEquals(movie1.compareTo(dupMovie), 0);
        Assert.assertEquals(movie1.compareTo(movie0), 1);
        Assert.assertEquals(movie1.compareTo(movie2), -1);
    }
}
