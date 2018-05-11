package ZadanieRest.controller;

import ZadanieRest.domain.Actor;
import ZadanieRest.domain.Movie;
import ZadanieRest.domain.MovieComment;
import ZadanieRest.service.MovieService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/filmweb")
public class MovieController {

	@Autowired
	MovieService movieService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getAll() {
		return new ResponseEntity(movieService.getAll(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> addMovie(@RequestBody Movie movie) {
		return new ResponseEntity(movieService.addMovie(movie), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<?> getMovie(@PathVariable("id") int id) {
		Movie movie = movieService.getMovie(id);
		if (movie == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		movieService.getMovie(id);
		return new ResponseEntity(movieService.getMovie(id), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<?> deleteMovie(@PathVariable("id") int id) {
		Movie movie = movieService.getMovie(id);
		if (movie == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		movieService.deleteMovie(id);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<?> updateMovie(@PathVariable("id") int id, @RequestBody Movie movie) {
		Movie m = movieService.getMovie(id);
		if (m == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		movieService.updateMovie(m, movie);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{id}/comments")
	public ResponseEntity<?> addComment(@PathVariable("id") int id, @RequestBody MovieComment comment) {
		Movie movie = movieService.getMovie(id);
		if (movie == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		movieService.addMovieComment(comment, movie);
		return new ResponseEntity(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}/comments")
	public ResponseEntity<?> getComments(@PathVariable("id") int id) {
		Movie movie = movieService.getMovie(id);
		if (movie == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(movie.getComments(), HttpStatus.OK);
	}

    @RequestMapping(method = RequestMethod.DELETE, value = "/{idM}/comments/{idC}")
    public ResponseEntity<?> deleteComments(@PathVariable("idM") int idM,@PathVariable("idC") int idC) {
        Movie movie = movieService.getMovie(idM);
        if (movie == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        movieService.deleteComments(idC,movie);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

	@RequestMapping(method = RequestMethod.POST, value = "/{id}/rating")
	public ResponseEntity<?> addRating(@PathVariable("id") int id, @RequestBody String json) {
		Movie movie = movieService.getMovie(id);
		if (movie == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		JSONObject jsonObject = new JSONObject(json);
		movieService.updateRating(movie, jsonObject.getInt("rating"));

		return new ResponseEntity(movie, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{id}/actors")
	public ResponseEntity<?> addActors(@PathVariable("id") int id, @RequestBody Actor actor) {
		Movie movie = movieService.getMovie(id);
		if (movie == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		movieService.addActors(actor, movie);
		return new ResponseEntity(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}/actors")
	public ResponseEntity<?> getActors(@PathVariable("id") int id) {
		Movie movie = movieService.getMovie(id);
		if (movie == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(movie.getActors(), HttpStatus.OK);
	}

}
