package com.edutech.progressive.config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;
public class DatabaseConnectionManager {
   private static Properties properties = new Properties();
   // Load properties from application.properties
   private static void loadProperties() {
       try {
           InputStream input = DatabaseConnectionManager.class
                   .getClassLoader()
                   .getResourceAsStream("application.properties");
           if (input == null) {
               throw new RuntimeException("application.properties file not found");
           }
           properties.load(input);
       } catch (Exception e) {
           throw new RuntimeException("Error loading properties file", e);
       }
   }
   // Get DB connection
   public static Connection getConnection() {
       try {
           if (properties.isEmpty()) {
               loadProperties();
           }
           String url = properties.getProperty("db.url");
           String username = properties.getProperty("db.username");
           String password = properties.getProperty("db.password");
           return DriverManager.getConnection(url, username, password);
       } catch (SQLException e) {
           throw new RuntimeException("Error connecting to database", e);
       }
   }
}