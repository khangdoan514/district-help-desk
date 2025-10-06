package dev.khang.helpdesk.service;

import jakarta.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;


@Service
public class DataLoader {

    @Autowired
    private MongoTemplate mongoTemplate;

    @PostConstruct
    public void loadData() {
        try {
            // Clear existing collections
            mongoTemplate.dropCollection("users");
            mongoTemplate.dropCollection("tickets");
            mongoTemplate.dropCollection("queues");

            // Insert sample data from CSV files
            loadUsers();
            loadQueues();
            loadTickets();

            System.out.println("Sample data loaded successfully!");
            
        } catch (Exception e) {
            System.err.println("Error loading data: " + e.getMessage());
        }
    }

    private void loadUsers() throws Exception {
        List<org.bson.Document> users = readCSV("data/users.csv", (headers, values) -> {
            return new org.bson.Document()
                .append("user_id", values[0])
                .append("user_name", values[1])
                .append("user_email", values[2])
                .append("user_password", values[3])
                .append("is_admin", Boolean.parseBoolean(values[4]))
                .append("user_queue", values[5]);
        });
        
        mongoTemplate.insert(users, "users");
        System.out.println("Loaded " + users.size() + " users");
    }

    private void loadQueues() throws Exception {
        List<org.bson.Document> queues = readCSV("data/queues.csv", (headers, values) -> {
            return new org.bson.Document()
                .append("queue_id", values[0])
                .append("queue_name", values[1])
                .append("description", values[2]);
        });
        
        mongoTemplate.insert(queues, "queues");
        System.out.println("Loaded " + queues.size() + " queues");
    }

    private void loadTickets() throws Exception {
        List<org.bson.Document> tickets = readCSV("data/tickets.csv", (headers, values) -> {
            org.bson.Document ticket = new org.bson.Document()
                .append("ticket_id", values[0])
                .append("user_id", values[1])
                .append("user_name", values[2])
                .append("user_email", values[3])
                .append("ticket_room", values[4])
                .append("ticket_campus", values[5])
                .append("ticket_queue", values[6])
                .append("ticket_priority", values[7])
                .append("ticket_description", values[8])
                .append("ticket_open_date", values[9]);
            
            if (values.length > 10 && !values[10].isEmpty()) {
                ticket.append("ticket_closed_date", values[10]);
            }
            
            return ticket;
        });
        
        mongoTemplate.insert(tickets, "tickets");
        System.out.println("Loaded " + tickets.size() + " tickets");
    }

    private List<org.bson.Document> readCSV(String filename, CSVMapper mapper) throws Exception {
        List<org.bson.Document> documents = new ArrayList<>();
        
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            
            String line;
            String[] headers = null;
            boolean firstLine = true;
            
            while ((line = reader.readLine()) != null) {
                if (firstLine) {
                    headers = line.split(",");
                    firstLine = false;
                } else {
                    String[] values = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
                    documents.add(mapper.map(headers, values));
                }
            }
        }
        
        return documents;
    }

    @FunctionalInterface
    private interface CSVMapper {
        org.bson.Document map(String[] headers, String[] values);
    }
    
}