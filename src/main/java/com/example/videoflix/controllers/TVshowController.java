package com.example.videoflix.controllers;

import com.example.videoflix.Response;
import com.example.videoflix.models.Movie;
import com.example.videoflix.models.TVshow;
import com.example.videoflix.services.TVshowService;
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
public class TVshowController {



        @Autowired
        private TVshowService tvshowservice;


        @GetMapping("/tvshows")
        public ResponseEntity<TVshow> getTVshows()
        {
            return new ResponseEntity(tvshowservice.getTVshows(),HttpStatus.OK);

        }

        @GetMapping("/tvshows/{id}")
        public ResponseEntity getAtvshow(@PathVariable("id") String id) {

                Optional<TVshow> tvshow=null;


                try {
                        tvshow=tvshowservice.getAtvshow(id);

                } catch (Exception e) {



                        return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);

                }


                return new ResponseEntity(tvshow, HttpStatus.OK);
        }

        @PostMapping(value= "/tvshows", consumes={MediaType.APPLICATION_JSON_VALUE})
        public ResponseEntity addTVshow(@RequestBody TVshow tvshow)
        {
                tvshowservice.addTVshow(tvshow);
                return new ResponseEntity(tvshow,HttpStatus.OK);

        }

        @GetMapping("/tvshows/feature")
        public ResponseEntity getfeaturedTVshows()
        {



                return new ResponseEntity(tvshowservice.getfeaturedTVshows("true"), HttpStatus.OK);
        }

        @PutMapping(value="/tvshows/{id}", consumes={MediaType.APPLICATION_JSON_VALUE})
        public ResponseEntity editTVshow(@PathVariable("id") String id,@RequestBody TVshow newTVshow)
        {
                var customizedResponse = new Response(" Movie with ID:  " + id + "was updated successfully " , Collections.singletonList(tvshowservice.editTVshow(id, newTVshow)));

                if((tvshowservice.editTVshow(id, newTVshow)==null))
                {
                        return new ResponseEntity("Provide Id is not Found", HttpStatus.NOT_FOUND);
                }
                else
                {
                        return new ResponseEntity(customizedResponse, HttpStatus.OK);
                }

        }

        @GetMapping("/tvshows/title")
        public ResponseEntity getTitleTVshow(@RequestParam(value = "title") String title){
                var customizedResponse = new Response("A list of movies where title contains " + title, tvshowservice.getTVshowsByTitle(title));
                return new ResponseEntity(customizedResponse, HttpStatus.OK);
        }


        @DeleteMapping("/tvshows/{id}")
        public ResponseEntity deleteATVshow(@PathVariable("id") String id)
        {

                tvshowservice.deleteATVshow(id);
                return new ResponseEntity(HttpStatus.OK);


        }
}
