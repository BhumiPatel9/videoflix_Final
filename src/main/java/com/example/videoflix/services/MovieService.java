package com.example.videoflix.services;

import com.example.videoflix.models.MovieRepository;
import com.example.videoflix.models.Movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {


    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private MovieRepository moviesrepo;

    public List<Movie> getMovies()
    {
        return moviesrepo.findAll();

    }

    public Optional<Movie> getAMovie(String id) throws Exception
    {

        Optional<Movie> movie = moviesrepo.findById(id);

        // This is saying that if movie ref variable does not contain a value then

        if (!movie.isPresent())
        {
            throw new Exception (" Not Found : Movie with ID " + id );
        }


        return movie;

    }

    public List<Movie> getMoviesByTitle(String title)
    {

        Query query = new Query();
        query.addCriteria(Criteria.where("title" ).regex(title));

        List<Movie> movies = mongoTemplate.find(query, Movie.class);

        return movies;




    }


    public void addMovie(Movie movie)
    {

        moviesrepo.insert(movie);
    }

    public void deleteAMovie( String id)
    {
        moviesrepo.deleteById(id);
    }

    public List<Movie> getfeaturedMovies(String r)

    {
        Query query = new Query();
        query.addCriteria(Criteria.where("feature" ).is(r));
        List<Movie> movies = mongoTemplate.find(query, Movie.class);
        return movies;


    }
    public Movie editMovie(String id, Movie newMovieData)
    {

        Optional<Movie> movie = moviesrepo.findById(id);

        if(movie.isPresent()) {
            movie.get().setTitle(newMovieData.getTitle());
            movie.get().setDescription(newMovieData.getDescription());
            movie.get().setRating(newMovieData.getRating());
            movie.get().setRentPrice(newMovieData.getRentPrice());
            movie.get().setBuyPrice(newMovieData.getBuyPrice());

            Movie updateMovie = moviesrepo.save(movie.get());
            return updateMovie;

        }
        else
        {
            Movie updateMovie = null;
            return updateMovie;
        }




    }
}
