package calculator.insert;


import calculator.dto.InsertDto;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Insert {
    public static InsertDto reader(String expressionString) throws NoSuchElementException {
        Scanner scanner = new Scanner(expressionString);
            String firstTerm = scanner.next();
            String operation = scanner.next();
            String secondTerm = scanner.next();
        return new InsertDto(firstTerm,operation,secondTerm);
    }
}
