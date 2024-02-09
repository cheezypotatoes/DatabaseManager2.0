package org.example;


public class MainTesting {

    public static void main(String[] args) {


        DatabaseManager db = new DatabaseManager("jdbc:sqlite:test.db");
        db.createTablesIfNotExist();

        //db.Insert.InsertNewUser("example@example.com", "example_user", "password123", false, 100.0);

        //db.Insert.InsertNewBook("The Great Gatsby", "great.png", new String[]{"Fiction", "Classic"}, 123, true, 19.99, 1000, "A novel written by F. Scott Fitzgerald.");

        //db.Insert.InsertNewDescription("The Great Gatsby", "Pretty Much Good");

        //System.out.println(db.Check.checkIfDescriptionExists("The Great Gatsby"));

        //db.Update.UpdateUserCash(1, 1350);



    }
}
