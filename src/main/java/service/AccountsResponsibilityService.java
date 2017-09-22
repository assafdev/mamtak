package service;

import com.mongodb.MongoClient;
import model.AccountRecord;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.mapping.Mapper;
import org.mongodb.morphia.mapping.MapperOptions;
import org.mongodb.morphia.query.Query;

import java.util.List;
import java.util.logging.Logger;

public class AccountsResponsibilityService {
    private static Logger LOGGER =Logger.getLogger("AccountsResponsibilityService");

    private static final int MONGO_DB_PORT = 27017;
    private MongoClient client;
    private Datastore datastore;

    public AccountsResponsibilityService() {
        client = new MongoClient("localhost", MONGO_DB_PORT);

        Morphia morphia = new Morphia();
        morphia.map(AccountRecord.class);

        datastore = morphia.createDatastore(client, "records");
    }

    public String addRecord(AccountRecord record){
        datastore.save(record);
        LOGGER.info("record as been saved: " + record.toString() + "num of records is: " + datastore.getCount(AccountRecord.class));
        return "a record has been created - admin name:" + record.getAdminName() + " money channel:" + record.getMoneyChannel();
    }

    public List<AccountRecord> getAll(){
        List<AccountRecord> accountRecords = datastore.find(AccountRecord.class).asList();
        if (accountRecords != null){
            LOGGER.info("number of records " + accountRecords.size());
        }
        else {
            LOGGER.info("not found records in the db");
        }
        return accountRecords;
    }
}
