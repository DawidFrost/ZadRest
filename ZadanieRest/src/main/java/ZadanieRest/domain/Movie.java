package ZadanieRest.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class Movie {

	private int id;
	private String name;
	private double rating;
	private int countRating;
	private List<MovieComment> comments;
	@JsonIgnore
	private List<Actor> actors;

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public int getCountRating() {
		return countRating;
	}

	public void setCountRating(int countRating) {
		this.countRating = countRating;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public List<MovieComment> getComments() {
		return comments;
	}

	public void setComments(List<MovieComment> comments) {
		this.comments = comments;
	}
}
