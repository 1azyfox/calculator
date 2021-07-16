import java.nio.charset.StandardCharsets;

public class Transfer {
    public static int romeToArabTransfer(String term) throws MyException {
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
                arabDigit = (FindOperation.findNumberInArray(romeNumberAsciiArray, sumTerm));
            }
        }
        if (arabDigit == 0) {
            throw new MyException("неверный ввод римского числа");
        }
        return arabDigit;
    }

    public static StringBuilder arabToRomeTransfer(int answer) {
        StringBuilder sb = new StringBuilder();
        int a = answer / 10;
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