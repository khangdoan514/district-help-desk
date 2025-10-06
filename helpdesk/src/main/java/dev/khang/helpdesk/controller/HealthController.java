package dev.khang.helpdesk.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HealthController {
    
    @Autowired
    private MongoTemplate mongoTemplate;
    
    @GetMapping("/health")
    public Map<String, Object> healthCheck() {
        Map<String, Object> status = new HashMap<>();
        
        try {
            mongoTemplate.getDb().runCommand(new org.bson.Document("ping", 1));
            status.put("status", "UP");
            status.put("database", "CONNECTED");
            status.put("message", "Successfully connected to MongoDB Atlas!");
        }
        
        catch (Exception e) {
            status.put("status", "DOWN");
            status.put("database", "DISCONNECTED");
            status.put("error", e.getMessage());
        }
        
        status.put("timestamp", java.time.LocalDateTime.now().toString());
        return status;
    }
    
}