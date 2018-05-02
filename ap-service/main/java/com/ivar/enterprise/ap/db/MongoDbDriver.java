package com.ivar.enterprise.ap.db;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDbDriver {
    public static MongoClientURI connectionString = new MongoClientURI("mongodb://localhost:27017");
    public static MongoClient mongoClient = new MongoClient(connectionString);

    public static MongoClient getClient(){
        return mongoClient;
    }

    public static MongoDatabase getDb(String db){
        return mongoClient.getDatabase(db);
    }

    public static MongoCollection<Document> getCollection(String db, String collection){
        return mongoClient.getDatabase(db).getCollection(collection);
    }
}

