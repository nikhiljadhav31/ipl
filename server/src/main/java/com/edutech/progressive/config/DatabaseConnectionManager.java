package com.edutech.progressive.config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.io.InputStream;
public class DatabaseConnectionManager {
   private static Properties properties = new Properties();
   static {
       try {
           InputStream input = DatabaseConnectionManager.class
                   .getClassLoader()
                   .getResourceAsStream("application.properties");
           properties.load(input);
       } catch (Exception e) {
           throw new RuntimeException("Failed to load DB properties", e);
       }
   }
   
   public static Connection getConnection() {
       try {
           String url = properties.getProperty("spring.datasource.url");
           String username = properties.getProperty("spring.datasource.username");
           String password = properties.getProperty("spring.datasource.password");
           return DriverManager.getConnection(url, username, password);
       } catch (Exception e) {
           throw new RuntimeException("Error connecting to database", e);
       }
   }
}