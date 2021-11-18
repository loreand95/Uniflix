package it.uniflix.userservice.repository.impl.mongo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.FindOneAndUpdateOptions;
import com.mongodb.client.model.ReturnDocument;
import com.mongodb.client.model.Updates;

import it.uniflix.userservice.dto.AvailableFieldsReq;
import it.uniflix.userservice.dto.AvailableFieldsRes;
import it.uniflix.userservice.model.Movie;
import it.uniflix.userservice.model.Order;
import it.uniflix.userservice.model.User;
import it.uniflix.userservice.repository.UserRepository;
import it.uniflix.userservice.utils.PasswordUtils;

public class UserRepositoryMongo implements UserRepository{

	@Override
	public User signIn(User user) {

		MongoDatabase database = MongoConnection.getInstance().getDatabase();
		MongoCollection<Document> collection = database.getCollection("Users");

		//Query
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("email", user.getEmail());

		Document document = collection.find(searchQuery).first();

		try {
			if(document != null) {			
				ObjectMapper mapper = new ObjectMapper();
				User userRes = mapper.readValue(document.toJson(), User.class);

				if(userRes != null && PasswordUtils.verifyUserPassword(user.getPassword(), userRes.getPassword())) {

					//Remove password
					userRes.setPassword(null);

					return userRes;
				}
				return null;
			}
		} catch (IOException e) {
			Logger.getLogger(this.getClass().getCanonicalName()).log(Level.SEVERE, "", e);
		}
		return null;
	}

	@Override
	public User signUp(User user) {

		user.setId(UUID.randomUUID().toString());
		
		MongoDatabase database = MongoConnection.getInstance().getDatabase();
		MongoCollection<Document> collection = database.getCollection("Users");

		Document newUser = new Document();
		newUser.append("id", user.getId());
		newUser.append("email", user.getEmail());
		newUser.append("password", PasswordUtils.generateSecurePassword(user.getPassword()));
		newUser.append("library", new ArrayList());

		collection.insertOne(newUser);
		
		//Remove password
		user.setPassword(null);
		
		return user;
	}

	@Override
	public Set<Movie> getLibrary(String userId) {

		Set<Movie> movies = new HashSet<Movie>();
		
		//Connection
		MongoDatabase database = MongoConnection.getInstance().getDatabase();
		MongoCollection<Document> collection = database.getCollection("Users");

		//Query
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("id", userId);

		Document document = collection.find(searchQuery).first();

		List<Document> orders = document.getList("library", Document.class);

		
		ObjectMapper mapper = new ObjectMapper();
		for(Document orderDoc : orders) {

			try {
				Order order = mapper.readValue(orderDoc.toJson(), Order.class);
			
				//Retrieve film from db
				Movie movie = getMovie(order.getMovieId());
				if(movie !=null) {
					movie.setMovieId(order.getMovieId());
					movie.setPurchaseDate(order.getPurchaseDate());
					movie.setPrice(order.getPrice());
					
					movies.add(movie);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return movies;
	}
	
	@Override
	public Movie getMovie(long movieId) {

		MongoDatabase database = MongoConnection.getInstance().getDatabase();
		MongoCollection<Document> collection = database.getCollection("Users");

		//Query
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("movieId", movieId);

		Document document = collection.find(searchQuery).first();
		
		Bson filter = Filters.eq("id", "66ba3a11-dc58-4f56-9424-93384aa76962");
		Bson update = Updates.push("library", new Document());
		FindOneAndUpdateOptions options = new FindOneAndUpdateOptions()
		                                    .returnDocument(ReturnDocument.AFTER);
		Document result = collection.findOneAndUpdate(filter, update, options);
		
		//Document result = collection.find(filter).first();
		
		System.out.println(result.toJson());

		
		
		try {
			if(document != null) {
				ObjectMapper mapper = new ObjectMapper();
				Movie movie = mapper.readValue(document.toJson(), Movie.class);
				return movie;
			}			
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public AvailableFieldsRes available(AvailableFieldsReq fields) {
		
		MongoDatabase database = MongoConnection.getInstance().getDatabase();
		MongoCollection<Document> collection = database.getCollection("Users");

		BasicDBObject filter = new BasicDBObject();
		filter.put("email", fields.getEmail());
		
		Document result = collection.find(filter).first();
		
		//DTO
		AvailableFieldsRes res = new AvailableFieldsRes();
		res.setEmail(result==null);
		
		return res;
	}
}
