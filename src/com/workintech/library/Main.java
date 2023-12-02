package com.workintech.library;


import com.workintech.library.books.Book;
import com.workintech.library.books.enums.BookStatus;
import com.workintech.library.books.enums.BookType;
import com.workintech.library.person.Librarian;
import com.workintech.library.person.Reader;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Set<Reader> readers = new HashSet<>();
        List<Book> returned = new ArrayList<>();
        Librarian librarian = new Librarian(1,"Ahmet", "Yalçınkaya", "123456");

        // RETURNED KISMINDA KALDIM !!! İŞLEM GERÇEKLEŞİYOR MU BAK!!
        // GEREKLİ COMPONENTLARA GEREKLİ METOTLARI YAZ VE
        // METOT ÜZERİNDEN İŞLEMLERİ
        // YAPTIR

        Library library = new Library(new ArrayList<>(), readers, new HashMap<>(), returned,librarian);

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
        librarian.borrowBook(library.getBooks(), library.getBorrowedBooks(), reader1, book3 );

        readers.add(reader1);
        readers.add(reader2);
        readers.add(reader3);
        readers.add(reader4);
        readers.add(reader5);
        readers.add(reader1); // Set olduğu için kullanıcı tekrar eklenmez !



        System.out.println(library.getBooks());
//        System.out.println(readers);
//        System.out.println(borrowed);

    }
}