
public class Book {
	
	private long ISBN;
	private String title;
	private String author;
	private double price;
	public static int nbBooks;
	
	Book(String t, String a, double p, long i){
		nbBooks+=1;
		title=t;
		author=a;
		ISBN=i;
		price=p;
	}
	
	public void SetPrice(double p){
		price = p;
	}
	
	public void SetTitle(String t) {
		title=t;
	}
	
	public void SetAuthor(String a) {
		author=a;
	}
	
	public void SetISBN(long i) {
		ISBN=i;
	}
	
	public double GetPrice() {
		return price;
	}
	
	public long GetISBN() {
		return ISBN;
	}
	
	public String GetAuthor() {
		return author;
	}
	
	public String GetTitle() {
		return title;
	}
	
	public int findNumberOfCreatedBooks() {
		return nbBooks;
	}

	public boolean equals(Book another) {
		if (ISBN == another.GetISBN() && price == another.GetPrice())
			return true;
		return false;
	}
	
	public String toString() {
		return "Title: "+title+"\n"+
				"Author: "+author+"\n"+
				"Price: "+price+"$\n"+
				"ISBN: "+ISBN+"\n";
	}
}
