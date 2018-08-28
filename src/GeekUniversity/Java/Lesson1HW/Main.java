package GeekUniversity.Java.Lesson1HW;

public class Main {
    public static void main(String[] args) {
        Algoritm algoritm = new Algoritm();

        long[] numbers = { 874, 984, 876, 34, 908, 674, 84, 50, 743, 74, 856};

        System.out.println(algoritm.fastPow(4,9));
        System.out.println(algoritm.fastPow(4,10));
        System.out.println(algoritm.minNumber(numbers));
        System.out.println(algoritm.recursMinNumber(numbers,numbers.length));
        System.out.println(algoritm.avgNumber(numbers));
    }
}