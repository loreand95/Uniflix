package it.uniflix.userservice.repository.impl.mongo;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoConnection {
	
	private static final String CONNECTION_STRING = "mongodb+srv://admin:WvUEreguSld7PnCL@cluster0.xmrck.mongodb.net/Uniflix?retryWrites=true&w=majority";
	private static final String DATABASE_NAME = "Uniflix";

	private static MongoConnection mongoConnection;
	
	private static MongoClient mongoClient;
	
	private MongoConnection() {
		
		ConnectionString connectionString = new ConnectionString(CONNECTION_STRING);
		MongoClientSettings settings = MongoClientSettings.builder()
				.applyConnectionString(connectionString)
				.build();
		mongoClient = MongoClients.create(settings);
		
	}
	
	public static synchronized MongoConnection getInstance() {
		
		if(mongoConnection == null) {
			mongoConnection = new MongoConnection();
		}
		
		return mongoConnection;
	}
	
	public MongoDatabase getDatabase() {
		return mongoClient.getDatabase(DATABASE_NAME);	
	}
}
