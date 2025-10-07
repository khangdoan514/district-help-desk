package dev.khang.helpdesk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    
    @Autowired
    private MongoTemplate mongoTemplate;
    
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        // Get real counts from MongoDB
        long userCount = mongoTemplate.getCollection("users").countDocuments();
        long queueCount = mongoTemplate.getCollection("queues").countDocuments();
        long ticketCount = mongoTemplate.getCollection("tickets").countDocuments();
        
        // Add data to model for Thymeleaf
        model.addAttribute("userCount", userCount);
        model.addAttribute("queueCount", queueCount);
        model.addAttribute("ticketCount", ticketCount);
        model.addAttribute("databaseStatus", "CONNECTED");
        
        return "dashboard";
    }
}