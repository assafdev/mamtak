import com.google.gson.reflect.TypeToken;
import db.DbHandler;
import models.AccountRecord;
import com.google.gson.*;
import services.AccountsResponsibilityService;

import java.lang.reflect.Type;
import java.util.List;
import java.util.logging.Logger;

import static spark.Spark.*;

public class Main {

    private static DbHandler dbHandler = new DbHandler();
    private static AccountsResponsibilityService accountsResponsibilityService = new AccountsResponsibilityService(dbHandler);
    private static final String API_CONTEXT = "/api";
    private static Logger LOGGER = Logger.getLogger("MAIN");

    public static void main(String[] args) {

        System.out.println("The sever is running on: " + "http://localhost:4567/hello");

        staticFileLocation("/public");

        setupEndpoints();

    }

    private static void setupEndpoints() {

        path(API_CONTEXT, () -> {
            before("/*", (q, a) -> LOGGER.info("Received api call"));
            path("/accounts", () -> {
                post("/add", "application/json", (req, res) -> {
                    res.type("application/json");
                    AccountRecord accountRecord = new GsonBuilder().serializeNulls().create().fromJson(req.body(), AccountRecord.class);
                    return accountsResponsibilityService.addAccount(accountRecord);
                }, m -> new Gson().toJson(m));

                post("/delete", "application/json", (req, res) -> {
                    res.type("application/json");
                    AccountRecord accountRecord = new GsonBuilder().serializeNulls().create().fromJson(req.body(), AccountRecord.class);
                    return accountsResponsibilityService.deleteAccount(accountRecord);
                }, m -> new Gson().toJson(m));

                get("/all", (req, res) -> {

                    res.type("application/json");
                    return accountsResponsibilityService.getAllAccounts();

                }, m -> new Gson().toJson(m));

                post("/sync", "application/json", (req, res) -> {

                    res.type("application/json");
                    Type listType = new TypeToken<List<AccountRecord>>() {
                    }.getType();
                    List<AccountRecord> accounts = new GsonBuilder().serializeNulls().create().fromJson(req.body(), listType);

                    return accountsResponsibilityService.syncAccounts(accounts);
                }, m -> new Gson().toJson(m));
            });
        });
    }
}
