package Other_Type;
import java.util.ArrayList;
import java.util.List;

class Books{
    private String title;
    private String author;
    private String ISBN;

    public Books(String Title, String Author, String ISBN){
        this.title = Title;
        this.author = Author;
        this.ISBN = ISBN;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public String getISBN(){
        return ISBN;
    }

    public void displayBookInfo() {
        System.out.println("Title: " + title + ", Author: " + author + ", ISBN: " + ISBN);
    }
}

abstract class Person{
    protected String name;
    protected int ID;

    public Person(String name, int ID){
        this.name = name;
        this.ID = ID;
    }

    public abstract void DisplayInfo();
}

class Librarian extends Person{

    private List<Books> managedBook;
    public Librarian(String name, int ID) {
        super(name, ID);
        this.managedBook = new ArrayList<>();
    }

    public void addBook(Books book){
        managedBook.add(book);
        System.out.println("Book added to library: " + book.getTitle());
    }

    public void removeBook(Books book){
        if(managedBook.remove(book)){
            System.out.println("Book removed from library: " + book.getTitle());
        }
        else{
            System.out.println("Book not found in library.");
        }
    }

    @Override
    public void DisplayInfo(){
        System.out.println("Librarian Name: " + name + ", ID: " + ID);
        System.out.println("Managed Books:");
        for(Books book : managedBook){
            book.displayBookInfo();
        }
    }
}

class Member extends Person{
    private List<Books> borrowedBooks;
    
    public Member(String name,int ID){
        super(name, ID);
        this.borrowedBooks = new ArrayList<>();
    }

    public void borrowBook(Books book){
        if(borrowedBooks.size() <= 5){
            borrowedBooks.add(book);
            System.out.println(name + " borrowed the book: " + book.getTitle());
        }
        else{
            System.out.println(name + " cannot borrow more than 5 books!");
        }
    }

    public void returnBook(Books book){
        if(borrowedBooks.remove(book)){
            System.out.println(name + " returned the book: " + book.getTitle());
        }
        else{
            System.out.println(name + " has not borrowed this book.");
        }
    }

    @Override
    public void DisplayInfo(){
        System.out.println("Member Name: " + name + ", ID: " + ID);
        System.out.println("Borrowed Books:");
        for(Books book : borrowedBooks){
            book.displayBookInfo();
        }
    }
}

public class Library {
    public static void main(String[] args) {
        Books book1 = new Books("The Alchemist", "Paulo Coelho", "9780061122415");
        Books book2 = new Books("1984", "George Orwell", "9780451524935");
        Books book3 = new Books("To Kill a Mockingbird", "Harper Lee", "9780060935467");

        Librarian librarian = new Librarian("Janhavi", 145);
        librarian.addBook(book1);
        librarian.addBook(book2);
        librarian.addBook(book3);

        Member member = new Member("Vinay", 129);
        member.borrowBook(book1);
        member.borrowBook(book2);
        member.returnBook(book1);

        // Display Infomation
        System.out.println("\n--- Librarian Info ---");
        librarian.DisplayInfo();

        System.out.println("\n--- Member Info ---");
        member.DisplayInfo();
    }
}
