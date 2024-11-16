package com.pelogia.cervejaria;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class CervejariaApplication {

	@Autowired
    private DataSource dataSource;
	
	public static void main(String[] args) {
		SpringApplication.run(CervejariaApplication.class, args);
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
