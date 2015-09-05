package enums;

// Declare an enum type with constructor and explicit instance fields 
// and accessors for these fields

public enum Book {
	// declare constants of enum type
	JHTP("Java How to Program", "2011"), CHTP("C How to Program", "2007"), IW3HTP(
			"Internet & World Wide Web How to Program", "2008"), CPPHTP(
			"C++ How to Program", "2008"), VBHTP(
			"Visual Basic 2008 How to Program", "2009"), CSHARPHTP(
			"Visual C# 2008 How to Program", "2009");

	// instance fields
	private final String title; // book title
	private final String copyrightYear; //  year

	// enum constructor
	Book(String bookTitle, String year) {
		title = bookTitle;
		copyrightYear = year;
	} 

	// accessor for field title
	public String getTitle() {
		return title;
	}

	// accessor for field copyrightYear
	public String getCopyrightYear() {
		return copyrightYear;
	} 
	
} 

