import java.util.ArrayList;
public class User {
    private final String name;
    private final int id;
    private ArrayList<Book> borrowedBooks;


    public User(String name, int id ,Book[] listOfBooks) {
        this.name = name;
        this.id = id;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
     public void borrowBook(Book book) {
        borrowedBooks.add(book);
     }
     public void returnBook(Book book) {
        borrowedBooks.remove(book);
     }

    public void getBorrowedBooks() {
        System.out.println("Borrowed Book: " + borrowedBooks.size());
        for (Book book : borrowedBooks) {
             book.displayInfo();
        }
    }

}
