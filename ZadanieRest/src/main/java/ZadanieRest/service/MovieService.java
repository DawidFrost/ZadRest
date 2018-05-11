package ZadanieRest.service;

import ZadanieRest.domain.Actor;
import ZadanieRest.domain.Movie;
import ZadanieRest.domain.MovieComment;
import ZadanieRest.repository.MovieRepositoryList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

	@Autowired
	MovieRepositoryList repository;

	public List<Movie> getAll() {
		return repository.getAll();
	}

	public Movie addMovie(Movie movie) {
		movie.setActors(new ArrayList<>());
		movie.setComments(new ArrayList<>());
		repository.addMovie(movie);
		return movie;
	}

	public Movie getMovie(int id) {
		return repository.getMovie(id);
	}

	public void deleteMovie(int id) {
		repository.deleteMovie(id);
	}

	public Movie updateMovie(Movie m, Movie movie) {
		return repository.updateMovie(m, movie);
	}

	public void addMovieComment(MovieComment comment, Movie movie) {
		repository.addMovieComment(comment, movie);
	}

	public void updateRating(Movie movie, int rating) {
		double newRating = (movie.getRating() * movie.getCountRating() + rating) / (movie.getCountRating() + 1);
		movie.setCountRating(movie.getCountRating() + 1);
		movie.setRating(newRating);
	}

	public void addActors(Actor actor, Movie movie) {
		repository.addActor(actor, movie);
	}

	public void deleteComments(int id,Movie movie) {
		repository.deleteComment(id,movie);
	}
}
