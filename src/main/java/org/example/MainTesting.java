package org.example;


public class MainTesting {

    public static void main(String[] args) {


        DatabaseManager db = new DatabaseManager("jdbc:sqlite:test.db");
        db.createTablesIfNotExist();


        db.Insert.InsertNewUser("example@example.com", "example_user", "password123", false, 100.0);


    }
}
