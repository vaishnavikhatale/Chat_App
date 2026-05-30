# 💬 Java Chat Application

A real-time chatting application built using Java Socket Programming, Swing GUI, and MySQL Database.

---

# 📌 Overview

This project is a simple Client-Server based Chat Application developed in Java.

Users can:

- Login using username and password
- Connect client to server
- Send and receive messages
- Communicate in real-time
- Store login data in MySQL database

---

# 🛠 Technologies Used

- Java
- Java Swing
- Socket Programming
- JDBC
- MySQL
- VS Code

---

# 📂 Project Structure

```bash
chatapp/
│
├── src/
│   ├── client/
│   │      └── Client.java
│   │
│   ├── server/
│   │      └── Server.java
│   │
│   ├── login/
│   │      └── LoginPage.java
│   │
│   ├── database/
│   │      └── DBConnection.java
│   │
│   └── ui/
│          └── ChatUI.java
│
├── lib/
│      └── mysql-connector-j.jar
│
└── README.md
```

---

# ✨ Features

- 🔐 Login Authentication
- 💬 Real-Time Chatting
- 🌐 Client-Server Communication
- 🗄 MySQL Database Connectivity
- 🎨 Java Swing GUI
- ⚡ Fast Message Transfer
- 👥 Multi-user Support

---

# 🗄 Database Setup

## Step 1: Start XAMPP

Start:

- Apache
- MySQL

---

## Step 2: Open phpMyAdmin

```bash
http://localhost/phpmyadmin
```

---

## Step 3: Create Database

```sql
CREATE DATABASE chatapp;
```

---

## Step 4: Create Table

```sql
USE chatapp;

CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50),
    password VARCHAR(50)
);
```

---

## Step 5: Insert Login Data

```sql
INSERT INTO users(username, password)
VALUES('admin', '1234');
```

---

# 🔌 JDBC Connection

```java
String url = "jdbc:mysql://localhost:3306/chatapp";
String user = "root";
String password = "";

Connection con = DriverManager.getConnection(url, user, password);
```

---

# 🌐 Client-Server Communication

## 🖥 Server

The server waits for clients to connect.

```java
ServerSocket serverSocket = new ServerSocket(5000);
Socket socket = serverSocket.accept();
```

---

## 💻 Client

The client connects to the server using IP and Port.

```java
Socket socket = new Socket("localhost", 5000);
```

---

# 🔄 Chat Working Process

1. Start Server
2. Start Client
3. Login with username and password
4. Client connects to server
5. Users send messages
6. Messages are transferred using sockets
7. Receiver gets message instantly

---

# ▶️ How To Run Project

## 📌 Open Project in VS Code

---

## 📌 Add MySQL Connector JAR

Download MySQL Connector and add it to project library.

Example:

```bash
mysql-connector-j-9.0.0.jar
```

---

# ▶️ Run Server

Open terminal:

```bash
cd src
```

Compile:

```bash
javac server/Server.java
```

Run:

```bash
java server.Server
```

Server Started Successfully ✅

---

# ▶️ Run Client

Open another terminal:

```bash
cd src
```

Compile:

```bash
javac client/Client.java
```

Run:

```bash
java client.Client
```

Client Connected Successfully ✅

---

# 🔐 Login Details

| Username | Password |
|----------|----------|
| admin | 1234 |

---

# 📸 Application Screens

## 🔐 Login Page
- Username field
- Password field
- Login button

## 💬 Chat Window
- Message area
- Send button
- User communication panel

## 🖥 Server Console
- Connected clients
- Server activity logs

---

# 🧠 Concepts Used

- Socket Programming
- JDBC Connectivity
- Multithreading
- Java Swing
- Client-Server Architecture

---

# 🚀 Future Enhancements

- Group Chat
- File Sharing
- Emoji Support
- Voice Calling
- Video Calling
- Message Encryption

---



# ⭐ Conclusion

This project helps in understanding:

- Java Networking
- Real-Time Communication
- Database Connectivity
- GUI Development
- Client-Server Architecture

It is a beginner-friendly Java project for learning Socket Programming and Networking.