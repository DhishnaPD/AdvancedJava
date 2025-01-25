package com.dhishna.mvoc;

public class Movie {

	private String name;
	private String director;
	private String genre;
	private long id;
	private long budget;
	private long revenue;
	private int rating;
	public String getName() {
	return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDirector() {
	return director;
	}
	public void setDirector(String director) {
	this.director = director;
	}
	public String getGenre() {
	return genre;
	}
	public void setGenre(String genre) {
	this.genre = genre;
	}
	public long getId() {
	return id;
	}
	public void setId(long id) {
	this.id = id;
	}
	public long getBudget() {
	return budget;
	}
	public void setBudget(long budget) {
	this.budget = budget;
	}
	public long getRevenue() {
	return revenue;
	}
	public void setRevenue(long revenue) {
	this.revenue = revenue;
	}
	@Override
	public String toString() {
	return "Movie [name=" + name + ", director=" + director + ", genre=" + 
	genre + ", id=" + id + ", budget="
	+ budget + ", revenue=" + revenue + ", rating=" + rating + 
	"]";
	}
	public Movie(String name, String director, String genre, long id, long budget, long 
	revenue, int rating) {
	super();
	this.name = name;
	this.director = director;
	this.genre = genre;
	this.id = id;
	this.budget = budget;
	this.revenue = revenue;
	this.rating = rating;
	}
	public int getRating() {
	return rating;
	}
	public void setRating(int rating) {
	this.rating = rating;
	}

}
