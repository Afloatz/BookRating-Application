
import java.util.Scanner;

public class BookCollectionApp{

	public static void main(String[] args){
		// declare a variable to store the user's choice i.e. functionality to be performed
		// 1 - add an item
		// 2 - display all the items, etc.
		int functionality = 0;

		// prompt the user information about the application
		System.out.println("That application allows you to provide information for books.");

		System.out.println("You can provide information for a maximum of "+ BookCollection.MAX_NUM_ITEMS + " books");
		System.out.println("You can provide a maximum of "+ Book.MAX_NUM_RATINGS + " ratings per book");

		// create an object of type BookCollection that contain the array of Book
		BookCollection books = new BookCollection();

		// declare a variable of type Scanner, AND create an object of type Scanner
		Scanner input = new Scanner(System.in);

		while ( functionality != 7 ) {

			System.out.println("----------------------------------------------");
			System.out.println("Application Menu ... For Item Type: Book");
			System.out.println("1 - Add an item");
			System.out.println("2 - Display all the items");
			System.out.println("3 - Add a rating for a given item");
			System.out.println("4 - Display all the ratings for a given item");
			System.out.println("5 - Calculate and display the average rating for each item");
			System.out.println("6 - Display the best item based on the average rating (the item with the highest rating)");
			System.out.println("7 - Exit the application");
			System.out.println("----------------------------------------------");
			System.out.println("Enter your choice: ");
			// read the functionality the user wants to perform
			functionality = input.nextInt(); // reads and returns one int value
			// declare a variable of type Book
			Book book; // we will need this several times, so we declare it once here

			switch (functionality){				
				case 1: // Add a book
					if ( books.size() < BookCollection.MAX_NUM_ITEMS){
						System.out.print("enter the book title: ");
						String bookTitle = input.next();
						input = new Scanner(System.in);
						System.out.print("enter the author's name: ");
						String bookAuthor = input.nextLine();
						// create an object of type Book
						// add the book to the book array in BookCollection and increment the counter in order to be able to check if the user can still enter a new item
						books.addBook( new Book(bookTitle, bookAuthor) );
					} else {
						System.out.println("You already entered the maximum number of books permitted !");
					}
					break;
				case 2: // Display all the books
					System.out.println("List of books:");
					for (int j = 0; j <books.size(); j++){ // we use books.size() and not the array length method because some elements of the array can be null depending on the number of book entered so far
						// retrieve the book  
						book = books.getBook(j);
						System.out.println( book.getTitle()+" by "+book.getAuthor() );
					}
					if (books.size() == 0){
						System.out.println("no books entered yet");
					}
					break;
				case 3: // Add a rating for a book
					if ( books.size() < 1 ){
						System.out.println("You must first enter a book");
						break;
					}
					// prompt the user to enter the book title
					System.out.print("enter the book title: ");
					// search for the book title that the user just entered in the list of books saved
					book = books.findBook( input.next() );
					// the method findBook returns null if the book title was not found
					if (book==null) {
						System.out.println("This book does not exist in our database");
						break;
					}
					// check if the user can still enter more ratings for that specific book
					if ( book.getRatingCounter() < Book.MAX_NUM_RATINGS ) {
						//input with data validation, rating must be between 1 and 5
						int myRating = 0; // control variable initialisation
						do {
							System.out.println("enter your rating for this book (an integer number between 1 and 5 inclusive, 5 being the best score):");
							myRating = input.nextInt();
						} while(myRating < 1 || myRating > 5);
						// add the rating to the rating array in Book and increment the counter in order to be able to check if the user can still enter a new rating
						book.addRating( myRating );
					} else {
						System.out.println("You already entered the maximum number of ratings permitted for this book !");
					}
					break;
				case 4: // Display all the ratings for a given book
					if ( books.size() < 1 ){
						System.out.println("You must first enter a book");
						break;
					}
					System.out.print("enter the book title: ");
					book = books.findBook( input.next() );
					if (book==null) {
						System.out.println("This book does not exist in our database");
						break;
					}
					for (int i=0; i<book.getRatingCounter(); i++) {
						System.out.println( book.retrieveRating(i) );
					}
					if (book.getRatingCounter() < 1) {
						System.out.println("this book has no ratings");
					}
					break;
				case 5: // Calculate and display the average rating for each book
					System.out.println("Average ratings of books:");
					if ( books.size() == 0 ){
						System.out.println("no books entered yet");
					}
					for (int j = 0; j <books.size(); j++){
						book = books.getBook(j);
						System.out.println( book.getTitle()+" by "+book.getAuthor()+" - average rating: "+book.calculateAverageRating() );
					}
					break;
				case 6: // Display the best book
					if ( books.size() == 0 ) {
						System.out.println("no books entered yet");
						break;
					}

					Book highest = books.getBook(0);
					if ( books.size() == 1 && highest.getRatingCounter() == 0 ) {
						System.out.println("no rating entered yet");
						break;
					}
					for (int j = 0; j <books.size(); j++){
						book = books.getBook(j);
						if ( book.calculateAverageRating() > highest.calculateAverageRating() ) {
							// we found another book with higher rating
							highest = book;
						}
					}
					System.out.println( "highest rated book: "+highest.getTitle() +" by "+highest.getAuthor() );
					break;
				case 7:
						// do nothing; the while loop will terminate
						break;
				default:
					System.out.println("Functionality is not valid !");
			} // ends the switch

		}

			input.close();

	} // ends the main method

} // ends the body of the class
