package com.bbodeum.dog.dao;

import java.util.List;

import com.bbodeum.dog.vo.Dog;
import com.bbodeum.exception.FindException;

public interface DogDAO {
	
	public void insert(Dog dog) throws FindException;
	
	public void update(Dog dog) throws FindException;
	
	public void delete(int dogId, int dogStatus) throws FindException;
	
	public List<Dog> selectByMemId(String memId) throws FindException;
	
	
}
