import com.mongodb.MongoClient;
import db.DbHandler;
import model.AccountRecord;
import model.Block;
import com.google.gson.*;
import service.AccountsResponsibilityService;

import static spark.Spark.*;

public class Main {

    private static DbHandler dbHandler = new DbHandler();
    private static AccountsResponsibilityService accountsResponsibilityService = new AccountsResponsibilityService(dbHandler);

    public static void main(String[] args) {

        System.out.println("The sever is running on: " + "http://localhost:4567/hello");
        get("/hello", (req, res) -> "Hello World");

        post("/add-record" , (req, res) -> {
            res.type("application/json");
            //reading the data as json from request body
            AccountRecord accountRecord = new Gson().fromJson(req.body() , AccountRecord.class);
            return accountsResponsibilityService.addRecord(accountRecord);
//            new AccountRecord("assaf" , "david" , new Block(4 , 30) , 5023 ,"r")
        }, m -> new Gson().toJson(m));

        get("/all-data", (req, res) -> {
            res.type("application/json");
            return accountsResponsibilityService.getAll();
        }, m -> new Gson().toJson(m));

    }
}
