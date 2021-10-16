package it.uniflix.userservice.service.impl.repository.impl.mongo;

import java.io.IOException;

import org.bson.Document;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import it.uniflix.userservice.model.User;
import it.uniflix.userservice.service.impl.repository.UserRepository;

public class UserRepositoryMongo implements UserRepository{

	public User signIn(User user) {

		MongoDatabase database = MongoConnection.getDatabase();
		MongoCollection<Document> collection = database.getCollection("Users");

		//Query
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("email", user.getEmail());
		searchQuery.put("password", user.getPassword());
		
		Document document = collection.find(searchQuery).first();
		
		try {
			if(document != null) {
				ObjectMapper mapper = new ObjectMapper();
				User obj = mapper.readValue(document.toJson(), User.class);
				return obj;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return null;
	}

}
