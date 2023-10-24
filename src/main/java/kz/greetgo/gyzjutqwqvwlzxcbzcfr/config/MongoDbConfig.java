package kz.greetgo.gyzjutqwqvwlzxcbzcfr.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
public class MongoDbConfig extends AbstractMongoClientConfiguration {
    @Value("${mongodb.config.db_name}")
    private String dbName;

    @Value("${mongodb.config.db_url}")
    private String dbUrl;

    @Override
    protected String getDatabaseName() {
        return dbName;
    }

    @Override
    public MongoClient mongoClient() {
        return MongoClients.create(dbUrl);
    }
}
