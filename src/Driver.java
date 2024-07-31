//----------------------------------------------------------------
// Assignment 0
// Written by: Samuel Vachon, 40281580
//----------------------------------------------------------------

/*
 * My program as for goal to a library management system. In this program, the user, 
 * here a librarian, will be asked to chose the size of his library and than he can add books,
 * change their info, search within the library by criteria. 
 */


import java.util.Scanner;

public class Driver {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Welcome to the Library Management System. By Samuel Vachon. ");
		
		System.out.print("Please enter the maximum amount of books your library can store: ");
		
		Book[] library = new Book[in.nextInt()];
		
		System.out.println();
		
		int choice=0;
		int pass;
		int index=0;
		int fail=0;
		int bigFail=0;
		
		while (choice !=5 && bigFail!=4){
			
			//This is the main menu, with the choices.
			//A switch than redirect the user to the appropriate algorithm
			
			System.out.print("What would you like to do?\n\t"+
					"1. Enter new books (password required)\n\t"+
					"2. Change information of a book (password required)\n\t"+
					"3. Display all books by a specific author\n\t"+
					"4. Display all books under a certain a price.\n\t"+
					"5. Quit\n"+
					"Please enter your choice > ");
			
			choice = in.nextInt();
			
			switch(choice){
				case 1:
					
					//Password algorithm, with a fail system 
					//that blocks the program to prevent bruteforce

					
					System.out.print("Enter your password: ");
					pass = in.nextInt();
					fail=0;
					while (pass!=249) {
						System.out.println("Wrong password.");
						fail+=1;
						if (fail==3) 
							break;
						System.out.print("Enter your password: ");
						pass = in.nextInt();
					}
					if (fail==3) {
						bigFail++;
						break;
					}
					
					//Here, I prompt the user for the number of books while making sure
					//the library still has place.
					
					int stop;
					do {
						System.out.print("How many books to you want to add? ");
						stop = in.nextInt();
						if (Book.nbBooks+stop > library.length)
							System.out.println("The maximum amount of books you can add is "+(library.length-Book.nbBooks));
					}
					while(Book.nbBooks+stop > library.length);
					
					//Loop to manually enter the book's info
					
					for (int i=0;i!=stop;i++) {
						System.out.println("Enter the books info in this order: Title, Author, Price, ISBN");
						in.nextLine();
						String title = in.nextLine();
						String author = in.nextLine();
						double price = in.nextDouble();
						long isbn = in.nextLong();
						library[index] = new Book(title, author, price, isbn);
						System.out.println("The book has been added.");
						index+=1;
					}
					break;
					
				case 2:
					
					//Password algorithm, with a fail system 
					//that blocks the program to prevent bruteforce
					
					System.out.print("Enter your password: ");
					pass = in.nextInt();
					fail=0;
					while (pass!=249) {
						System.out.println("Wrong password.");
						fail+=1;
						if (fail==3) 
							break;
						System.out.print("Enter your password: ");
						pass = in.nextInt();
					}
					if (fail==3) {
						bigFail++;
						break;
					}
					
					//Here I prompt the user for which book he want to change info for
					//While making sure the array points at an existing book.
					
					int bookNb;
					char ans='Y';
					do {
						System.out.print("What is the book number? ");
						bookNb=in.nextInt();
						if (library[bookNb]==null){
							System.out.println("This book number is unassigned.");
							System.out.println("Do you want to enter another number? (Y/N)");
							ans = in.next().charAt(0);						}
					}
					while (library[bookNb]==null && ans !='N');
					if (ans=='N')
						break;
					
					//Here is a secondary menu to select the info to change.
					
					System.out.println("Information about book #"+bookNb+":\n"+library[bookNb]);
					int choice2=0;
					while (choice2!=5) {
						System.out.print("What information would you like to change?\r\n"
								+ "\t1. author\r\n"
								+ "\t2. title\r\n"
								+ "\t3. ISBN\r\n"
								+ "\t4. price\r\n"
								+ "\t5. Quit\r\n"
								+ "Enter your choice > ");
						choice2=in.nextInt();
						switch(choice2) {
							case 1:
								System.out.print("Please enter the author name: ");
								library[bookNb].SetAuthor(in.nextLine());
								System.out.println("Information about book #"+bookNb+":\n"+library[bookNb]);
								break;
							case 2:
								System.out.print("Please enter the title: ");
								library[bookNb].SetTitle(in.nextLine());
								System.out.println("Information about book #"+bookNb+":\n"+library[bookNb]);
								break;
							case 3:
								System.out.print("Please enter the ISBN: ");
								library[bookNb].SetISBN(in.nextLong());
								System.out.println("Information about book #"+bookNb+":\n"+library[bookNb]);
								break;
							case 4:
								System.out.print("Please enter the price: ");
								library[bookNb].SetPrice(in.nextDouble());
								System.out.println("Information about book #"+bookNb+":\n"+library[bookNb]);
								break;
							case 5:
								break;
							default:
								System.out.println("Please enter a number between 1 and 5");
								break;
							
						}	
					}
					break;
					
				case 3:
					
					//Search algorithm for an author
					
					System.out.println("Please enter the author you are looking for: ");
					in.nextLine();
					String author = in.nextLine();
					System.out.println("Here are the results: ");
					boolean exist3=false;
					for (int i=0;i<index;i++) {
						if (author.equals(library[i].GetAuthor())) {
							exist3=true;
							System.out.println(library[i]);
						}
					}
					if (!exist3) {
						System.out.println("We don't have any books from that author.");
					}
					break;
				case 4:
					
					//Search algorithm for a budget.
					
					System.out.print("Please enter your maximum budjet: ");
					double tempP = in.nextDouble();
					System.out.println("Here are the results: ");
					boolean exist4=false;
					for (int i=0;i<index;i++) {
						if (tempP >= library[i].GetPrice()) {
							exist4=true;
							System.out.println(library[i]);
						}
					}
					if (!exist4) {
						System.out.println("We don't have any books whithin that budjet.");
					}
					break;
				case 5:
					
					//Empty than #5 does not meet the condition to restart the loop. 
					
					break;
				default:
					
					//To prevent wrong inputs. 
					
					System.out.println("Please enter a number from 1 to 5.");
					break;
			}
		}
		System.out.println("Thank you for using the Library Management System. By Samuel Vachon. ");														//PG Inc.
		in.close();
	}

}
