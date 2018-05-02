package com.ivar.enterprise.ap.db;

import com.ivar.enterprise.ap.domain.CountryCodec;
import com.ivar.enterprise.ap.domain.CountryCodecProvider;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;

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
        CodecRegistry codecRegistry = CodecRegistries.fromRegistries(
                CodecRegistries.fromCodecs(CodecRegistries.fromProviders(new CountryCodecProvider()).get(CountryCodec.class)), MongoClient.getDefaultCodecRegistry());
        MongoClientOptions options = MongoClientOptions.builder()
                .codecRegistry(codecRegistry).build();
        return options;
    }
}

