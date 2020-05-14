package bookStore.book;

import java.util.EnumSet;
import java.util.Set;

/**
 * Audio book language
 */
public enum BookLanguage {

    UKR("Ukrainian"), ENG("English"), RUS("Russian"), IT("Italian");

    String bookLanguage;

    BookLanguage(String bookLanguage) {
        this.bookLanguage = bookLanguage;
    }
}
