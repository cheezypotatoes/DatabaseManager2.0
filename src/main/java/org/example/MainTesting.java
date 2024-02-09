package org.example;


public class MainTesting {

    public static void main(String[] args) {


        DatabaseManager db = new DatabaseManager("jdbc:sqlite:test.db");
        db.createTablesIfNotExist();

        //db.Insert.InsertNewUser("example@example.com", "example_user", "password123", false, 100.0);

        //db.Insert.InsertNewDescription("The Great Gatsby", "Pretty Much Good");

        //System.out.println(db.Check.checkIfDescriptionExists("The Great Gatsby"));

        //db.Update.UpdateUserCash(1, 1350);

        //db.Insert.InsertGenre("The Great Gatsby", "Comedy");

        //db.Insert.InsertNewBook("The Secret Garden", "The Secret Garden.png", new String[]{"Fiction", "Children", "Classic"}, 456, true, 14.99, 50, "A timeless classic about a magical garden.");
        //db.Insert.InsertNewBook("The Hitchhiker's Guide to the Galaxy", "The Hitchhiker's Guide to the Galaxy.png", new String[]{"Science Fiction", "Comedy", "Adventure"}, 789, true, 24.99, 75, "A hilarious adventure through space.");

        //System.out.println(db.Check.CheckIfUserNameAlreadyExist("example_user"));

        //System.out.println(db.Check.CheckIfEmailAlreadyExist("example@example.com"));

        //System.out.println(db.Return.ReturnLatestId());



    }
}
