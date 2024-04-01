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

    public Movie updateMovie(Integer id, MovieInput movieInput) {
//        find if the id is valid or not;
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new RuntimeException("Movie does not exist"));

        movie.setTitle(movieInput.title());
        movie.setDirector(movieInput.director());
        movie.setStudio(movieInput.studio());
        movie.setReleaseYear(movieInput.releaseYear());
        movie.setMovieCast(movieInput.movieCast());

        return movieRepository.save(movie);

    }

    public String deleteMovie(Integer id) {
        //        find if the id is valid or not;
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new RuntimeException("Movie does not exist"));

        movieRepository.delete(movie);

        return "Movie deleted Successfully";
    }

}
