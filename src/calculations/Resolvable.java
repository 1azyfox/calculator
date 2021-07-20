package calculations;

public interface Resolvable {
    static int add(int firstTerm, int secondTerm){
        return firstTerm + secondTerm;
    }
    static int subtract(int firstTerm, int secondTerm){
        return firstTerm - secondTerm;
    }
    static int multiply(int firstTerm, int secondTerm) {
        return firstTerm * secondTerm;
    }
    static int divide(int firstTerm, int secondTerm) {
        return firstTerm / secondTerm;
    }
}
