
// That class BookCollection is a collection of Book

public class BookCollection {

	public static final int MAX_NUM_ITEMS = 3;
	private Book[] books = new Book[MAX_NUM_ITEMS]; // initialize books array
	private int bookCounter = 0; // count the number of books entered so far

	// getter
	public int size() {
		return bookCounter;
	}

	// declare methods

	// add the Book entered by the user to the array
	public void addBook(Book currentBook){
		books[bookCounter] = currentBook;
		// increment the counter
		bookCounter++;
	}

	public Book getBook(int bookIndex) {
		return books[bookIndex]; // in order to get one Book at a time
	}

	// look for a specific book title entered by the user
	public Book findBook( String title ) {
		if (title==null){ //  if we get an invalid title from the user, like * for example, input.next() would return null
			return null;
		} 
		for (int i=0; i<bookCounter; i++) {
			Book book = books[i];
			if ( title.equalsIgnoreCase(book.getTitle()) ) { // look for the book title independently of the letter case 
				return book; // book is found, we return the answer
			}
		}
		return null; // the book was not found
	}

}
