import java.util.Scanner;

class LibSystem {

    Scanner sc = new Scanner(System.in);

    int maxBooks = 100;
    int bookCount = 0;

    int[] bookId = new int[maxBooks];
    String[] bookName = new String[maxBooks];
    String[] bookAuthor = new String[maxBooks];
    String[] bookCategory = new String[maxBooks];
    boolean[] issued = new boolean[maxBooks];

    void addBook() {

        if (bookCount >= maxBooks) {
            System.out.println("Library is full!");
            return;
        }

        System.out.println("\n===== Add Book =====");

        System.out.print("Enter Book ID: ");
        bookId[bookCount] = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Book Name: ");
        bookName[bookCount] = sc.nextLine();

        System.out.print("Enter Book Author: ");
        bookAuthor[bookCount] = sc.nextLine();

        System.out.print("Enter Book Category: ");
        bookCategory[bookCount] = sc.nextLine();

        issued[bookCount] = false;
        bookCount++;

        System.out.println("Book added successfully!");
    }

    void viewBooks() {

        System.out.println("\n===== All Books =====");

        if (bookCount == 0) {
            System.out.println("No books available.");
            return;
        }

        for (int i = 0; i < bookCount; i++) {

            System.out.println("\nBook " + (i + 1));
            System.out.println("ID       : " + bookId[i]);
            System.out.println("Name     : " + bookName[i]);
            System.out.println("Author   : " + bookAuthor[i]);
            System.out.println("Category : " + bookCategory[i]);
            System.out.println("Status   : " +
                    (issued[i] ? "Issued" : "Available"));
        }
    }

    void searchBook() {

        System.out.println("\n===== Search Book =====");

        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();

        boolean found = false;
        for (int i = 0; i < bookCount; i++) {
            if (bookId[i] == id) {
                System.out.println("\nBook Found!");
                System.out.println("ID       : " + bookId[i]);
                System.out.println("Name     : " + bookName[i]);
                System.out.println("Author   : " + bookAuthor[i]);
                System.out.println("Category : " + bookCategory[i]);
                System.out.println("Status   : " +
                        (issued[i] ? "Issued" : "Available"));
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Book not found!");
        }
    }
    void issueBook() {
        System.out.println("\n===== Issue Book =====");
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        for (int i = 0; i < bookCount; i++) {
            if (bookId[i] == id) {
                if (issued[i]) {
                    System.out.println("Book is already issued!");
                } else {
                    issued[i] = true;
                    System.out.println("Book issued successfully!");
                }
                return;
            }
        }
        System.out.println("Book not found!");
    }
    void returnBook() {
        System.out.println("\n===== Return Book =====");
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        for (int i = 0; i < bookCount; i++) {
            if (bookId[i] == id) {
                if (!issued[i]) {
                    System.out.println("Book is already available!");
                } else {
                    issued[i] = false;
                    System.out.println("Book returned successfully!");
                }
                return;
            }
        }
        System.out.println("Book not found!");
    }
    void deleteBook() {
        System.out.println("\n===== Delete Book =====");
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        for (int i = 0; i < bookCount; i++) {
            if (bookId[i] == id) {
                for (int j = i; j < bookCount - 1; j++) {
                    bookId[j] = bookId[j + 1];
                    bookName[j] = bookName[j + 1];
                    bookAuthor[j] = bookAuthor[j + 1];
                    bookCategory[j] = bookCategory[j + 1];
                    issued[j] = issued[j + 1];
                }
                bookCount--;
                System.out.println("Book deleted successfully!");
                return;
            }
        }
        System.out.println("Book not found!");
    }
    void libraryReport() {
        int available = 0;
        int issuedBooks = 0;
        for (int i = 0; i < bookCount; i++) {
            if (issued[i]) {
                issuedBooks++;
            } else {
                available++;
            }
        }
        System.out.println("\n===== Library Report =====");
        System.out.println("Total Books     : " + bookCount);
        System.out.println("Available Books : " + available);
        System.out.println("Issued Books    : " + issuedBooks);
    }
    void menu() {
        System.out.println("\n=================================");
        System.out.println("     LIBRARY MANAGEMENT SYSTEM");
        System.out.println("=================================");
        System.out.println("1. Add Book");
        System.out.println("2. View Books");
        System.out.println("3. Search Book");
        System.out.println("4. Issue Book");
        System.out.println("5. Return Book");
        System.out.println("6. Delete Book");
        System.out.println("7. Library Report");
        System.out.println("8. Exit");
        System.out.println("=================================");
    }
    public static void main(String[] args) {
        LibSystem obj = new LibSystem();
        int choice;
        do {
            obj.menu();
            System.out.print("Enter Choice: ");
            choice = obj.sc.nextInt();
            switch (choice) {
                case 1:
                    obj.addBook();
                    break;
                case 2:
                    obj.viewBooks();
                    break;
                case 3:
                    obj.searchBook();
                    break;
                case 4:
                    obj.issueBook();
                    break;
                case 5:
                    obj.returnBook();
                    break;
                case 6:
                    obj.deleteBook();
                    break;
                case 7:
                    obj.libraryReport();
                    break;
                case 8:
                    System.out.println("Thanks for using Library Management System!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 8);

        obj.sc.close();
    }
}