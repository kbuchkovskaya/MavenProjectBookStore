package bookStore.book;

/**
 * Paper book cover type
 */
public enum CoverType {

    SOFT("Soft"), TOUGH("Tough");

    private String coverType;

    CoverType(String coverType) {
        this.coverType = coverType;
    }
}

