import java.util.ArrayList;
import java.util.HashMap;

public class Library implements Actions {

    ArrayList<Book> books = new ArrayList<>();
    ArrayList<User> users = new ArrayList<>();
    HashMap<String, Book> booksMap = new HashMap<>();

    @Override
    public void addBook(Book book) {
        books.add(book);
        booksMap.put(book.getTitle().toLowerCase(), book);
    }

    @Override
    public void removeBook(String title) {
        String key = title.toLowerCase();
        Book book = booksMap.get(key);

        if (book != null) {
            books.remove(book);
            booksMap.remove(key);
            System.out.println("Book removed: " + title);
        } else {
            System.out.println("Book not found.");
        }
    }

    @Override
    public void showBooks() {
        for (Book book : books) {
            book.displayInfo();
        }
    }

    @Override
    public void searchBook(String title) {
        Book book = booksMap.get(title.toLowerCase());

        if (book != null) {
            book.displayInfo();
        } else {
            System.out.println("Book not found: " + title);
        }
    }

    //
    @Override
    public void borrowBook(int userId, String title) {
        User user = findUser(userId);
        Book book = booksMap.get(title.toLowerCase());

        if (user == null || book == null) {
            System.out.println("User or Book not found.");
            return;
        }

        if (!book.isAvailable()) {
            System.out.println("Book is already borrowed.");
            return;
        }

        user.borrowBook(book);
        book.setAvailable(false);

        System.out.println(user.getName() + " borrowed: " + title);
    }

    @Override
    public void returnBook(int userId, String title) {
        User user = findUser(userId);
        Book book = booksMap.get(title.toLowerCase());

        if (user == null || book == null) {
            System.out.println("User or Book not found.");
            return;
        }

        user.returnBook(book);
        book.setAvailable(true);

        System.out.println(user.getName() + " returned: " + title);
    }

    @Override
    public int countBooks() {
        return books.size();
    }

    @Override
    public boolean isAvailable(String title) {
        Book book = booksMap.get(title.toLowerCase());
        return book != null && book.isAvailable();
    }

    @Override
    public void registerUser(User user) {
        users.add(user);
    }


    @Override
    public User findUser(int userId) {
        for (User user : users) {
            if (user.getId() == userId) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void removeUser(User user) {
        users.remove(user);
    }
}
