package com.abdul.springbootgraphqlsecond.repository;

import com.abdul.springbootgraphqlsecond.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
