package com.CodeCorpApi;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	
	//CRUD
	
     //CREATE
	
	public Movie createMovie(Movie m) {
		
		return movieRepository.save(m);
	}


	public List<Movie> getAllMovies() {
		// TODO Auto-generated method stub
		return movieRepository.findAll();
	}


	public Optional<Movie> findById(Long id) {
		// TODO Auto-generated method stub
		return movieRepository.findById(id);
	}


	public Movie updateMovie(long id, Movie m) {
		
		Optional<Movie>  existingMovie = movieRepository.findById(id);
		
		if(existingMovie.isPresent()) {
			
			Movie updatedMovie = existingMovie.get();
			updatedMovie.setDirector(m.getDirector());
			updatedMovie.setTitle(m.getTitle());
			updatedMovie.setGenre(m.getGenre());
			updatedMovie.setRating(m.getRating());	
			
			return movieRepository.save(updatedMovie);
		}
		
		return null;
	}


	public String deleteById(long id) {
		
		Optional<Movie>  existingMovie = movieRepository.findById(id);
		if(existingMovie.isPresent()) {
			movieRepository.deleteById(id);
			return "Movie with id"+id+"Deleted";
		}
		
		
		return "Movie with given id doesn't exist";
	}

}
