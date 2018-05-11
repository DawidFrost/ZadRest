package ZadanieRest.service;

import ZadanieRest.domain.Actor;
import ZadanieRest.domain.Movie;
import ZadanieRest.repository.ActorRepositoryList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActorService {

	@Autowired
	ActorRepositoryList repository;

	public List<Actor> getAll() {
		return repository.getAll();
	}

	public Actor addActor(Actor actor) {
		actor.setMovies(new ArrayList<>());
		repository.addActor(actor);
		return actor;
	}

	public Actor getActor(int id) {
		return repository.getActor(id);
	}

	public void deleteActor(int id) {
		repository.deleteActor(id);
	}

	public Actor updateActor(Actor a, Actor actor) {
		return repository.updateActor(a, actor);
	}

	public void addMovies(Movie movie, Actor actor) {
		repository.addMovies(movie, actor);
	}
}
