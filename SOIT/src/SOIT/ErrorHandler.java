package SOIT;

import java.io.IOException;

public interface ErrorHandler {
    void checkEmptyFields(String[] args) throws IOException;
    void keyChecker(String[] args) throws IOException;
}