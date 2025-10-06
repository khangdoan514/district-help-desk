package dev.khang.helpdesk.database;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Database {
    
    private static final Logger log = LoggerFactory.getLogger(Database.class);
    
    private final MongoClient mongoClient;
    private final String databaseName = "district-help-desk";
    
    @Autowired
    public Database(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }
    
    @PostConstruct
    public void initialize() {
        try {
            // Send a ping to confirm a successful connection
            MongoDatabase database = mongoClient.getDatabase("admin");
            database.runCommand(new Document("ping", 1));
            System.out.println("Pinged your deployment. You successfully connected to MongoDB!");
            
            // Also test connection to our actual database
            MongoDatabase helpdeskDb = mongoClient.getDatabase(databaseName);
            helpdeskDb.runCommand(new Document("ping", 1));
            log.info("Successfully connected to database: {}", databaseName);
            
        }
        
        catch (Exception e) {
            log.error("Failed to connect to MongoDB", e);
            throw new RuntimeException("MongoDB connection failed", e);
        }
    }
    
    public MongoDatabase getDatabase() {
        return mongoClient.getDatabase(databaseName);
    }
    
    public boolean isConnected() {
        try {
            MongoDatabase database = mongoClient.getDatabase("admin");
            database.runCommand(new Document("ping", 1));
            return true;
        }
        
        catch (Exception e) {
            log.error("Database connection check failed", e);
            return false;
        }
    }
    
    @PreDestroy
    public void close() {
        if (mongoClient != null) {
            log.info("Closing MongoDB connection...");
            mongoClient.close();
            log.info("MongoDB connection closed");
        }
    }
}