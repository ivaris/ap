package com.ivar.enterprise.ap.db;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDbDriver {
    public static MongoClientURI connectionString = new MongoClientURI("mongodb://localhost:27017");
    public static MongoClient mongoClient = new MongoClient("127.0.0.1", getMongoDbOptions());

    public static MongoClient getClient(){
        return mongoClient;
    }

    public static MongoDatabase getDb(String db){
        return mongoClient.getDatabase(db);
    }

    public static MongoCollection<Document> getCollection(String db, String collection){
        return mongoClient.getDatabase(db).getCollection(collection);
    }

    public static MongoClientOptions getMongoDbOptions(){
        //CustomCodec<Country> countryCodec = new CustomCodec(Country.class);
        //CodecRegistry codecRegistry = CodecRegistries.fromRegistries(MongoClient.getDefaultCodecRegistry(),
          //      CodecRegistries.fromCodecs(countryCodec));
        MongoClientOptions options = MongoClientOptions.builder().build();
        return options;
    }
}

