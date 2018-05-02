package com.ivar.enterprise.ap.service;

import com.ivar.enterprise.ap.db.MongoDbDriver;
import com.ivar.enterprise.ap.domain.Country;
import com.ivar.enterprise.ap.domain.CountryCodec;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;

import java.util.ArrayList;
import java.util.List;

public class CountryServiceMongoDbImpl implements CountryService {

    public List<Country> getCountries() {
        List<Country> countries = new ArrayList<Country>();
        MongoCollection<Document> collection = MongoDbDriver.getCollection("ap-db", "country");
        MongoCursor<Country> cursor = collection.withDocumentClass(Country.class).find().iterator();
        try {
            while (cursor.hasNext()) {
                countries.add(cursor.next());
            }
        } finally {
            cursor.close();
        }
        return countries;
    }

    public Country getCountryById(long id) {
        MongoCollection<Document> collection = MongoDbDriver.getCollection("ap-db", "country");
        return collection.withDocumentClass(Country.class).find(Filters.eq("id",id)).first();
    }

    public Country getCountryByCode(String code) {
        MongoCollection<Document> collection = MongoDbDriver.getCollection("ap-db", "country");
        return collection.withDocumentClass(Country.class).find(Filters.eq("code",code)).first();

    }

    public Country getCountryByName(String name) {
        MongoCollection<Document> collection = MongoDbDriver.getCollection("ap-db", "country");
        return collection.withDocumentClass(Country.class).find(Filters.eq("name",name)).first();

    }
}
