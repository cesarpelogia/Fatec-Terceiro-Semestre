package com.cervejaria.cerveja;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CervejaApplication {

    @Autowired
    private DataSource dataSource;

    public static void main(String[] args) {
        SpringApplication.run(CervejaApplication.class, args);
    }

    @PostConstruct
    public void init() {
        createDatabaseIfNotExists();
    }

    private void createDatabaseIfNotExists() {
        try (var connection = dataSource.getConnection()) {
            var statement = connection.createStatement();
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS cervejaria");
            statement.executeUpdate("USE cervejaria");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}