package com.dhishna.mvoc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class QueueOperations {

    // Declare a PriorityQueue of Movie objects
    private PriorityQueue<Movie> movies = new PriorityQueue<>(new MovieComparator());

    // Add a movie to the queue
    public void addItem(Movie movie) {
        this.movies.add(movie);
    }

    // Display details of a movie
    public void showMovieDetails(Movie currentMovie) {
        System.out.println("=======================================");
        System.out.println("Id : " + currentMovie.getId());
        System.out.println("Name : " + currentMovie.getName());
        System.out.println("Director : " + currentMovie.getDirector());
        System.out.println("Genre : " + currentMovie.getGenre());
        System.out.println("Rating : " + currentMovie.getRating());
        System.out.println("Budget : $ " + currentMovie.getBudget());
        System.out.println("Revenue : $ " + currentMovie.getRevenue());
        System.out.println("=======================================");
    }

    // Display all movies in the queue
    public void getAllMovies() {
        Iterator<Movie> movieIterator = this.movies.iterator();
        while (movieIterator.hasNext()) {
            Movie currentMovie = movieIterator.next();
            showMovieDetails(currentMovie);
        }
    }

    // Delete a movie by ID
    public boolean deleteMovie(long id) {
        boolean deleted = false;
        if (!this.movies.isEmpty()) {
            Iterator<Movie> movieIterator = this.movies.iterator();
            while (movieIterator.hasNext()) {
                Movie currentMovie = movieIterator.next();
                if (currentMovie.getId() == id) {
                    movieIterator.remove();
                    deleted = true;
                    break; // Exit loop after deletion
                }
            }
        }
        return deleted;
    }

    // Get movie by ID
    public Movie getMovieById(long id) {
        Movie movie = null;
        Iterator<Movie> movieIterator = this.movies.iterator();
        while (movieIterator.hasNext()) {
            Movie currentMovie = movieIterator.next();
            if (currentMovie.getId() == id) {
                movie = currentMovie;
                break; // Exit loop once found
            }
        }
        return movie;
    }

    // Update movie details
    public boolean updateMovie(long id, Movie movie) {
        boolean isUpdated = false;
        Iterator<Movie> movieIterator = this.movies.iterator();
        while (movieIterator.hasNext()) {
            Movie currentMovie = movieIterator.next();
            if (currentMovie.getId() == id) {
                currentMovie.setName(movie.getName());
                currentMovie.setBudget(movie.getBudget());
                currentMovie.setDirector(movie.getDirector());
                currentMovie.setGenre(movie.getGenre());
                currentMovie.setRating(movie.getRating());
                currentMovie.setRevenue(movie.getRevenue());
                isUpdated = true;
                break; // Exit loop after update
            }
        }
        return isUpdated;
    }

    // Return the current movie queue
    public PriorityQueue<Movie> getMovieQue() {
        return this.movies;
    }

    // Display sorted movies by rating
    public void getSortedMovies() {
        List<Movie> movieList = new ArrayList<>(this.movies);
        Collections.sort(movieList, new MovieComparator());
        for (Movie movie : movieList) {
            showMovieDetails(movie);
        }
    }
}
