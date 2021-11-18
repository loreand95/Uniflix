package it.univaq.disim.sose.rest.repository.impl;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoConnection {

	private static final String CONNECTION_STRING = "mongodb+srv://admin:WvUEreguSld7PnCL@cluster0.xmrck.mongodb.net/Uniflix?retryWrites=true&w=majority";
	private static final String DATABASE_NAME = "Uniflix";

	public static MongoDatabase getDatabase() {

		ConnectionString connectionString = new ConnectionString(CONNECTION_STRING);
		MongoClientSettings settings = MongoClientSettings.builder()
				.applyConnectionString(connectionString)
				.build();
		MongoClient mongoClient = MongoClients.create(settings);
		return mongoClient.getDatabase(DATABASE_NAME);	
	}
}
