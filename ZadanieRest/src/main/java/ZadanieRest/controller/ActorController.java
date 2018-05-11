package ZadanieRest.controller;

import ZadanieRest.domain.Actor;
import ZadanieRest.domain.Movie;
import ZadanieRest.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/filmweb/actor")
public class ActorController {

    @Autowired
    ActorService actorService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAll() {
        return new ResponseEntity(actorService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addActor(@RequestBody Actor actor) {
        return new ResponseEntity(actorService.addActor(actor), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<?> getActor(@PathVariable("id") int id) {
        Actor actor = actorService.getActor(id);
        if (actor == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        actorService.getActor(id);
        return new ResponseEntity(actorService.getActor(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<?> deleteActor(@PathVariable("id") int id) {
        Actor actor = actorService.getActor(id);
        if (actor == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        actorService.deleteActor(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity<?> updateActor(@PathVariable("id") int id, @RequestBody Actor actor) {
        Actor a = actorService.getActor(id);
        if (a == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        actorService.updateActor(a, actor);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{id}/movie")
    public ResponseEntity<?> addMovies(@PathVariable("id") int id, @RequestBody Movie movie) {
        Actor actor = actorService.getActor(id);
        if (actor == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        actorService.addMovies(movie, actor);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/movie")
    public ResponseEntity<?> getMovies(@PathVariable("id") int id) {
        Actor actor = actorService.getActor(id);
        if (actor == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(actor.getMovies(), HttpStatus.OK);
    }


}
