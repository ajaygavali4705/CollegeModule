package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class CollegeService {

	
	@Autowired
	private  CollegeRepository repo;
	
	
	//create & update
	public void create(College college) 
	{
		repo.save(college);//jpaRepo
	}
	
	//retrieve single value
	public College get(Integer id)
	{
		return repo.findById(id).get();
	}
	
	//retrieve all
	public List<College> listAll()
	{
		return repo.findAll();
	}
	
	public void remove(Integer id)
	{
	     repo.deleteById(id);	
	}
	
}
