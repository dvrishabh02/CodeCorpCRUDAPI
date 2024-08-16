package com.CodeCorpApi.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CodeCorpApi.Models.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{

		

}
