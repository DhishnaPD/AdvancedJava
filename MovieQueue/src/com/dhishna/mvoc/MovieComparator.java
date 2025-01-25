package com.dhishna.mvoc;
import java.util.Comparator;
public class MovieComparator  implements Comparator<Movie> {

	@Override
	public int compare(Movie o1, Movie o2) {
	// TODO Auto-generated method stub
	return Integer.compare(o2.getRating(), o1.getRating());
	}

}
