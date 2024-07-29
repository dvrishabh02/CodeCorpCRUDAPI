package com.CodeCorpApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
		
		@GetMapping("/movie/{id}")
		public Movie getMovie(@PathVariable Long id) {
			
			if(movieService.findById(id).isPresent()) {
				return movieService.findById(id).get();
			}
			return null;
		}
		
	 //UPDATE
	 
		@PutMapping("/updateMovie/{id}")
		public Movie updateMovie(@PathVariable long id, @RequestBody Movie m) {
			
			Movie  updatedMovie = movieService.updateMovie(id,m);
			return updatedMovie;
		}
		
	 //DELETE
		
		@DeleteMapping("delete/{id}")
		public String deleteMovie(@PathVariable long id) {
			
			return movieService.deleteById(id);
			
		}
		

}
