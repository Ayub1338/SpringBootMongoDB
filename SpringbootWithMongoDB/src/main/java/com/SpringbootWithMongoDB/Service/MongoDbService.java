package com.SpringbootWithMongoDB.Service;

import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.SpringbootWithMongoDB.Entities.Users;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.FindIterable;

@Component
public class MongoDbService {
	
	@Autowired
	private MongoTemplate mongoTemplate ;

	public List<Users> fetchRecords() {
		return mongoTemplate.findAll(Users.class);
	}

	public Object fetchUser(String userId) {

		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(userId));
		return mongoTemplate.find(query, Users.class);
	}
	
	
	public Object fetchCompleteDocument(String userId) {

			BasicDBObject query = new BasicDBObject();
		    query.put("_id", new ObjectId(userId));
		    FindIterable<Document> dbObj = mongoTemplate.getCollection("usersCollection").find(query);
		    return dbObj.first();
		
		
		}
	
	

	public Object createUser(Users user) {
		return mongoTemplate.save(user);
	}

	public Object deleteUser(String userId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(userId));
		return mongoTemplate.findAllAndRemove(query, Users.class) ;
	}
	
	
	
	
	
	
	
	}
	
