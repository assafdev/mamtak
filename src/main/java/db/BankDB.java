package db;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import java.util.Arrays;
import com.mongodb.Block;

import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;
import java.net.UnknownHostException;

public class BankDB {

    private MongoClient mongoClient;
    private MongoDatabase mongoDatabase;


    private String host = "localhost";
    private int port = 27017;
    private String dbName = "banks";


    public BankDB() throws UnknownHostException {
        mongoClient= new MongoClient(host , port);
        mongoDatabase = mongoClient.getDatabase(dbName);
    }





}