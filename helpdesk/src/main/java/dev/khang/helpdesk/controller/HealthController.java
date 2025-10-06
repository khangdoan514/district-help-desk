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
        } catch (Exception e) {
            status.put("status", "DOWN");
            status.put("database", "DISCONNECTED");
            status.put("error", e.getMessage());
        }
        
        status.put("timestamp", java.time.LocalDateTime.now().toString());
        return status;
    }
    
    @GetMapping("/")
    public String home() {
        return """
            <!DOCTYPE html>
            <html>
            <head>
                <title>District Help Desk</title>
                <style>
                    body { 
                        font-family: Arial, sans-serif; 
                        margin: 40px; 
                        background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
                        color: white;
                    }
                    .container {
                        max-width: 800px;
                        margin: 0 auto;
                        background: rgba(255,255,255,0.1);
                        padding: 30px;
                        border-radius: 10px;
                        backdrop-filter: blur(10px);
                    }
                    h1 { 
                        text-align: center; 
                        margin-bottom: 30px;
                        font-size: 2.5em;
                    }
                    .status {
                        background: rgba(255,255,255,0.2);
                        padding: 20px;
                        border-radius: 8px;
                        margin: 20px 0;
                    }
                    .links a {
                        display: block;
                        background: white;
                        color: #667eea;
                        padding: 15px;
                        margin: 10px 0;
                        text-decoration: none;
                        border-radius: 5px;
                        text-align: center;
                        font-weight: bold;
                        transition: transform 0.2s;
                    }
                    .links a:hover {
                        transform: translateY(-2px);
                        box-shadow: 0 5px 15px rgba(0,0,0,0.2);
                    }
                </style>
            </head>
            <body>
                <div class="container">
                    <h1>🏫 District Help Desk System</h1>
                    
                    <div class="status">
                        <h2>System Status</h2>
                        <p><strong>Database:</strong>CONNECTED</p>
                        <p><strong>Server:</strong>RUNNING</p>
                        <p><strong>Ready for development!</strong></p>
                    </div>
                    
                    <div class="links">
                        <a href="/health">🔍 Health Check (JSON API)</a>
                        <p style="text-align: center; margin-top: 30px; opacity: 0.8;">
                            Built with Spring Boot & MongoDB Atlas
                        </p>
                    </div>
                </div>
            </body>
            </html>
            """;
    }
}