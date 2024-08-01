package com.formation_center.formation.center.dao;


import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;

@Getter
public class DbConnection {
    private String url;
    private String password;
    private String user;
    private String dbName;

    public DbConnection() {
        this.url = System.getenv("url");
        this.password = System.getenv("password");
        this.user = System.getenv("user");
        this.dbName = "center_formation";

    }

    public Connection ConnDb() {
        Connection connection = null;
        try {

            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url + dbName, user, password);
            if (connection != null) {
                System.out.println("Conection done");
            } else {
                System.out.println("error path");
            }
        } catch (Exception error) {
            throw new RuntimeException(error);
        }
        return connection;
    }

}
