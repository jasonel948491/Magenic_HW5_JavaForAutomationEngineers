package models;

import resources.StringOptions;
import utils.HelperMethods;

import java.util.*;

public class Store {

    /**
     * The movie inventory instance
     */
    private Inventory movieInventory;

    /**
     * The scanner reference to read input from the user
     */
    private Scanner scanner;

    public Store(){
        // Creates a new movie inventory
        this.movieInventory = new Inventory();
        // Sets the scanner to listing to System.in
        this.scanner = new Scanner(System.in);
    }

    /**
     * Gets the Movie Inventory
     * @return The Movie Inventory
     */
    public Inventory getMovieInventory() {
        return movieInventory;
    }

    /**
     * Sets the Movie Inventory
     */
    public void setMovieInventory(Inventory movieInventory) { this.movieInventory = movieInventory; }

    /**
     * Displays the main menu and handles the user choice
     */
    public void mainMenu() {
        // Displays the main menu options and deceivers the users choice
        int userChoice = HelperMethods.displayOptionsAndWaitForValidOption(StringOptions.MAIN_MENU_OPTIONS);
        String userChoiceText = StringOptions.MAIN_MENU_OPTIONS[userChoice];

        // Checks for each of the options and handles accordingly
        if (userChoiceText.equals("List All Movies")) {
            List<Movie> movies = movieInventory.getMovieArchive();
            int idx = HelperMethods.displayMoviesAndWaitForValidOption(movies);
            this.checkoutMenu(movies.get(idx));

        } else if (userChoiceText.equals("Search Movie by Title")) {
            // Takes the user input for the movie title
            String in = HelperMethods.getInputFromPrompt("What movie title would you like to search: ");
            List<Movie> searchedMovies = movieInventory.getAllMoviesByTitle(in);
            if(!searchedMovies.isEmpty()) {
                // Goto Sub Menu
                this.subMenu(searchedMovies);
            } else {
                System.out.println("No movie(s) found!");
                // Returns to the Main Menu
                System.out.println("Returning to Main Menu...");
                this.mainMenu();
            }
        } else if (userChoiceText.equals("Search Movie by Genre")) {
            // Takes the user input for the movie genre
            String in = HelperMethods.getInputFromPrompt("What movie genre would you like to search: ");
            List<Movie> searchedMovies = movieInventory.getAllMoviesByGenre(in);
            if(!searchedMovies.isEmpty()) {
            // Goto Sub Menu
            this.subMenu(searchedMovies);
            } else {
                System.out.println("No movie(s) found!");
                // Returns to the Main Menu
                System.out.println("Returning to Main Menu...");
                this.mainMenu();
            }
        } else if (userChoiceText.equals("Search Movie by Year")) {
            // Takes the user input for the movie year
            String in = HelperMethods.getInputFromPrompt("What movie year would you like to search: ");
            List<Movie> searchedMovies = movieInventory.getAllMoviesByYear(Integer.parseInt(in));
            if(!searchedMovies.isEmpty()) {
                // Goto Sub Menu
                this.subMenu(searchedMovies);
            } else {
                System.out.println("No movie(s) found!");
                // Returns to the Main Menu
                System.out.println("Returning to Main Menu...");
                this.mainMenu();
            }
        } else {
            // Ends the program
            System.out.println("ENDING PROGRAM...");
            System.out.println("Thank you!");
        }
    }

    /**
     * Displays the sub menu and handles the user choice
     */
    private void subMenu(List<Movie> movies){
        // print all searched movies
        int idx = HelperMethods.displayMoviesAndWaitForValidOption(movies);
        this.checkoutMenu(movies.get(idx));
    }

    /**
     * Displays the checkout menu and handles the user choice
     */
    private void checkoutMenu(Movie movie){
        System.out.println(movie);
        int userChoice = HelperMethods.displayOptionsAndWaitForValidOption(StringOptions.CHECKOUT_MENU_OPTIONS);
        String userChoiceText = StringOptions.CHECKOUT_MENU_OPTIONS[userChoice];

        // Checks for each of the options and handles accordingly
        if (userChoiceText.equals("Checkout")) {
            System.out.println("Successful Checkout!");
            System.out.println(movie);
            if ( movie.getStock() > 1 ) {
                movieInventory.reNewStock(movie, movie.getStock() - 1);
            } else {
                movieInventory.deleteMovie(movie);
            }
        } else if (userChoiceText.equals("Back")) {
            // Returns to the Main Menu
            System.out.println("Returning to Main Menu...");
            this.mainMenu();
        }

        // Returns to the Main Menu
        System.out.println("Returning to Main Menu...");
        this.mainMenu();
    }

    /**
     * The main method and console app
     * @param args The list of arguments
     */
    public static void main(String[] args) {

        Store movieStore = new Store();
        Inventory movieInventory = new Inventory();
        Movie thisMovie;

        thisMovie = new Movie("movie1", "genre1", 2021, 1000, 5);
        movieInventory.addMovie(thisMovie);

        thisMovie = new Movie("movie2", "genre1", 2020, 800, 3);
        movieInventory.addMovie(thisMovie);

        thisMovie = new Movie("movie3", "genre3", 2021, 1000, 1);
        movieInventory.addMovie(thisMovie);

        movieStore.setMovieInventory(movieInventory);

        // Starts the application by opening the main menu
        movieStore.mainMenu();

    }

}
