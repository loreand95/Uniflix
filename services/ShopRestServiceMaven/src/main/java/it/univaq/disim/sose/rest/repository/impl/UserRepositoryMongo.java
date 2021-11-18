package it.univaq.disim.sose.rest.repository.impl;

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
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.FindOneAndUpdateOptions;
import com.mongodb.client.model.ReturnDocument;
import com.mongodb.client.model.Updates;
import it.univaq.disim.sose.rest.model.Order;
import it.univaq.disim.sose.rest.model.MovieBO;
import it.univaq.disim.sose.rest.model.User;
import it.univaq.disim.sose.rest.repository.UserRepository;
import it.univaq.disim.sose.rest.utils.PasswordUtils;





public class UserRepositoryMongo implements UserRepository{

	@Override
	public User signIn(User user) {

		MongoDatabase database = MongoConnection.getDatabase();
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

		MongoDatabase database = MongoConnection.getDatabase();
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
	public Set<MovieBO> getLibrary(String userId) {

		Set<MovieBO> movies = new HashSet<MovieBO>();

		//Connection
		MongoDatabase database = MongoConnection.getDatabase();
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
				MovieBO movie = getMovie(order.getMovieId());
				if(movie !=null) {
					// TODO verificare i  tipi implementati per movie
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
	public MovieBO getMovie(long movieId) {

		MongoDatabase database = MongoConnection.getDatabase();
		MongoCollection<Document> collection = database.getCollection("Movies");
		//Query
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("movieId", movieId);
		Document document = collection.find(searchQuery).first();
		try {
			if(document != null) {
				ObjectMapper mapper = new ObjectMapper();
				MovieBO movie = mapper.readValue(document.toJson(), MovieBO.class);
				return movie;
			}			
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean addToLibrary(String userId, long movieId,Order order) {
		MongoDatabase database = MongoConnection.getDatabase();
		MongoCollection<Document> collection = database.getCollection("Users");
		Gson gson= new Gson();
		String orderStr = gson.toJson(order, Order.class);

		Bson filter = Filters.eq("id", userId);
		Bson update = Updates.push("library", Document.parse(orderStr));
		FindOneAndUpdateOptions options = new FindOneAndUpdateOptions()
				.returnDocument(ReturnDocument.AFTER);
		Document result = collection.findOneAndUpdate(filter, update, options);
		System.out.println(result.toJson());
		return false;
	}
}
