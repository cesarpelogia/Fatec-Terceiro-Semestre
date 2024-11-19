package com.pelogia.cervejaria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CervejariaApplication {

	public static void main(String[] args) {
        createDatabaseIfNotExists("cervejaria");
		SpringApplication.run(CervejariaApplication.class, args);
	}

        private static void createDatabaseIfNotExists(String databaseName) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/";
        String username = "root";
        String password = "root";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS " + databaseName);
            System.out.println("Banco de dados '" + databaseName + "' verificado/criado com sucesso!");
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar/verificar o banco de dados: " + e.getMessage(), e);
        }
    }

}
