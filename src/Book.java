public class Book {
    private final int id;
    private final String title;
    private final String author;
    private boolean isAvailable;
    int i=0;
    public Book(int id, String title, String author, boolean isAvailable) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.isAvailable = true;
    }

    public int getId() {
        return id;

    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public boolean isAvailable() {
        return isAvailable;}

    public void setISAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public void borrowBook() {
        isAvailable = false;
    }

    public void returnBook() {
        isAvailable = true;
    }

     public final void displayInfo() {
        System.out.println("Book ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
}
