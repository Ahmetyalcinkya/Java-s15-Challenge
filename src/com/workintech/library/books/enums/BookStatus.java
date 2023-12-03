package com.workintech.library.books.enums;

import java.util.Random;

public enum BookStatus {

    UNDAMAGED,
    SLIGHTLYDAMAGED,
    DAMAGED,
    UNUSABLE;

    // Kütüphanecinin rastgele durum belirlemesi için static bir metot oluşturuldu.
    public static BookStatus randomStatus(){
        BookStatus[] bookStatuses = BookStatus.values();
        Random random = new Random();
        int randomIndex = random.nextInt(bookStatuses.length);
        System.out.println(bookStatuses[randomIndex]);
        return bookStatuses[randomIndex];
    }

}
