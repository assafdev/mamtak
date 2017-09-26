package db;

import com.mongodb.MongoClient;
import models.BaseEntity;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

public class DbHandler {

    private static final String host = "localhost";

    private static final int MONGO_DB_PORT = 27017;

    private static final String dbName = "records";

    private final MongoClient client;
    private final Datastore datastore;

    private final Morphia morphia = new Morphia();


    public DbHandler() {
        client = new MongoClient(host , MONGO_DB_PORT);

        //all models for the mongodb documents needs to be stored in the same package as baseentity - does it make sense?
        morphia.mapPackageFromClass(BaseEntity.class);
        morphia.getMapper().getOptions().setStoreNulls(true);

        datastore = morphia.createDatastore(client, dbName);
    }

    public Datastore getDatastore(){
        return datastore;
    }
}
