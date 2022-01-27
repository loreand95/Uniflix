package it.uniflix.reviewservice.repository;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class MongoConnection {
	
	private static final String CONNECTION_STRING = "mongodb+srv://admin:WvUEreguSld7PnCL@cluster0.xmrck.mongodb.net/Uniflix?retryWrites=true&w=majority";
	private static final String DATABASE_NAME = "Uniflix";
	
	public static MongoDatabase getDatabase() {

		ConnectionString connectionString = new ConnectionString(CONNECTION_STRING);		
        // create codec registry for POJOs
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        
		MongoClientSettings settings = MongoClientSettings.builder()
				.applyConnectionString(connectionString)
				.codecRegistry(pojoCodecRegistry)
				.build();
		MongoClient mongoClient = MongoClients.create(settings);
		return mongoClient.getDatabase(DATABASE_NAME);	
	}
}
