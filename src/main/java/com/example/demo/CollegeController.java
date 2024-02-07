//to demonstrate controller class to send command to the server 
package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.NoResultException;

@RestController
public class CollegeController {

	@Autowired
	private CollegeService service;
	
	//restful API method for Retrieval operation 
	@GetMapping("/getcollege")
	public List<College> readAll()
	{
		return service.listAll();
	}
	
	@GetMapping("/getcollege/{id}")
	public ResponseEntity<College> get(@PathVariable Integer id)
	{
	   try
	   {
	    	College college = service.get(id);
	    	return new ResponseEntity<College>(college, HttpStatus.OK);
	   }
	
	   
	   catch (NoResultException e)
	   {
	
		    return new ResponseEntity<College>(HttpStatus.NOT_FOUND);
	   }
	}
	
	
	//RESTful API method for create operation 
	@PostMapping("/addcollege")
	public void create(@RequestBody College college)
	{
		service.create(college);
		
	}
	
	
	//RESTful API method for Update operation 
	@PutMapping("/updatecollege/{id}")
	public ResponseEntity<?> update(@RequestBody College college, @PathVariable Integer id)
	{
			
		try
		{
			College existCollege = service.get(id);
			service.create(college);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (NoResultException e)
		{
		
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
		
		
	//RESTful API method for Delete operation 
	@DeleteMapping("/college/{id}")
	public void delete(@PathVariable Integer id)
	{
		service.remove(id);
	}
	
	
	
}
