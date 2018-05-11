package com.ivar.enterprise.ap.service;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ivar.enterprise.ap.db.MongoDbDriver;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EntityServiceMongoDbImpl<T extends Object> implements EntityService<T> {

    Class<T> _clazz;
    String entityName;
    MongoCollection<Document> collection;

    public EntityServiceMongoDbImpl(Class<T> _clazz, String entityName){
        this._clazz = _clazz;
        this.entityName = entityName;
        collection = MongoDbDriver.getCollection("ap-db", this.entityName);
    }
    public List<T> getEntites() {
        List<T> entities = new ArrayList<T>();
        MongoCursor<Document> cursor = collection.find().iterator();
        try {
            while (cursor.hasNext()) {
                entities.add(parseObject(cursor.next().toJson()));
            }
        }catch (Exception exp){
            exp.printStackTrace();
        } finally {
            cursor.close();
        }
        return entities;
    }

    public T getEntityById(long id) {
        FindIterable<Document> findIt = collection.find(Filters.eq("id",id));
        return parseObject(findIt.first().toJson());
    }


    public T getEntityByCode(String code) {
        FindIterable<Document> findIt =  collection.find(Filters.eq("code",code));
        return parseObject(findIt.first().toJson());
    }

    public T getEntityByName(String name) {
        FindIterable<Document> findIt =  collection.find(Filters.eq("name",name));
        return parseObject(findIt.first().toJson());
    }

    public T parseObject(String json){
        try {
            JsonParser jsonParser = new JsonFactory().createParser(json);
            ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);;
            T entity = mapper.readValue(jsonParser, this._clazz);
            return entity;
        }catch (IOException ioExp){
            ioExp.printStackTrace();
        }
        return null;
    }
}
