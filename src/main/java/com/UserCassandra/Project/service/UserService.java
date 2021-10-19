package com.UserCassandra.Project.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UserCassandra.Project.model.User;
import com.UserCassandra.Project.repositorie.UserRepositorie;


@Service
public class UserService {
	@Autowired
	private UserRepositorie repositorie;
public List<Integer> duplicateValue( String id){
        
        if(validation(id) != null) {
	    	  Optional<User> user = validation(id); 
	    	 List<Integer> collect = user.get().getValuListes().stream().filter(entry -> Collections.frequency(user.get().getValuListes(), entry) > 1).distinct().collect(Collectors.toList());
	         return collect;
	       }else{
	    	   return null;
	       }
      }
      public Optional<Integer> firts( String id){
          
          if(validation(id) != null) {
	    	  Optional<User> user = validation(id); 
	    	 return user.get().getValuListes().stream().findFirst();
	    	  
	       }else{
	    	   return null;
	       }
      }
      public Optional<Integer> finish(String id){
    	  if(validation(id) != null) {
	    	  Optional<User> user = validation(id); 
	    	 return user.get().getValuListes().stream().findAny();
	    	  
	       }else{
	    	   return null;
	       }
          
      }

      
	  public OptionalInt bigger(String id) {
		  	
	       if(validation(id) != null) {
	    	  Optional<User> user = validation(id); 
	    	      	  
	    	  return user.get().getValuListes().stream().mapToInt(Integer::intValue).max();
	       }else{
	    	  return null; 
	       }
	  }
	    //JPA
	   public List<User> getAllUsers(){        
	   	 return (List<User>) repositorie.findAll();    
	   }
	   public User CreateUser(User user){
			return repositorie.save(user);
	   }
	   public Optional<User> getUserById(int id){
	   	return repositorie.findById(id);
	   }
	   public  Optional<User> upDateUser(String id, User upUser){
		   try{
	            int idT = Integer.parseInt(id);
	            if(repositorie.findById(idT)!= null) {
	            	Optional<User> user= repositorie.findById(idT);
	            	user.get().setName(upUser.getName());
	            	user.get().setValuListes(upUser.getValuListes());
	            	repositorie.save(user.get());
	            	return user;
	            }else {
	            	return null;
	            }	            
	        }
	        catch (NumberFormatException ex){
	        	return null;
	        }		   
	   }
	   public  void deletUser(String id){
		   try{
	            int idT = Integer.parseInt(id);
	            if(repositorie.findById(idT)!= null) {
	            	repositorie.deleteById(idT);
	            }            
	        }
	        catch (NumberFormatException ex){
	        	
	        }
		   
	   }
	   public Optional<User> validation(String id) {
		   try{
	            int idT = Integer.parseInt(id);
	            if(repositorie.findById(idT)!= null) {
	            	Optional<User> user= repositorie.findById(idT);
	               	return user;
	            }else {
	            	return null;
	            }	            
	        }
	        catch (NumberFormatException ex){
	        	return null;
	        }		
	   }
}
