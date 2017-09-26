package services;

import db.DbHandler;
import models.AccountRecord;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class AccountsResponsibilityService {
    private static Logger LOGGER =Logger.getLogger("AccountsResponsibilityService");
    private Datastore datastore;


    public AccountsResponsibilityService(DbHandler dbHandler) {
        datastore = dbHandler.getDatastore();
    }

    public String addAccount(AccountRecord record){
        datastore.save(record);
        LOGGER.info("record as been saved: " + record.toString() + "num of records is: " + datastore.getCount(AccountRecord.class));
        return "a record has been created - admin name:" + record.getAdminName() + " money channel:" + record.getMoneyChannel();
    }

    public List<AccountRecord> getAllAccounts(){
        List<AccountRecord> accountRecords =datastore.find(AccountRecord.class).asList();
        if (accountRecords != null){
            LOGGER.info("number of records " + accountRecords.size());
        }
        else {
            LOGGER.info("not found records in the db");
        }
        return accountRecords;
    }

    public String syncAccounts(List<AccountRecord> newAccounts){
        LOGGER.info("new accounts count:" + newAccounts.size());

        final Query<AccountRecord> emptyQuery = datastore.createQuery(AccountRecord.class);
        datastore.delete(emptyQuery);
        datastore.save(newAccounts);
        return "synchronized all accounts";
    }

}
