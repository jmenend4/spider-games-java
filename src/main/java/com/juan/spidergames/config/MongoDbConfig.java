package com.juan.spidergames.config;

import java.util.Collection;
import java.util.Collections;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class MongoDbConfig extends AbstractMongoClientConfiguration {

	@Override
	protected String getDatabaseName() {
		// TODO Auto-generated method stub 
		return "spidergames";
	}
	
	@Override
	public MongoClient mongoClient() {
		ConnectionString connectionString =
				new ConnectionString("mongodb+srv://appuser1:DmLLWVFz9sGFLJzy@"
						+ "cluster0.qafta.mongodb.net/" + getDatabaseName());
		MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
	            .applyConnectionString(connectionString)
	            .build();
		return MongoClients.create(mongoClientSettings);
	}
	
	@Override
    public Collection<String> getMappingBasePackages() {
        return Collections.singleton("com.juan.spidergames.domain");
    }

}
