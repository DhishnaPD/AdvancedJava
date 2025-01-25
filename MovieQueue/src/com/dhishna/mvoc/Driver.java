package com.dhishna.mvoc;

public class Driver {

	public static void main(String[] args) {
		QueueOperations movieQue = new QueueOperations();
		movieQue.addItem(new Movie("The Shawshank Redemption", "Frank Darabont", "Drama", 1, 25000000, 280000000, 9));
		 movieQue.addItem(new Movie("The Godfather", "Francis Ford Coppola", "Crime", 2, 
		6000000, 250000000, 9));
		 movieQue.addItem(new Movie("The Dark Knight", "Christopher Nolan", "Action", 3, 
		185000000, 1004558444, 8));
		 movieQue.addItem(new Movie("Pulp Fiction", "Quentin Tarantino", "Crime", 4, 
		8000000, 214179088, 8));
		 
		 movieQue.getAllMovies();
		 if(movieQue.deleteMovie(4)) {
			 System.out.println("Movie deleted");
			 movieQue.getSortedMovies();
			 }
			 
			 
			 if(movieQue.updateMovie(2, new Movie("The Godfather", "Francis Ford Coppola", 
			"Crime", 2, 6000000, 250000000, 7))) {
			 System.out.println("Movie updated");
			 movieQue.getSortedMovies();
			 }
			 
			 
			 
			}
			
	}


