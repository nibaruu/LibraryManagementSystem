public interface Actions {


        void addBook(Book book);
        void removeBook(String title);
        void showBooks();
        void searchBook(String title);
        void borrowBook(int userId, String title);
        void returnBook(int userId, String title);
        int countBooks();
        boolean isAvailable(String title);
        void registerUser(User user);
        void removeUser(User user);
         String findUser(int userId);


}
