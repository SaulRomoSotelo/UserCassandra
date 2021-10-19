package com.UserCassandra.Project.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.UserCassandra.Project.model.User;
import com.UserCassandra.Project.service.UserService;


@RestController
@RequestMapping(path = "/api")
public class UserController {
	@Autowired
	private UserService service;
	@GetMapping(path = "/duplicatevalue/{id}")
    public String duplicateValue(@PathVariable String id){
	 String data;
    	if(service.validation(id)!=null) {
    		data="USER: id: "+service.validation(id).get().getId()+" name: "+service.validation(id).get().getName()+" \n duplicate: "+ service.duplicateValue(id);
    	}else {
    		data="Error el id no existe";
    	}
         return data;
    }

    @GetMapping(path = "/firts/{id}")
    public String firts(@PathVariable String id){
    	String data;
    	if(service.validation(id)!=null) {
    		data="USER: id: "+service.validation(id).get().getId()+" name: "+service.validation(id).get().getName()+" \n firts: "+ service.firts(id);
    	}else {
    		data="Error el id no existe";
    	}
         return data;
    }

    @GetMapping(path = "/finish/{id}")
    public String finish(@PathVariable String id){
        
        String data;
    	if(service.validation(id)!=null) {
    		data="USER: id: "+service.validation(id).get().getId()+" name: "+service.validation(id).get().getName()+" \n finish: "+ service.finish(id);
    	}else {
    		data="Error el id no existe";
    	}
         return data;
    }

    @GetMapping(path = "/bigeer/{id}")
    public String bigger(@PathVariable String id){
    	 String data;
	    	if(service.validation(id)!=null) {
	    		data="USER: id:"+service.validation(id).get().getId()+" name: "+service.validation(id).get().getName()+" \n bigger: "+ service.bigger(id);
	    	}else {
	    		data="Error el id no existe";
	    	}
	         return data;
    }
    
    //Crud
    
    @GetMapping(path = "/getAllUsers")
    public List<User> getAllUsers(){
        List<User> userList = new ArrayList(); 
        userList.addAll(service.getAllUsers());
        return userList;
    }
    @GetMapping(path = "/getUser/{id}")
    public Optional<User> getUser(@PathVariable int id){
        return service.getUserById(id);
    }
    @PostMapping(path = "/addUser")
    public ResponseEntity<User> createUser(@RequestBody User user) {
    	User newUser=service.CreateUser(user);
    	try {
    		return ResponseEntity.created(new URI("/api"+newUser.getId())).body(newUser);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
    	
    	
    }
    @PostMapping(path = "/update/{id}")
    public Optional<User> upDateUser(@PathVariable String id, @RequestBody User user) {
    	return service.upDateUser(id, user);
    }
    @GetMapping(path = "/delet/{id}")
    public void deletUser(@PathVariable String id){
         service.deletUser(id);
    }
}
