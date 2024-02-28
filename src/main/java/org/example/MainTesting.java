package org.example;


import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
public class MainTesting {

    public static void main(String[] args) {


        DatabaseManager db = new DatabaseManager("jdbc:sqlite:test.db");
        db.createTablesIfNotExist();

        //db.Insert.InsertNewUser("example32@example.com", "example_user", "password123", false, 150.0);

        //db.Insert.InsertNewDescription("The Great Gatsby", "Pretty Much Good");

        //System.out.println(db.Check.checkIfDescriptionExists("The Great Gatsby"));

        //db.Update.UpdateUserCash(1, 1350);

        //db.Insert.InsertGenre("The Great Gatsby", "Comedy");

        //db.Insert.InsertNewBook("The Secret Garden", "The Secret Garden.png", new String[]{"Fiction", "Children", "Classic"}, 456, true, 14.99, 0, "A timeless classic about a magical garden.");
        //db.Insert.InsertNewBook("The Hitchhiker's Guide to the Galaxy", "The Hitchhiker's Guide to the Galaxy.png", new String[]{"Science Fiction", "Comedy", "Adventure"}, 789, true, 24.99, 0, "A hilarious adventure through space.");
        //db.Insert.InsertNewBook("The Classic Book Title", "classic_book_cover.png", new String[]{"Classic"}, 123, true, 19.99, 0, "Description of the classic book.");
        //db.Insert.InsertNewBook("The Quantum Quirk Chronicles: Galactic Guffaws", "quantum_quirk_cover.png", new String[]{"Science Fiction", "Comedy", "Adventure"}, 1, true, 24.99, 10, "Join Captain Zara and her eccentric crew aboard the starship 'Quasar Quest' as they navigate the zany and unpredictable galaxy filled with quantum anomalies and cosmic calamities. In this uproarious adventure, they encounter sentient space llamas, time-traveling parrots, and a mischievous AI with a penchant for practical jokes. Get ready for a rollercoaster ride of laughter and excitement in this side-splitting space romp!");


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

        //db.Update.buyBook(1, 1);
        //db.Update.buyBook(5, 2);
        //db.Update.buyBook(5, 3);
        //db.Update.buyBook(5, 4);


        //String[] genreSelected = {"Comedy", "Horror"};


        //String[] book_title_selected = db.Return.returnBookTitleByGenre(genreSelected);
       // for (String title : book_title_selected) {
            //System.out.println(title);
        //}

        //String[][] searchedBooks = db.Return.returnSearchedBook(genreSelected);

        //String[] specific_return_book = db.Return.returnSpecificBookDetailsByTitle("The Hitchhiker's Guide to the Galaxy");
        //for (String title : specific_return_book) {
            //System.out.println(title);
       //}

        //String[] genreSelected = {"Science Fiction", "Comedy", "Adventure"};
        //String[][] matchedBook = db.Return.returnBookDetailsByGenre(genreSelected);

        //for (int i = 0; i < matchedBook.length; i++) {
            //for (int j = 0; j < matchedBook[i].length; j++) {
                //System.out.print(matchedBook[i][j] + " ");
           //}
           // System.out.println();
       // }

        //System.out.println(db.Check.CheckIfBookWasBought(22,1));

        //db.Insert.InsertBookReview(1, 1, 4, "An excellent read! I couldn't put it down.");
        //db.Insert.InsertBookReview(1, 2, 4, "Absolutely captivating! A must-read for everyone.");
        //db.Insert.InsertBookReview(1, 3, 4, "This book exceeded my expectations. A true gem.");
        //db.Insert.InsertBookReview(1, 4, 4, "Highly engaging plot and well-developed characters. Loved it!");


        //String[][] allReviews = db.Return.returnAllBooksReviewByUserId(1);


        //for (int i = 0; i < allReviews.length; i++) {
           // System.out.println("Book Id: " + allReviews[i][0]);
            //System.out.println("Book Rating: " + allReviews[i][1]);
            //System.out.println("Is Owned: : " + allReviews[i][2]);
            //System.out.println("Book Review: " + allReviews[i][3]);
            //System.out.println();
       // }



        //System.out.println(db.Return.returnAuthorNameByID(1));

        //[] bookData = db.Return.returnBookDataById(1);

        //if (bookData != null) {
            // Print the book data
            //System.out.println("Book ID: " + bookData[0]);
            //System.out.println("Title: " + bookData[1]);
            //System.out.println("Image Link: " + bookData[2]);
            //System.out.println("Author ID: " + bookData[3]);
            //System.out.println("Is Available: " + bookData[4]);
            //System.out.println("Price: " + bookData[5]);
            //System.out.println("Copies Sold: " + bookData[6]);
            //System.out.println("Description: " + bookData[7]);
            //System.out.println("Genres: " + bookData[8]);
       // }

        //System.out.println(db.Return.ReturnLatestId());


        //db.Insert.AdminBookInserter("To Kill a Mockingbird", "To Kill a Mockingbird.jpeg", new String[]{"Fiction", "Classic"}, "Harper Lee", true, 12.50, 150, "A powerful story about racial injustice in the American South.");
        //db.Insert.AdminBookInserter("1984", "1984_cover.jpg", new String[]{"Fiction", "Dystopian"}, "George Orwell", false, 10.99, 200, "A dystopian novel set in a totalitarian regime, exploring themes of surveillance, censorship, and government oppression.");
        //db.Insert.AdminBookInserter("Animal Farm", "Animal_Farm_cover.jpg", new String[]{"Fiction", "Political Satire"}, "George Orwell", false, 9.99, 180, "An allegorical novella depicting a group of farm animals who rebel against their human farmer, reflecting events leading up to the Russian Revolution and the Stalinist era of the Soviet Union.");
        //db.Insert.AdminBookInserter("The Great Gatsby", "The_Great_Gatsby_cover.jpg", new String[]{"Fiction", "Classic"}, "F. Scott Fitzgerald", true, 11.99, 150, "A novel set in the Jazz Age, depicting the lavish and decadent lifestyle of Long Island's elite, exploring themes of wealth, love, and the American Dream.");
        //db.Insert.insertAuthor(3,"hello2");

        //System.out.println(db.Return.returnAuthorId(3));


        //int[] notOwnedBooks = db.Return.returnAllNotBoughtBooks(5);


        //for (int e : notOwnedBooks){
            //System.out.println(String.valueOf(e));
        //}

        //List<String> gen= new ArrayList<>();
        //gen.add("Classic");
        //gen.add("Fiction");
        // user 5 bought num 2

        //List<Integer> result =db.Return.returnSearch("Book Name", gen, "", true, 5);

        //for (int g : result){
            //System.out.println(g);
        //}
        
        
        //int[] topten = db.Return.returnTenLatestBooks();

        //for (int e : topten){
            //System.out.println(e);
        //}


        //List<Integer> result = db.Return.returnOwnedBooks(5);

        //for (int e : result){
            //System.out.println(e);
        //}


        //List<Integer> result = db.Return.returnBookPublished(2);
        //for (int e : result){
            //System.out.println(e);
        //}

        //List<String> result = db.Return.returnAllGenreById(5);

        //for (String g : result){
           // System.out.println(g);
        //}

        db.Insert.InsertBookReview(1, 1, 4, "Great book, highly recommended!");
        //db.Insert.InsertBookReview(2, 1, 5, "Excellent read, couldn't put it down!");
        //db.Insert.InsertBookReview(3, 2, 3, "Interesting plot, but pacing was a bit slow.");
        //db.Insert.InsertBookReview(4, 3, 5, "Amazing story, loved every bit of it!");
        //db.Insert.InsertBookReview(5, 4, 4, "Well-written and engaging.");


        List<String[]> bookReviews = db.Return.returnAllBookReviewsById(1);
        for (String[] review : bookReviews) {
            System.out.println("User ID: " + review[0] + ", Review: " + review[1] + ", Rating: " + review[2] + ", Is Owned:" + review[3]);
        }








    }
}
