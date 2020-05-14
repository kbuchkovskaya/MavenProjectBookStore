package bookStore.exeption;

public class EmptyListExeption extends Exception {
    private static final String EMPTY_LIST = "Empty list ";

    public EmptyListExeption() {
        super(EMPTY_LIST);
    }
}

