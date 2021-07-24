package calculator;

import calculator.service.checker.Checker;
import calculator.exception.CalculatorExceptions;
import calculator.execution.Execution;
import calculator.insert.Insert;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        for (; ; ) {
            System.out.println("Для начала рассчетов введите 'start'" + "\nЧтобы выйти из программы введите 'quit'");
            Scanner expression = new Scanner(System.in);
            String expressionString = expression.nextLine();
            if (expressionString.equals("start")) {
                try {
                    System.out.println("Введите выражение: ");
                    String expressionString1 = expression.nextLine();
                    Execution.execution(Insert.reader(expressionString1));
                    System.out.println("Конец расчетов");
                } catch (CalculatorExceptions e) {
                    System.err.println(e.getMessage());
                } catch (NoSuchElementException e) {
                    System.err.println("Недопустимый ввод" + "\nВыход из программы");
                    System.exit(0);
                }
            } else if (expressionString.equals("quit")) {
                System.out.println("Выход...");
                System.exit(0);
            } else {
                try {
                    System.out.println("Решили начать сразу?");
                    if (Checker.isFullCheckUp(Insert.reader(expressionString))) {
                        Execution.execution(Insert.reader(expressionString));
                    }
                } catch (CalculatorExceptions e) {
                    System.err.println("Неверный ввод" + "\nВыход из программы");
                    System.exit(0);
                } catch (NoSuchElementException ex) {
                    System.err.println("Недопустимый ввод" + "\nВыход из программы");
                    System.exit(0);
                }
            }
        }
    }
}




