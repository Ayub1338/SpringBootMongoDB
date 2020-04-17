package com.SpringbootWithMongoDB.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.SpringbootWithMongoDB.Entities.Users;
import com.SpringbootWithMongoDB.Service.MongoDbService;

@RestController
public class MongoDBController {
	
	@Autowired
	MongoDbService MongoDBService;
	
	@RequestMapping(value= "/allUsers",method = RequestMethod.GET)
	public Object getIndexPage() {
		
		
		return MongoDBService.fetchRecords();
	}

	@RequestMapping(value= "/fetchUser/{userId}",method = RequestMethod.GET)
	public Object fetchUser(@PathVariable String userId ) {
		return MongoDBService.fetchUser(userId);
	}
	
	@RequestMapping(value= "/createUser",method = RequestMethod.POST)
	public Object createUser(@RequestBody Users user) {
		return MongoDBService.createUser(user);
	}
	
	@RequestMapping(value= "/deleteUser/{userId}",method = RequestMethod.GET)
	public Object deleteUser(@PathVariable String userId ) {
		return MongoDBService.deleteUser(userId);
	}
	
	@RequestMapping(value= "/fetchCompleteDocument/{userId}",method = RequestMethod.GET)
	public Object fetchCompleteDocument(@PathVariable String userId ) {
		return MongoDBService.fetchCompleteDocument(userId);
	}
	
	
	
	
	
}
