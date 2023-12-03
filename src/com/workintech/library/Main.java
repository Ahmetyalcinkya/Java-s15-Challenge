package com.workintech.library;


import com.workintech.library.books.Book;
import com.workintech.library.books.enums.BookStatus;
import com.workintech.library.books.enums.BookType;
import com.workintech.library.person.Author;
import com.workintech.library.person.Librarian;
import com.workintech.library.person.Person;
import com.workintech.library.person.Reader;
import com.workintech.library.person.enums.Role;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Book> returned = new ArrayList<>();
        Librarian librarian = new Librarian(1,"Ahmet", "Yalçınkaya", "123456");

        Library library = new Library(new ArrayList<>(), new HashSet<>(), new HashSet<>(), new HashMap<>(), returned,librarian);
        Person author1 = new Author(1,"Khaled","Hosseini");

        //books
        Book book1 = new Book(1,"Kuyruklu Yıldızın Peşinde","Haruki Murakami",2, BookStatus.UNDAMAGED, BookType.ADVENTURE,35);
        Book book2 = new Book(2,"Zaman Makinesi","H.G. Wells",4, BookStatus.UNDAMAGED, BookType.SCIENCEFICTION,30);
        Book book3 = new Book(3,"Göçebe Rüzgarlar","Khaled Hosseini",5, BookStatus.UNDAMAGED, BookType.ADVENTURE,55);
        Book book4 = new Book(4,"Kara Prizma","Brent Weeks",1, BookStatus.UNDAMAGED, BookType.FANTASTIC,50);
        Book book5 = new Book(5,"Bilinçaltı ve Bilinçdışı","Sigmund Freud",7, BookStatus.UNDAMAGED, BookType.PSYCHOLOGY,40);
        //readers
        Reader reader1 = new Reader(1,"Doğancan","Kınık");
        Reader reader2 = new Reader(2,"Emre","Şahiner");
        Reader reader3 = new Reader(3,"Erhan","Firat");
        Reader reader4 = new Reader(4,"Gökhan","Özdemir");
        Reader reader5 = new Reader(5,"Emrah","Kızıltan");
        //borrowed
        library.getBorrowedBooks().put(book2,reader5);

        //Kitap eklendi
        librarian.addBook(library.getBooks(), book3);
        //Kitap olduğu için tekrar eklenemez.
        librarian.addBook(library.getBooks(), book3);

        // Kitap kütüphaneye eklenmediği için silinemez.
        librarian.deleteBook(library.getBooks(), book4);
        // Kitap fiyatı güncellendi.
        librarian.updateBook(library.getBooks(), book3, 100);
        // Kitap fiyatı güncellenemedi kitaplıkta yok.
        librarian.updateBook(library.getBooks(), book5, 50);
        // Kitap durumu güncellendi.
        librarian.updateBook(library.getBooks(), book3, BookStatus.UNUSABLE);
        // Kitap durumu güncellenemedi kitaplıkta yok.
        librarian.updateBook(library.getBooks(), book5, BookStatus.UNUSABLE);
        // Kitap bulundu.
        librarian.findBookByName(library.getBooks(), "Gö");
        // Kitap bulunamadı böyle bir id yok.
        librarian.findBookByID(library.getBooks(), 6);
        // Kitap iade edildi.
        librarian.putReturnedBooksToLibrary(library.getBooks(), book1);

        // Kitap ödünç verildi.
//        librarian.borrowBook(library.getBooks(), library.getBorrowedBooks(), reader1, book3 );

        // Kitap ücreti oluşturuldu.
        librarian.feeReceived(book3, reader1);
        // İade ücerti oluşturuldu.
        librarian.refundedFee(library,library.getBorrowedBooks(), book3, reader1);

        reader1.getPayment();

        library.getReaders().add(reader1);
        library.getReaders().add(reader2);
        library.getReaders().add(reader3);
        library.getReaders().add(reader4);
        library.getReaders().add(reader5);
        library.getReaders().add(reader1); // Set olduğu için kullanıcı tekrar eklenmez !

        Scanner scanner = new Scanner(System.in);
        int choice;
        int userChoice;
        int librarianChoice;
        int readerChoice;
        int authorChoice;

        do {
            System.out.println("Welcome to library !");
            System.out.println("------------------------");
            System.out.println("0 -> Stop the application.");
            System.out.println("1 -> Choose the user.");
            System.out.println("2 -> Show all the books in library.");
            switch (choice){
                case 0:
                    System.out.println("The application is being stopped.");
                    scanner.close();
                    break;
                case 1:
                    switch (userChoice){
                        System.out.println("1 -> Librarian");
                        System.out.println("2 -> Reader");
                        System.out.println("3 -> Author");
                        case 1:
                            switch (librarianChoice){
                                System.out.println("1 -> Add Book");
                                System.out.println("2 -> Delete Book");
                                System.out.println("3 -> Update Book");
                                System.out.println("4 -> Find Book");
                                case 1:
                                    System.out.println("Book id :");
                                    long bookId = scanner.nextLong();
                                    System.out.println("Book title :");
                                    String bookTitle = scanner.nextLine();
                                    System.out.println("Book author :");
                                    String bookAuthor = scanner.nextLine();
                                    System.out.println("Book stock :");
                                    int bookStock = scanner.nextInt();
                                    System.out.println("Book type (Type must be one of these : HISTORICAL,ROMANCE," +
                                            "HORROR,SCIENCEFICTION,FANTASTIC,ADVENTURE,PSYCHOLOGY,SCIENCE) :");
                                    String bookType = scanner.nextLine().toUpperCase();
                                    BookType type = BookType.valueOf(bookType);
                                    System.out.println("Book price :");
                                    double bookPrice = scanner.nextDouble();

                                    Book newBook = new Book(bookId,bookTitle,bookAuthor,
                                            bookStock,BookStatus.UNDAMAGED, type, bookPrice);
                                    librarian.addBook(library.getBooks(), newBook);
                                    break;
                                case 2:
                                    System.out.println("Book Title :");
                                    String bookName = scanner.nextLine();
                                    Book foundBook = librarian.findBookByName(library.getBooks(), bookName);
                                    librarian.deleteBook(library.getBooks(),foundBook);
                                    break;
                                case 3:
                                    System.out.println("Book Title :");
                                    String bookNameUpdate = scanner.nextLine();
                                    Book updateTheBook = librarian.findBookByName(library.getBooks(), bookNameUpdate);
                                    System.out.println("New book price :");
                                    double updatedBookPrice = scanner.nextDouble();
                                    librarian.updateBook(library.getBooks(),updateTheBook,updatedBookPrice);

                                    System.out.println("New book status :");
                                    System.out.println("Book status (Status must be one of these : UNDAMAGED, SLIGHTLYDAMAGED, DAMAGED, USUSABLE) :");
                                    String bookStatus = scanner.nextLine().toUpperCase();
                                    BookStatus status = BookStatus.valueOf(bookStatus);
                                    librarian.updateBook(library.getBooks(),updateTheBook,status);
                                    break;
                                case 4:
                                    System.out.println("Find Book by Name :");
                                    String bookByName = scanner.nextLine();
                                    librarian.findBookByName(library.getBooks(), bookByName);
                                    System.out.println("Find Book by ID :");
                                    long bookById = scanner.nextLong();
                                    librarian.findBookByID(library.getBooks(), bookById);
                                    break;
                                default:
                                    System.out.println("Please enter a valid value!");
                                    break;

                            }
                            break;
                        case 2:
                            System.out.println("Select reader :");
                            String readerName = scanner.nextLine();
                            Reader getReader = librarian.findReader(library.getReaders(), readerName);
                            switch (readerChoice){
                                System.out.println("1 -> Borrow Book");
                                System.out.println("2 -> Return Book");
                                System.out.println("3 -> Get balance info");
                                System.out.println("3 -> Get limit");
                                case 1:
                                    System.out.println("Get the book you want :");
                                    String getBookName = scanner.nextLine();
                                    Book getBook = librarian.findBookByName(library.getBooks(), getBookName);
                                    librarian.borrowBook(library.getBooks(), library.getBorrowedBooks(),getReader,getBook);
                                    librarian.feeReceived(getBook,getReader);
                                    break;
                                case 2:
                                    System.out.println("Write book that you want to return :");
                                    String returnedBook = scanner.nextLine();
                                    Book getreturnedBook = librarian.findBookByName(library.getBooks(), returnedBook);
                                    librarian.refundedFee(library, library.getBorrowedBooks(), getreturnedBook, getReader);
                                    break;
                                case 3:
                                    System.out.println(getReader.getBalance());
                                    break;
                                case 4:
                                    System.out.println(getReader.getLimit());
                                    break;
                                default:
                                    System.out.println("Please enter a valid value!");
                            }
                            break;
                        case 3:
                            System.out.println("Select author :");
                            String authorName = scanner.nextLine();
                            Author getAuthor = librarian.findAuthor(library.getAuthors(), authorName);
                            switch (authorChoice){
                                System.out.println("1 -> Add Book");
                                System.out.println("2 -> Delete Book");
                                System.out.println("3 -> Update Book");
                                System.out.println("4 -> Get the Author's Books");
                                case 1:
                                    System.out.println("Book id :");
                                    long bookId = scanner.nextLong();
                                    System.out.println("Book title :");
                                    String bookTitle = scanner.nextLine();
                                    System.out.println("Book stock :");
                                    int bookStock = scanner.nextInt();
                                    System.out.println("Book type (Type must be one of these : HISTORICAL,ROMANCE," +
                                            "HORROR,SCIENCEFICTION,FANTASTIC,ADVENTURE,PSYCHOLOGY,SCIENCE) :");
                                    String bookType = scanner.nextLine().toUpperCase();
                                    BookType type = BookType.valueOf(bookType);
                                    System.out.println("Book price :");
                                    double bookPrice = scanner.nextDouble();

                                    Book newBook = new Book(bookId,bookTitle,getAuthor.getName() + getAuthor.getSurname(),
                                            bookStock,BookStatus.UNDAMAGED, type, bookPrice);
                                    getAuthor.addBook(library.getBooks(), newBook);
                                    break;
                                case 2:
                                    System.out.println("Book Title :");
                                    String bookName = scanner.nextLine();
                                    Book foundBook = librarian.findBookByName(library.getBooks(), bookName);
                                    if(foundBook.getAuthor().contains(getAuthor.getName())){
                                        getAuthor.deleteBook(library.getBooks(),foundBook);
                                    }else {
                                        System.out.println("You cannot delete somebody else's book.");
                                    }
                                    break;
                                case 3:
                                    System.out.println("Book Title :");
                                    String bookNameUpdate = scanner.nextLine();
                                    Book updateTheBook = librarian.findBookByName(library.getBooks(), bookNameUpdate);
                                    System.out.println("New book price :");
                                    double updatedBookPrice = scanner.nextDouble();
                                    getAuthor.updateBook(library.getBooks(),updateTheBook,updatedBookPrice);

                                    System.out.println("New book status :");
                                    System.out.println("Book status (Status must be one of these : UNDAMAGED, SLIGHTLYDAMAGED, DAMAGED, USUSABLE) :");
                                    String bookStatus = scanner.nextLine().toUpperCase();
                                    BookStatus status = BookStatus.valueOf(bookStatus);
                                    getAuthor.updateBook(library.getBooks(),updateTheBook,status);
                                    break;
                                case 4:
                                    break;


                            }
                            break;
                        default:
                            System.out.println("Please enter a valid value!");
                    }
                case 2:
                    break;
                default:
                    System.out.println("Please enter a valid value!");

            }

        }while (choice != 0);



//        System.out.println(library.getBooks());
//        System.out.println(readers);
//        System.out.println(borrowed);

    }
}