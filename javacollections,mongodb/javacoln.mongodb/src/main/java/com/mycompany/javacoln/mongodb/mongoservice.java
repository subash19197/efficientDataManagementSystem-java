/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javacoln.mongodb;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class mongoservice {
    private MongoCollection<Document> collection;

    public mongoservice() {
        String connectionString = "mongodb://localhost:27017";
        MongoClient mongoClient = MongoClients.create(connectionString);

       
        MongoDatabase database = mongoClient.getDatabase("datamanagementsystem");

        
        collection = database.getCollection("Records");
    }

    public void saveRecord(Document doc) {
        collection.insertOne(doc);
    }

    public void listRecords() {
        for (Document doc : collection.find()) {
            System.out.println(doc.toJson());
        }
        
    }
    public void updateRecord(String key, String newValue) {
        Document query = new Document("key", key);
        Document update = new Document("$set", new Document("value", newValue));
        collection.updateOne(query, update);
    }

   
    public void deleteRecord(String key) {
        Document query = new Document("key", key);
        collection.deleteOne(query);
    }
}
    

