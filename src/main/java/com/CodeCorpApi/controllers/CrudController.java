package com.CodeCorpApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.CodeCorpApi.Models.Movie;
import com.CodeCorpApi.Service.MovieService;

@RestController
@RequestMapping("/CRUD")
public class CrudController {
	
	
	@Autowired
	private MovieService movieService;
	
	
	//CREATE
	
	@PostMapping("/movie")
	public Movie createMovie(@RequestBody Movie m) {
		
		return movieService.createMovie(m);		
	}
	
	//READ
	
	//ALL the movies
	
		@GetMapping("/allMovies")
		public List<Movie> getAllMovies(){
			
			return movieService.getAllMovies();
			
		}
	
	//movie by id
	    @PreAuthorize("hasRole('USER')")
		@GetMapping("/movie/{id}")
		public Movie getMovie(@PathVariable Long id) {
			
			if(movieService.findById(id).isPresent()) {
				return movieService.findById(id).get();
			}
			System.out.println("Movie with given id "+id+" does not exist");
			return null;
		}
		
	 //UPDATE
	 
		@PutMapping("/updateMovie/{id}")
		public Movie updateMovie(@PathVariable long id, @RequestBody Movie m) {
			
			Movie  updatedMovie = movieService.updateMovie(id,m);
			return updatedMovie;
		}
		
	 //DELETE
	    @PreAuthorize("hasRole('Admin')")
		@DeleteMapping("/delete/{id}")
		public String deleteMovie(@PathVariable long id) {
			
			return movieService.deleteById(id);
			
		}
		

}
