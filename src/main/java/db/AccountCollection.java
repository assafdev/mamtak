package db;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import datastructures.LinkCutTree;
import models.Account;
import org.bson.Document;

import java.util.Arrays;
import java.util.List;

public class AccountCollection {

    private MongoDatabase db;
    private MongoCollection<Document> collection;
    private String collectionName = "accounts";

    public AccountCollection(MongoDatabase db){
        this.db = db;
        this.collection = db.getCollection(collectionName);
    }

    public void addAccount(Account account) {
        /*Document doc = new Document("name", "MongoDB")
                .append("type", "database")
                .append("count", 1)
                .append("versions", Arrays.asList("v3.2", "v3.0", "v2.6"))
                .append("info", new Document("x", 203).append("y", 102));*/
    }

}


