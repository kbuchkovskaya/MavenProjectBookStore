package bookStore.exeption;

public class IncorrectInputDataExeption extends Exception {
    private static final String INCORRECT_INPUT_DATA = "Incorrect input data!";

    public IncorrectInputDataExeption() {
        super(INCORRECT_INPUT_DATA);
    }
}

