package com.abdul.springbootgraphqlsecond.controller;

import com.abdul.springbootgraphqlsecond.models.Movie;
import com.abdul.springbootgraphqlsecond.models.MovieInput;
import com.abdul.springbootgraphqlsecond.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;


//      get movies
    @QueryMapping
    List<Movie> getAllMoviesHandler(){     //    define handler
        return movieService.getAllMovies();
    }


//    add movie
    @MutationMapping
    Movie addMovieHandler(@Argument MovieInput movieInput){
        return movieService.addMovie(movieInput);
    }
}
