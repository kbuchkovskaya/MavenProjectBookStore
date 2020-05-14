package bookStore.book;

/**
 * E-book format
 */
public enum EBookType {

    PDF("Pdf"), DOC("Doc"), DJV("Djv");

    private String eBookType;

    EBookType(String eBookType) {
        this.eBookType = eBookType;
    }
}
