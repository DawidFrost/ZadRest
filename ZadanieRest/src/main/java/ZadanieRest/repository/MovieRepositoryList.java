package ZadanieRest.repository;

import ZadanieRest.domain.Actor;
import ZadanieRest.domain.Movie;
import ZadanieRest.domain.MovieComment;
import org.springframework.stereotype.Repository;

import javax.xml.stream.events.Comment;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieRepositoryList {

	private static List<Movie> db = new ArrayList<Movie>();
	private static int currentId = 1;
	private static int commentId = 1;

	public List<Movie> getAll() {
		return db;
	}

	public void addMovie(Movie movie) {
		movie.setId(currentId++);
		db.add(movie);
	}

	public Movie getMovie(int id) {
		for (Movie movie : db) {
			if (movie.getId() == id) {
				return movie;
			}
		}
		return null;
	}

	public void deleteMovie(int id) {
		db.remove(getMovie(id));
	}

	public Movie updateMovie(Movie m, Movie movie) {
		m.setName(movie.getName());
		return m;
	}

	public void addMovieComment(MovieComment comment, Movie movie) {
		comment.setId(commentId++);
		movie.getComments().add(comment);
	}

	public void addActor(Actor actor, Movie movie) {
		movie.getActors().add(actor);
	}

	public void deleteComment(int id,Movie movie) {
		for ( MovieComment comment : movie.getComments()) {
			if (comment.getId() == id) {
				movie.getComments().remove(comment);
			}
		}
	}
}
