package bookStore.book;

/**
 * Paper book size
 */
public enum Size {

    SMALL("Small"), MEDIUM("Medium"), LARGE("Large");

    private String size;

    Size(String size) {
        this.size = size;
    }
}
