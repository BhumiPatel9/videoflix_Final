package com.example.videoflix.controllers;

import com.example.videoflix.Response;
import com.example.videoflix.models.Movie;
import com.example.videoflix.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class MovieController {

    @Autowired
    private MovieService movieservice;


    @GetMapping("/movies")
    public ResponseEntity getMovies()
    {
        return new ResponseEntity( movieservice.getMovies(), HttpStatus.OK);

    }

    @GetMapping("/movies/{id}")
    public ResponseEntity getAMovie(@PathVariable("id") String id) {

        Optional<Movie> movie=null;


        try {
            movie=movieservice.getAMovie(id);

        } catch (Exception e) {



            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);

        }


        return new ResponseEntity(movie, HttpStatus.OK);

    }

    @GetMapping("/movies/title")
    public ResponseEntity getTitleMovies(@RequestParam(value = "title") String title){
        var customizedResponse = new Response("A list of movies where title contains " + title, movieservice.getMoviesByTitle(title));
        return new ResponseEntity(customizedResponse, HttpStatus.OK);
    }

    @PostMapping(value= "/movies", consumes={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity  addMovie(@RequestBody Movie movie)
    {
        movieservice.addMovie(movie);
        return new ResponseEntity(movie,HttpStatus.OK);

    }

    @GetMapping("/movies/feature")
    public ResponseEntity getfeaturedMovies()
    {

        return new ResponseEntity(movieservice.getfeaturedMovies("true"), HttpStatus.OK);
    }

    @PutMapping(value = "/movies/{id}", consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity editMovie(@PathVariable("id") String id, @RequestBody Movie newMovie )

    {


        var customizedResponse = new Response(" Movie with ID:  " + id + "was updated successfully " , Collections.singletonList(movieservice.editMovie(id, newMovie)));

        if((movieservice.editMovie(id, newMovie)==null))
        {
            return new ResponseEntity("Provide Id is not Found", HttpStatus.NOT_FOUND);
        }
        else
        {
            return new ResponseEntity(customizedResponse, HttpStatus.OK);
        }




    }



    @DeleteMapping("/movies/{id}")
    public ResponseEntity deleteAMovie(@PathVariable("id") String id)
    {

        movieservice.deleteAMovie(id);
        return new ResponseEntity(HttpStatus.OK);


    }
}
