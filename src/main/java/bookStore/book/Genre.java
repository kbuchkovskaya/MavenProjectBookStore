package bookStore.book;

/**
 * Book's genre
 */
public enum Genre {

    COMEDY("Comedy"), TRAGEDY("Tragedy"), NOVEL("Novel"), ROMAN("Roman"), SONNET("Sonnet"), FAIRYTAIL("Fairytail");

    private String genre;

    Genre(String genre) {
        this.genre = genre;
    }

}


