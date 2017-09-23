import db.DbHandler;
import models.AccountRecord;
import com.google.gson.*;
import services.AccountsResponsibilityService;

import static spark.Spark.*;

public class Main {

    private static DbHandler dbHandler = new DbHandler();
    private static AccountsResponsibilityService accountsResponsibilityService = new AccountsResponsibilityService(dbHandler);
    private static final String API_CONTEXT = "/api";
    public static void main(String[] args) {

        System.out.println("The sever is running on: " + "http://localhost:4567/hello");

        staticFileLocation("/public");

        setupEndpoints();

    }

    private static void setupEndpoints() {
        post(API_CONTEXT + "/accounts/add-record", "application/json", (req, res) -> {
            res.type("application/json");

            AccountRecord accountRecord = new Gson().fromJson(req.body() , AccountRecord.class);
            String ret = accountsResponsibilityService.addRecord(accountRecord);

            res.status(201);
            return ret;
        }, m -> new Gson().toJson(m));

        get(API_CONTEXT + "/accounts/all", (req, res) -> {
            res.type("application/json");
            return accountsResponsibilityService.getAll();
        }, m -> new Gson().toJson(m));
    }
}
