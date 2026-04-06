import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Library library = new Library();
        Scanner sc = new Scanner(System.in);
        int nextBookId = 1;

        while (true) {
            showmenu();
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("Enter book title:");
                    String title = sc.nextLine();

                    System.out.println("Enter book author:");
                    String author = sc.nextLine();

                    library.addBook(new Book(nextBookId++, title, author));
                    System.out.println("Book added successfully.");
                    break;

                case 2:
                    System.out.println("Enter book title to remove:");
                    String removeTitle = sc.nextLine();
                    library.removeBook(removeTitle);
                    break;

                case 3:
                    library.showBooks();
                    break;

                case 4:
                    System.out.println("Enter book title to search:");
                    String searchTitle = sc.nextLine();
                    library.searchBook(searchTitle);
                    break;

                case 5:
                    System.out.println("Enter user ID:");
                    int userId = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter book title to borrow:");
                    String borrowTitle = sc.nextLine();

                    library.borrowBook(userId, borrowTitle);
                    break;

                case 6:
                    System.out.println("Enter user ID:");
                    int returnUserId = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter book title to return:");
                    String returnTitle = sc.nextLine();

                    library.returnBook(returnUserId, returnTitle);
                    break;

                case 7:
                    System.out.println("Total books: " + library.countBooks());
                    break;

                case 8:
                    System.out.println("Enter book title:");
                    String availTitle = sc.nextLine();

                    boolean available = library.isAvailable(availTitle);
                    System.out.println(available ? "Available" : "Not available");
                    break;

                case 9:
                    System.out.println("Enter user ID:");
                    int uid = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter user name:");
                    String name = sc.nextLine();

                    library.registerUser(new User(uid, name));
                    System.out.println("User registered successfully.");
                    break;

                case 10:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    static void showmenu() {
        System.out.println("\n////Library Management System////");
        System.out.println("1. Add Book");
        System.out.println("2. Remove Book");
        System.out.println("3. Show Books");
        System.out.println("4. Search Book");
        System.out.println("5. Borrow Book");
        System.out.println("6. Return Book");
        System.out.println("7. Count Books");
        System.out.println("8. Check Availability");
        System.out.println("9. Register User");
        System.out.println("10. Exit");
        System.out.print("Enter your choice: ");
    }
}
