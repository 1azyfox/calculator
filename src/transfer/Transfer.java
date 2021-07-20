package transfer;

import exceptions.CalculatorExceptions;
import operation.FindOperation;
import rome.RomeNumber;

import java.nio.charset.StandardCharsets;

public class Transfer {
    public static int romeToArabTransfer(String term) throws CalculatorExceptions {
        byte[] asciiTerm = term.getBytes(StandardCharsets.US_ASCII);
        int sumTerm = 0;
        for (int i : asciiTerm) {
            sumTerm += i;
        }
        int arabDigit = 0;
        int romeNumberAmount = RomeNumber.values().length;
        int[] romeNumberAsciiArray = new int[romeNumberAmount];
        int x = 0;
        for (RomeNumber romeNumber : RomeNumber.values()) {
            for (; x < romeNumberAmount; ) {
                romeNumberAsciiArray[x] = romeNumber.getAsciiSum();
                break;
            }
            x++;
        }
        for (int y : romeNumberAsciiArray) {
            if (sumTerm == y) {
                if (sumTerm == RomeNumber.IV.getAsciiSum() & sumTerm == RomeNumber.VI.getAsciiSum()) {
                    if (asciiTerm[0] == RomeNumber.I.getAsciiSum()) {
                        arabDigit = (findNumberInArray(romeNumberAsciiArray, sumTerm));
                        return arabDigit;
                    } else if (asciiTerm[0] == RomeNumber.V.getAsciiSum()) {
                        arabDigit = 6;
                        return arabDigit;
                    }
                }
                arabDigit = (findNumberInArray(romeNumberAsciiArray, sumTerm));
            }
        }
        if (arabDigit == 0) {
            throw new CalculatorExceptions(CalculatorExceptions.ROME_NUMBER_INSERT_WRONG);
        }
        return arabDigit;
    }

    public static int findNumberInArray(int[] inArray, int needFind) {
        for (int i = 0; i < inArray.length; i++) {
            if (needFind == inArray[i]) {
                return i + 1;
            }
        }
        return 0;
    }

    public static StringBuilder arabToRomeTransfer(int answer) throws CalculatorExceptions {
        StringBuilder sb = new StringBuilder();
        int a = answer / 10;
        if (answer == 0) {
            throw new CalculatorExceptions(CalculatorExceptions.ROME_ZERO_DOES_NOT_EXIST);
        }
        if (a <= 3) {
            for (int i = 0; i < a; i++) {
                sb.append('X');
            }
            int b = answer / 5;
            int d = answer % 10;
            if (b >= 1 & b % 2 != 0 & d != 9) {
                sb.append('V');
            }
            int c = answer % 5;
            if (c == 1) {
                sb.append('I');
            }
            if (c == 2) {
                sb.append("II");
            }
            if (c == 3) {
                sb.append("III");
            }
            if (d == 4) {
                sb.append("IV");
            }
            if (d == 9) {
                sb.append("IX");
            }
        } else {
            if (a == 4) {
                sb.append("XL");
                int b = answer / 5;
                int d = answer % 10;
                if (b >= 1 & b % 2 != 0 & d != 9) {
                    sb.append('V');
                }
                int c = answer % 5;
                if (c == 1) {
                    sb.append('I');
                }
                if (c == 2) {
                    sb.append("II");
                }
                if (c == 3) {
                    sb.append("III");
                }
                if (d == 4) {
                    sb.append("IV");
                }
                if (d == 9) {
                    sb.append("IX");
                }
            } else {
                if (a < 9) {
                    sb.append('L');
                    for (int i = 0; i < a - 5; i++) {
                        sb.append('X');
                    }
                    int b = answer / 5;
                    int d = answer % 10;
                    if (b >= 1 & b % 2 != 0 & d != 9) {
                        sb.append('V');
                    }
                    int c = answer % 5;
                    if (c == 1) {
                        sb.append('I');
                    }
                    if (c == 2) {
                        sb.append("II");
                    }
                    if (c == 3) {
                        sb.append("III");
                    }
                    if (d == 4) {
                        sb.append("IV");
                    }
                    if (d == 9) {
                        sb.append("IX");
                    }
                } else {
                    if (a < 10) {
                        sb.append("XC");
                        int b = answer / 5;
                        int d = answer % 10;
                        if (b >= 1 & b % 2 != 0 & d != 9) {
                            sb.append('V');
                        }
                        int c = answer % 5;
                        if (c == 1) {
                            sb.append('I');
                        }
                        if (c == 2) {
                            sb.append("II");
                        }
                        if (c == 3) {
                            sb.append("III");
                        }
                        if (d == 4) {
                            sb.append("IV");
                        }
                        if (d == 9) {
                            sb.append("IX");
                        }
                    } else {
                        if (a == 10) {
                            sb.append('C');
                        }
                    }
                }
            }
        }
        return sb;
    }
}