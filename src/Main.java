import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        for (; ; ) {
            System.out.println("Для начала рассчетов введите 'start'" + "\nЧтобы выйти из программы введите 'quit'");
            Scanner expression = new Scanner(System.in);
            String expressionString = expression.nextLine();
            if (expressionString.equals("start")) {
                try {
                    System.out.println("Введите выражение: ");
                    Scanner scanner = new Scanner(System.in);
                    String expressionString1 = expression.nextLine();
                    Insert.runner(expressionString1);
                    System.out.println("Конец расчетов");
                } catch (MyException e) {
                    System.err.println(e.returnMyMessage() + "\nВыход из программы");
                    System.exit(0);
                }
            } else {
                if (expressionString.equals("quit")) {
                    System.out.println("Выход...");
                    System.exit(0);
                } else {
                    System.out.println("Решили начать сразу?");
                    try {
                        if (!(Insert.runnerIsProblems(expressionString))) {
                            Insert.runner(expressionString);
                        }
                    } catch (MyException e) {
                        System.err.println(e.returnMyMessage() + "\nВыход из программы");
                        System.exit(0);
                    } catch (NoSuchElementException ex) {
                        System.err.println("Ошибка - неправильный формат ввода" + "\nВыход из программы");
                        System.exit(0);
                    }
                }
            }
        }
    }
}

