package main;

import checker.Checker;
import exceptions.CalculatorExceptions;
import execution.Execution;
import insert.Insert;


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
                    String expressionString1 = expression.nextLine();
                    Execution.Execution(Insert.reader(expressionString1));
                    System.out.println("Конец расчетов");
                } catch (CalculatorExceptions e) {
                    if (e.code == 1) {
                        System.err.println("Неверный ввод римского числа");
//                System.exit(0);
                    } else if (e.code == 2) {
                        System.err.println("Неверный ввод операции");
//                System.exit(0);
                    } else if (e.code == 3) {
                        System.err.println("Введено не целое число");
//                System.exit(0);
                    } else if (e.code == 4) {
                        System.err.println("Несовпадающий формат выражений");
//                System.exit(0);
                    } else if (e.code == 5) {
                        System.err.println("Введенное число за пределами вычислений программы");
//                System.exit(0);
                    }
                } catch (NoSuchElementException e) {
                    System.err.println("Недопустимый ввод" + "\nВыход из программы");
//                    System.exit(0);
                } finally {
                    expression.close();
                }
            } else if (expressionString.equals("quit")) {
                System.out.println("Выход...");
                System.exit(0);
            } else {
                try {
                    System.out.println("Решили начать сразу?");
                    if (Checker.isFullCheckUp(Insert.reader(expressionString))) {
                        Execution.Execution(Insert.reader(expressionString));
                    }
                } catch (CalculatorExceptions e) {
                    System.err.println("Неверный ввод" + "\nВыход из программы");
//                        System.exit(0);
                } catch (NoSuchElementException ex) {
                    System.err.println("Недопустимый ввод" + "\nВыход из программы");
//                        System.exit(0);
                } finally {
                    expression.close();
                }
            }
        }
    }
}




