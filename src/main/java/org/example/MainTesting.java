package org.example;


@SuppressWarnings("ALL")
public class MainTesting {

    public static void main(String[] args) {


        DatabaseManager db = new DatabaseManager("jdbc:sqlite:test.db");
        db.createTablesIfNotExist();

        //db.Insert.InsertNewUser("example2@example.com", "example_user", "password123", false, 150.0);

        //db.Insert.InsertNewDescription("The Great Gatsby", "Pretty Much Good");

        //System.out.println(db.Check.checkIfDescriptionExists("The Great Gatsby"));

        //db.Update.UpdateUserCash(1, 1350);

        //db.Insert.InsertGenre("The Great Gatsby", "Comedy");

        //db.Insert.InsertNewBook("The Secret Garden", "The Secret Garden.png", new String[]{"Fiction", "Children", "Classic"}, 456, true, 14.99, 0, "A timeless classic about a magical garden.");
        //db.Insert.InsertNewBook("The Hitchhiker's Guide to the Galaxy", "The Hitchhiker's Guide to the Galaxy.png", new String[]{"Science Fiction", "Comedy", "Adventure"}, 789, true, 24.99, 0, "A hilarious adventure through space.");

        //System.out.println(db.Check.CheckIfUserNameAlreadyExist("example_user"));

        //System.out.println(db.Check.CheckIfEmailAlreadyExist("example@example.com"));

        //System.out.println(db.Return.ReturnLatestId());

        //String[] top_3 = db.Return.ReturnTopThreeBookTitle();
        //for (String e : top_3){
            //System.out.println(e);
        //}

        //System.out.println(db.Return.returnBookIdByTitle("The Secret Garden"));
        //System.out.println(db.Return.returnBookIdByTitle("The Hitchhiker's Guide to the Galaxy"));

        //System.out.println(db.Return.returnBookDescriptionByTitle("The Secret Garden"));


        //String[] all_genre = db.Return.returnBookGenreByTitle("The Secret Garden");
        //for (String g : all_genre){
            //System.out.println(g);
        //}


        //String[][] all_users = db.Return.returnAllUsers();

        //for (int i = 0; i < all_users.length; i++) {
            // Access the user data in the current row
            //String[] userData = all_users[i];

            // Iterate over each column (user attribute)
            //for (int j = 0; j < userData.length; j++) {
                // Access the user attribute at index j
                //String attribute = userData[j];

                // Process the user attribute as needed
               // System.out.println("User " + i + ", Attribute " + j + ": " + attribute);
            //}
        //}

        //String[][] allBooks = db.Return.returnAllBooks();

        // Print the book data
        //for (String[] book : allBooks) {
            //for (String attribute : book) {
                //System.out.print(attribute + " ");
            //}
            //System.out.println(); // Move to the next line for the next book
        //}

        //System.out.println(db.Return.userUserIdByUsername("jorge"));

        //System.out.println(db.Login.ReturnUserIdByLogIn("example2@example.com", "password123"));

        //db.Insert.AddBoughtBook(1, 2);

        //db.Update.increaseBookSoldByOne(1);

        //System.out.println(db.Return.returnUserCash(1));

        //System.out.println(db.Return.returnBookPrice(2));

        db.Update.buyBook(1, 2);

    }
}
