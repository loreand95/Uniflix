package it.uniflix.actorservice.service;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoConnection {
	
	private static final String CONNECTION_STRING = "mongodb+srv://steflo:pizza11@cluster0.xmrck.mongodb.net/Uniflix?retryWrites=true&w=majority";
	private static final String DATABASE_NAME = "Uniflix";

	private static MongoConnection mongoConnection;
	
	private static MongoClient mongoClient;
	
	private MongoConnection() {
		
		ConnectionString connectionString = new ConnectionString(CONNECTION_STRING);
		
        // Create codec registry for POJOs
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
       
		MongoClientSettings settings = MongoClientSettings.builder()
				.applyConnectionString(connectionString)
				.codecRegistry(pojoCodecRegistry)
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


