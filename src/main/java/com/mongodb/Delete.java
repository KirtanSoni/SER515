package com.mongodb;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;

public class Delete {

    private static MongoClient mongoClient = MongoClients.create("mongodb+srv://sshah232:ye6yVTzEYA3WdBVj@scrumsimulator.nuu1fks.mongodb.net/");
    private static MongoDatabase database = mongoClient.getDatabase("test");
    private static MongoCollection<Document> userStoryCollection = database.getCollection("UserStory");

    public static void deleteUserStoryById(Integer id) {
        Bson filter = new Document("_id", new Document("$eq", id));
        userStoryCollection.deleteOne(filter);
    }
    public static void deleteAll(){
        userStoryCollection.drop();
    }
}
