package com.abdul.springbootgraphqlsecond.service;

import com.abdul.springbootgraphqlsecond.models.Movie;
import com.abdul.springbootgraphqlsecond.models.MovieInput;
import com.abdul.springbootgraphqlsecond.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    //    query(get request)
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    //    mutation(add, post request)
    public Movie addMovie(MovieInput movieInput) {
//        create object of movie and inject the constructors
        Movie movie = new Movie(movieInput.title(),
                movieInput.director(),
                movieInput.studio(),
                movieInput.releaseYear(),
                movieInput.movieCast());

       return movieRepository.save(movie);
    }

}
