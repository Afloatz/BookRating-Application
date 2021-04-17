
// The class Book is a collection of ratings plus author and title

public class Book {

	// declare instance variables
	private String title;
	private String author;
	public static final int MAX_NUM_RATINGS = 3;
	private int[] ratings = new int[MAX_NUM_RATINGS]; // // initialize ratings array
	private int ratingCounter = 0; // count the number of ratings entered so far


	// constructor with 2 parameters
	public Book(String title, String author){
		this.title = title;
		this.author = author;
	}

	// setters
	public void setTitle(String title){
		this.title = title;
	}

	public void setAuthor(String author){
		this.author = author;
	}

	// methods

	public void addRating( int rating ) {
		ratings[ratingCounter] = rating; // add the rating entered by the user to the ratings array, one at a time
		// increment the counter
		ratingCounter++;
	}

	public int retrieveRating( int ratingIndex ) {
		return ratings[ratingIndex]; // in order to retrieve one rating at a time
	}

	public double calculateAverageRating(){
		int sum = 0;
		for (int i = 0; i < ratingCounter; i++){
			// calculate running sum
			sum = sum + ratings[i];
		}
		return (double)sum/ratingCounter;
	}

	// getters
	public int getRatingCounter() {
		return ratingCounter;
	}

	public String getTitle(){
		return title;
	}

	public String getAuthor(){
		return author;
	}

}

