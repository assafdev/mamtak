package services;

import db.DbHandler;
import models.AccountRecord;

import java.util.List;
import java.util.logging.Logger;

public class AccountsResponsibilityService {
    private static Logger LOGGER =Logger.getLogger("AccountsResponsibilityService");
    private DbHandler handler;


    public AccountsResponsibilityService(DbHandler dbHandler) {
        handler = dbHandler;
    }

    public String addRecord(AccountRecord record){
        handler.getDatastore().save(record);
        LOGGER.info("record as been saved: " + record.toString() + "num of records is: " + handler.getDatastore().getCount(AccountRecord.class));
        return "a record has been created - admin name:" + record.getAdminName() + " money channel:" + record.getMoneyChannel();
    }

    public List<AccountRecord> getAll(){
        List<AccountRecord> accountRecords = handler.getDatastore().find(AccountRecord.class).asList();
        if (accountRecords != null){
            LOGGER.info("number of records " + accountRecords.size());
        }
        else {
            LOGGER.info("not found records in the db");
        }
        return accountRecords;
    }
}
