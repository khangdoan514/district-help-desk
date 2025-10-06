# **Database Schema**

## **1. users**

```json
{
    "user_id": "User's ID, Primary Key, String",
    "user_name": "User's full name, String", 
    "user_email": "User's email address, String",
    "user_password": "User's hashed password, String",
    "is_admin": "Administrative privileges flag, Boolean",
    "user_queue": "Assigned support queue, String"
}
```

## **2. tickets**

```json
{
    "ticket_id": "Ticket ID, Primary Key, String",
    "user_id": "Links to users collection, users.user_id, String",
    "user_name": "Submitter's name, String",
    "user_email": "Submitter's email, String",
    "ticket_room": "Location/room number, String",
    "ticket_campus": "School campus/location, String", 
    "ticket_queue": "Assigned support queue, String",
    "ticket_priority": "Issue priority level, String",
    "ticket_description": "Detailed issue description, String",
    "ticket_open_date": "Ticket creation timestamp, String",
    "ticket_closed_date": "Resolution timestamp, String"
}
```

## **3. queues**

```json
{
    "queue_id": "Queue ID, Primary Key, String", 
    "queue_name": "Descriptive queue name, String"
}
```